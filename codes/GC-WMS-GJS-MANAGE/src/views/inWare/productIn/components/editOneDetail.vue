<template>
  <div v-if="editShow" class="filter-container">
    <div class="form-title">创建入库单</div>
    <div class="form-body">
      <!-- 原料出库作业 -->
      <el-form
        ref="editForm"
        :rules="rules"
        :model="editForm"
        label-position="right"
        label-width="45%"
        style="width: 95%; margin-bottom: 10px;"
        :disabled="!editDisabled"
      >
        <!-- <el-collapse v-model="activeNames">
        <el-collapse-item :title="'本次损耗重量: ' + getLossWeight(editForm.lossWeight)" name="1">-->
        <!-- <template slot="title">
              本次损耗重量: {{ editForm.lossWeight }}g
        </template>-->
        <el-row>
          <el-col :lg="6">
            <el-form-item label="本次损耗重量"><span style="color: red;">{{ editForm.lossWeight }}&nbsp;g</span></el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="6">
            <el-form-item label="原出库件数">
              <el-input v-model="editForm.sourceQty" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="原出库重量">
              <el-input v-model="editForm.sourceWeight" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="退饼件数" prop="drawbackQty">
              <el-input
                v-model="editForm.drawbackQty"
                clearable
                oninput="value=value.replace(/[^\d]/g,'')"
                @change="changeDrawbackQty"
              />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="退饼重量">
              <el-input v-model="editForm.drawbackWeight" type="number" @change="countLossWeight" disabled/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="6">
            <el-form-item label="样币件数">
              <el-input v-model="editForm.proofCoinQty" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="样币重量" prop="voucherNo">
              <el-input v-model="editForm.proofCoinWeight" type="number" @change="countLossWeight" disabled/>
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="废白件数" prop="wasteWhiteQty">
              <el-input
                v-model="editForm.wasteWhiteQty"
                clearable
                oninput="value=value.replace(/[^\d]/g,'')"
                @change="changeWasteWhiteQty"
              />
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="废白重量">
              <el-input v-model="editForm.wasteWhiteWeight" type="number" @change="countLossWeight" disabled/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="6">
            <el-form-item label="入库人1" prop="outor01Code">
              <el-input
                v-model="editForm.outor01Code"
                type="password"
                auto-complete="new-password"
                clearable
                @change="changeUser1"
                @blur="blurUser(1)"
              />
              {{ editForm.outor01 }}
            </el-form-item>
          </el-col>
          <el-col :lg="6">
            <el-form-item label="入库人2" prop="outor02Code">
              <el-input
                ref="outor02Code"
                v-model="editForm.outor02Code"
                type="password"
                auto-complete="new-password"
                clearable
                @change="changeUser2"
                @blur="blurUser(2)"
              />
              {{ editForm.outor02 }}
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
        <!-- </el-collapse-item>
        <el-collapse-item title="产品明细" name="2">-->
        <!-- 明细列表 -->
        <div class="filter-container" style="padding-bottom: 5px">
          <span style="font-size: 12px; margin-right: 10px;">产品明细</span>
        </div>
        <el-table row-key="id" :data="tableData" border stripe fit highlight-current-row>
          <el-table-column label="NO" prop="id" align="center" width="40" type="index" />
          <el-table-column label="产品名称" align="center" prop="prdMat" min-width="110" />
          <el-table-column label="单枚重量" align="center" prop="perWeight" />
          <el-table-column label="成品件数" align="center" min-width="110">
            <template slot-scope="{ row }">
              <el-input
                v-model="row.subQty"
                oninput="value=value.replace(/[^\d]/g,'')"
                @change="changeQty(row)"
                
              />
            </template>
          </el-table-column>
          <el-table-column label="成品重量" align="center" prop="subWeight">
            <template slot-scope="{ row }">
              <el-input
                v-model="row.subWeight"
                type="number"
                @change="countLossWeight"
                disabled
              />
            </template>
          </el-table-column>
          <el-table-column label="废花件数" align="center" min-width="110">
            <template slot-scope="{ row }">
              <el-input
                v-model="row.wasteFlowerQty"
                oninput="value=value.replace(/[^\d]/g,'')"
                @change="changeWasteFlowerQty(row)"
              />
            </template>
          </el-table-column>
          <el-table-column label="废花重量" align="center" prop="wasteFlowerWeight">
            <template slot-scope="{ row }">
              <el-input
                v-model="row.wasteFlowerWeight"
                type="number"
                @change="countLossWeight"
                disabled
              />
            </template>
          </el-table-column>
        </el-table>
        <!-- </el-collapse-item>
        </el-collapse>-->
      </el-form>

      <div style="text-align: center">
        <el-button type="primary" class="my-but" :disabled="readOnly" @click="confirmClick">确 认 入 库</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { addSubwareIn } from '@/api/sib/subwareIn'
