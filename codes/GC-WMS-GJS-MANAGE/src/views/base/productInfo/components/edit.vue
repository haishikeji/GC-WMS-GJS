<template>
  <div class="filter-container">
    <!-- 物料信息表表单 -->
    <el-dialog :title="textMap[editType]+'物料信息表'" :visible.sync="editShow" :before-close="handleClose" :close-on-click-modal="false">
      <el-form ref="editForm" :rules="rules" :model="editForm" label-position="right" label-width="7rem" style="width: 90%; margin-left:2%;">
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="物料名称" prop="mat">
              <el-input v-model="editForm.mat" />
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="单枚单位" prop="unit">
              <el-input v-model="editForm.unit" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="单枚重量" prop="perWeight">
              <el-input v-model="editForm.perWeight" type="number" @change="changeWeight" />
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="规格" prop="spec">
              <el-input v-model="editForm.spec" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="原材料大类" prop="categoryId">
              <el-select v-model="editForm.categoryId">
                <el-option
                  v-for="item in categoryOpt"
                  :key="item.val"
                  :label="item.name"
                  :value="item.val"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="原材料成色" prop="purityId">
              <el-select v-model="editForm.purityId">
                <el-option
                  v-for="item in purityOpt"
                  :key="item.val"
                  :label="item.name"
                  :value="item.val"
                />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="产成品类型" prop="prdTypeId">
              <el-select v-model="editForm.prdTypeId">
                <el-option
                  v-for="item in prdOpt"
                  :key="item.val"
                  :label="item.name"
                  :value="item.val"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="" prop="" />
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="handleClose">关 闭</el-button>
        <el-button v-show="editType!=='view'" type="primary" :disabled="isDisable" @click="confirmClick">保 存</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getMaterialInfo, addProductInfo, updateMaterialProduct } from '@/api/sib/materialInfo'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editShow', 'editType', 'editId', 'categoryOpt', 'purityOpt', 'prdOpt'],
  data() {
    return {
      isDisable: false,
      editForm: {
        unit: 'g'
      },
      textMap: {
        update: '编辑',
        add: '新增',
        view: '查看'
      },
      rules: {
        mat: [{ required: true, message: '物料名称不能为空', trigger: 'change' }],
        unit: [{ required: true, message: '单枚单位不能为空', trigger: 'change' }],
        perWeight: [{ required: true, message: '单枚重量不能为空', trigger: 'change' }],
        spec: [{ required: true, message: '规格不能为空', trigger: 'change' }],
        categoryId: [{ required: true, message: '请选择原材料大类', trigger: 'change' }],
        purityId: [{ required: true, message: '请选择原材料成色', trigger: 'change' }],
        prdTypeId: [{ required: true, message: '请选择产成品类型', trigger: 'change' }]
      }
    }
  },
  created() {
    if (this.editType === 'update') {
      this.getData()
    } else {
      this.$set(this.editForm, 'spec', 'Ф')
    }
  },
  mounted() {

  },
  methods: {
    // 补齐单枚重量
    changeWeight(val) {
      if (val) {
        this.$set(this.editForm, 'perWeight', parseFloat(val).toFixed(6))
      }
    },
    // 信息详情
    async getData() {
      const { code, retObj } = await getMaterialInfo({ id: this.editId })
      if (code === 0) {
        this.editForm = retObj
        this.$set(this.editForm, 'perWeight', retObj.perWeight.toFixed(6))
        this.$set(this.editForm, 'categoryId', retObj.categoryId + '')
        this.$set(this.editForm, 'purityId', retObj.purityId + '')
        this.$set(this.editForm, 'prdTypeId', retObj.prdTypeId + '')
      }
    },
    // 关闭窗口
    handleClose(index) {
      this.$parent.toggleEdit(false, index)
    },
    // 提交
    confirmClick() {
      this.$refs.editForm.validate(async valid => {
        if (valid) {
          this.isDisable = true
          if (this.editType === 'update') {
            const { code, msg } = await updateMaterialProduct({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          } else {
            const { code, msg } = await addProductInfo({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          }
          this.isDisable = false
          this.handleClose(1)
        } else {
          return false
        }
      })
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
/* 取消input的上下箭头 */
::v-deep input::-webkit-inner-spin-button {
  -webkit-appearance: none !important;
}
</style>

