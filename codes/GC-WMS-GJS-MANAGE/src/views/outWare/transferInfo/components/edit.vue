<template>
  <div class="filter-container">
    <div class="form-title">创建出库单</div>
    <div class="form-body">
      <!-- 原料出库作业 -->
      <el-form
        ref="editForm"
        :rules="rules"
        :model="editForm"
        label-position="right"
        label-width="45%"
        style="width: 95%;"
        :disabled="!editDisabled"
      >
        <el-row>
          <el-col :lg="6">
            <el-form-item label="出库仓库">
              <el-input v-model="editForm.ware" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="拨入仓库" prop="wareToId">
              <el-select v-model="editForm.wareToId" class="filter-item">
                <el-option
                  v-for="item in otherWareOpt"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="出库物料">
              <el-input v-model="editForm.mat" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="物料规格">
              <el-input v-model="editForm.spec" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="6">
            <el-form-item label="单枚重量">
              <el-input v-model="editForm.perWeight" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="出库件数" prop="qty">
              <el-input
                ref="qty"
                v-model="editForm.qty"
                clearable
                oninput="value=value.replace(/[^\d]/g,'')"
                @change="changeQty"
              />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="出库重量">
              <el-input v-model="editForm.totalWeight" type="number" disabled/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="6">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="editForm.remark" clearable />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="负责人" prop="principalCode">
              <el-input
                v-model="editForm.principalCode"
                type="password"
                auto-complete="new-password"
                clearable
                @change="changeUser1"
                @blur="blurUser()"
              />
              {{ editForm.principal }}
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="6">
            <el-form-item label="库管1">
              <el-input v-model="editForm.creator01" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="库管2">
              <el-input v-model="editForm.creator02" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <div class="text-center">
          <el-button
            type="primary"
            class="my-but"
            :disabled="readOnly"
            @click="confirmClick"
          >确 认 出 库</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { addAllocateTransfer } from '@/api/sib/allocateTransfer'
import { getUserByCard } from '@/api/sys/user'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editForm', 'editDisabled', 'otherWareOpt'],
  data() {
    return {
      readOnly: JSON.parse(sessionStorage.getItem('readOnly')),
      str01: '',
      rules: {
        wareToId: [{ required: true, message: '请选择拨入仓库', trigger: 'change' }],
        qty: [{ required: true, message: '出库件数不能为空', trigger: 'change' }],
        // remark: [{ required: true, message: '备注不能为空', trigger: 'change' }],
        principalCode: [{ required: true, message: '负责人不能为空', trigger: 'change' }]
      }
    }
  },
  created() {},
  mounted() {},
  methods: {
    // 出库件数改变
    changeQty(value) {
      if (value && this.editForm.perWeight) {
        this.$set(this.editForm, 'totalWeight', (value * this.editForm.perWeight).toFixed(6))
        if (this.editForm.qty > this.editForm.allQty) {
          this.$message.error('出库件数不能大于库存件数')
          this.$set(this.editForm, 'totalWeight', '')
          this.$set(this.editForm, 'qty', '')
          this.$refs.qty.focus()
          this.clear()
        }
      } else {
        this.$set(this.editForm, 'totalWeight', '')
      }
    },
    // 清除验证
    clear() {
      this.$nextTick(() => {
        this.$refs.editForm.clearValidate()
      })
    },
    // 提交
    confirmClick() {
      this.$refs.editForm.validate(async valid => {
        if (valid) {
          if (!this.editForm.principalId) {
            this.$message.error('负责人信息不正确')
            return
          }
          const { code, msg } = await addAllocateTransfer({ ...this.editForm })
          if (code === 0) {
            this.$message.success(msg)
          }
          this.$emit('initParam')
          this.clear()
        } else {
          return false
        }
      })
    },
    // 负责人改变
    changeUser1(value) {
      if (!value) {
        this.$set(this.editForm, 'principalCode', '')
      }
    },

    // 获取负责人信息
    async blurUser() {
      if (this.editForm.principalCode) {
        const { retObj } = await getUserByCard({ cardNumber: this.editForm.principalCode, roleId: 5 })
        if (retObj === '' || retObj.realName === '') {
          this.$set(this.editForm, 'principal', '无此人员')
          this.$set(this.editForm, 'principalCode', '')
        } else {
          this.$set(this.editForm, 'principal', retObj.realName)
          this.$set(this.editForm, 'principalId', retObj.id)
        }
      }
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
// ::v-deep .el-form-item__label {
  // font-size: 12px;
// }
::v-deep label {
  font-weight: 500;
}
</style>