import { getUserByCard } from '@/api/sys/user'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editForm', 'editShow', 'editDisabled', 'matOpt', 'markOpt'],
  data() {
    return {
      readOnly: JSON.parse(sessionStorage.getItem('readOnly')),
      tableData: [{}],
      activeNames: ['1', '2'],
      rules: {
        drawbackQty: [{ required: true, message: '退饼件数不能为空', trigger: 'change' }],
        wasteWhiteQty: [{ required: true, message: '废白件数不能为空', trigger: 'change' }],
        qty: [{ required: true, message: '出库件数不能为空', trigger: 'change' }],
        outor01Code: [{ required: true, message: '入库人1不能为空', trigger: 'change' }],
        outor02Code: [{ required: true, message: '入库人2不能为空', trigger: 'change' }]
      }
    }
  },
  created() {},
  mounted() {},
  methods: {
    // 废白件数改变
    changeWasteWhiteQty(value) {
      if (value && this.editForm.perWeight) {
        this.$set(this.editForm, 'wasteWhiteWeight', (value * this.editForm.perWeight).toFixed(6))
        // this.handlerQty()
      } else {
        this.$set(this.editForm, 'wasteWhiteWeight', '')
      }
      this.countLossWeight()
    },
    // 退饼件数改变
    changeDrawbackQty(value) {
      if (value && this.editForm.perWeight) {
        this.$set(this.editForm, 'drawbackWeight', (value * this.editForm.perWeight).toFixed(6))
        // this.handlerQty()
      } else {
        this.$set(this.editForm, 'drawbackWeight', '')
      }
      this.countLossWeight()
    },
    handlerQty() {
      if (this.editForm.drawbackQty !== '' && this.editForm.wasteWhiteQty !== '' && this.tableData[0].subQty !== '') {
        this.$set(this.tableData[0], 'wasteFlowerQty', (this.editForm.sourceQty - this.editForm.drawbackQty - this.editForm.wasteWhiteQty - this.tableData[0].subQty))
        this.changeWasteFlowerQty(this.tableData[0])
      }
    },
    // 计算成品重量
    changeQty(row) {
      if (row.subQty && row.perWeight) {
        this.$set(row, 'subWeight', (row.subQty * row.perWeight).toFixed(6))
        // this.handlerQty()
      } else {
        this.$set(row, 'subWeight', '')
      }
      this.countLossWeight()
    },
    // 计算废花
    changeWasteFlowerQty(row) {
      if (row.wasteFlowerQty && row.perWeight) {
        this.$set(row, 'wasteFlowerWeight', (row.wasteFlowerQty * row.perWeight).toFixed(6))
      } else {
        this.$set(row, 'wasteFlowerWeight', '')
      }
      this.countLossWeight()
    },
    // 入库人1改变
    changeUser1(value) {
      if (!value) {
        this.$set(this.editForm, 'outor01Code', '')
      }
    },
    // 入库人2改变
    changeUser2(value) {
      if (!value) {
        this.$set(this.editForm, 'outor02Code', '')
      }
    },
    // 获取入库人信息
    async blurUser(type) {
      if (type === 1) {
        if (this.editForm.outor01Code) {
          const { retObj } = await getUserByCard({ cardNumber: this.editForm.outor01Code })
          if (retObj === '' || retObj.realName === '') {
            this.$set(this.editForm, 'outor01', '无此人员')
            this.$set(this.editForm, 'outor01Code', '')
          } else if (JSON.parse(retObj.id) === JSON.parse(this.editForm.creator01Id) || JSON.parse(retObj.id) === JSON.parse(this.editForm.creator02Id)) {
            this.$set(this.editForm, 'outor01', '不能与库管相同')
            this.$set(this.editForm, 'outor01Code', '')
          } else {
            this.$set(this.editForm, 'outor01', retObj.realName)
            this.$set(this.editForm, 'outor01Id', retObj.id)
            this.$refs.outor02Code.focus()
          }
        }
      } else {
        if (this.editForm.outor02Code) {
          const { retObj } = await getUserByCard({ cardNumber: this.editForm.outor02Code })
          if (retObj === '' || retObj.realName === '') {
            this.$set(this.editForm, 'outor02', '无此人员')
            this.$set(this.editForm, 'outor02Code', '')
          } else if (JSON.parse(retObj.id) === JSON.parse(this.editForm.creator01Id) || JSON.parse(retObj.id) === JSON.parse(this.editForm.creator02Id)) {
            this.$set(this.editForm, 'outor02', '不能与库管相同')
            this.$set(this.editForm, 'outor02Code', '')
          } else {
            this.$set(this.editForm, 'outor02', retObj.realName)
            this.$set(this.editForm, 'outor02Id', retObj.id)
          }
        }
      }
    },
    // 计算损耗
    countLossWeight() {
      let tableWeight = 0
      this.tableData.forEach(item => {
        if (item.subWeight !== undefined) {
          tableWeight = tableWeight + parseFloat(item.subWeight === '' ? 0 : item.subWeight)
          tableWeight =
            tableWeight + parseFloat(item.wasteFlowerWeight === '' ? 0 : item.wasteFlowerWeight)
        }
      })
      const lossWeight =
        this.editForm.sourceWeight -
        (isNaN(this.editForm.drawbackWeight) ? 0 : this.editForm.drawbackWeight) -
        (isNaN(this.editForm.wasteWhiteWeight) ? 0 : this.editForm.wasteWhiteWeight) -
        parseFloat(tableWeight)
      this.$set(this.editForm, 'lossWeight', lossWeight.toFixed(6))
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
          if (
            !this.editForm.outor01Id ||
            !this.editForm.outor02Id ||
            this.editForm.outor01Id === this.editForm.outor02Id
          ) {
            this.$message.error('入库人信息不正确')
            return
          }
          let tableQty = 0
          this.tableData.forEach(item => {
            tableQty = tableQty + parseInt(item.subQty === '' ? 0 : item.subQty)
            tableQty = tableQty + parseInt(item.wasteFlowerQty === '' ? 0 : item.wasteFlowerQty)
          })
          const total =
            parseFloat(this.editForm.drawbackQty) +
            parseFloat(this.editForm.wasteWhiteQty) +
            parseFloat(tableQty)
          if (total !== this.editForm.sourceQty) {
            this.$message.error('原出库件数不等于(退饼件数+废白件数+成品件数+废花件数)')
            return
          }
          if (this.editForm.lossWeight > 0 || this.editForm.lossWeight < 0) {
            this.$message.error('本次损耗重量不为零，无法保存')
            return
          }
          const { code, msg } = await addSubwareIn({ subware: this.editForm, details: this.tableData })
          if (code === 0) {
            this.$message.success(msg)
          }
          this.$emit('initParam')
          this.clear()
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
::v-deep label {
  font-weight: 500;
}
::v-deep.el-collapse {
  border-top: none;
  border-bottom: none;
  padding-bottom: 10px;
  .el-collapse-item__wrap {
    border-bottom: none;
  }
  .el-collapse-item__content {
    padding-bottom: 0px;
  }
}
::v-deep .el-form-item--mini.el-form-item {
  margin-bottom: 16px;
}
</style>
