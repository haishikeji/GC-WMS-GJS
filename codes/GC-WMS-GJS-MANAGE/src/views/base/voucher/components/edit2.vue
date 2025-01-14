<template>
  <div class="filter-container">
    <!-- 物料信息表表单 -->
    <el-dialog
      :title="textMap[editType]+'物料信息表'"
      :visible.sync="editShow"
      :before-close="handleClose"
      :close-on-click-modal="false"
    >
      <el-form
        ref="editForm2"
        :rules="editType==='tab1'||editType==='tab4'||editType==='tab5'?rules1:rules23"
        :model="editForm2"
        label-position="right"
        label-width="7rem"
        style="width: 90%; margin-left:2%;"
      >
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="入库物料" prop="mat">
              <el-input v-model="editForm2.mat" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="物料规格" prop="spec">
              <el-input v-model="editForm2.spec" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="12">
            <el-form-item label="单枚单位" prop="unit">
              <el-input v-model="editForm2.unit" disabled />
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="单枚重量" prop="unit">
              <el-input v-model="editForm2.perWeight" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="退饼件数" prop="drawbackQty">
              <el-input v-model="editForm2.drawbackQty" oninput="value=value.replace(/[^\d]/g,'')" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="退饼重量" prop="drawbackWeight">
              <el-input v-model="editForm2.drawbackWeight" type="number" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="废白件数" prop="wasteWhiteQty">
              <el-input v-model="editForm2.wasteWhiteQty" oninput="value=value.replace(/[^\d]/g,'')" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="废白重量" prop="wasteWhiteWeight">
              <el-input v-model="editForm2.wasteWhiteWeight" type="number" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="成品件数" prop="qty">
              <el-input v-model="editForm2.qty" oninput="value=value.replace(/[^\d]/g,'')" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="成品重量" prop="totalWeight">
              <el-input v-model="editForm2.totalWeight" type="number" :disabled="totalWeightDisabled" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :lg="12">
            <el-form-item label="入库仓库" prop="ware">
              <el-input v-model="editForm2.ware" disabled />
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="库管" prop="creator01">
              <el-input v-model="editForm2.creator01" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col v-if="editType === 'tab1' || editType === 'tab4' || editType === 'tab5'" :lg="12">
            <el-form-item label="交接凭证号" prop="voucherNo">
              <el-input v-model="editForm2.voucherNo" />
            </el-form-item>
          </el-col>
          <el-col v-if="editType === 'tab1' " :xs="24" :sm="24" :lg="12">
            <el-form-item label="交易时间" prop="created">
              <el-date-picker v-model="editForm2.entranceDate" value-format="yyyy-MM-dd" type="date" placeholder="选择日期时间" />
            </el-form-item>
          </el-col>
          <el-col v-else :xs="24" :sm="24" :lg="12">
            <el-form-item label="交易时间" prop="created">
              <el-date-picker v-model="editForm2.created" value-format="yyyy-MM-dd" type="date" placeholder="选择日期时间" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="备注" prop="remark" class="lg-textarea">
              <el-input
                v-model="editForm2.remark"
                :autosize="{ minRows: 2, maxRows: 4}"
                type="textarea"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="handleClose">关 闭</el-button>
        <el-button
          type="primary"
          :disabled="isDisable"
          @click="confirmClick"
        >保 存</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>

import { getWarehouseEntry, updateWarehouseEntry } from '@/api/sib/warehouseEntry'
import { getWarehouseDelivery, updateWarehouseDelivery } from '@/api/sib/warehouseDelivery'
import { getPutApartJob, updatePutApartJob } from '@/api/sib/putApartJob'
import { getSubwareIn, updateSubwareIn } from '@/api/sib/subwareIn'
import { getSubwareOut, updateSubwareOut } from '@/api/sib/subwareOut'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editShow', 'editType', 'editId'],
  data() {
    return {
      getApi: getWarehouseEntry,
      updateApi: updateWarehouseEntry,
      isDisable: false,
      editForm2: {},
      textMap: {
        tab1: '编辑',
        tab2: '新增',
        tab3: '查看',
        tab4: '编辑',
        tab5: '编辑'
      },
      rules1: {
        voucherNo: [{ required: true, message: '交接凭证号不能为空', trigger: 'change' }],
        created: [{ required: true, message: '交易时间不能为空', trigger: 'change' }]
        // remark: [{ required: true, message: '备注不能为空', trigger: 'change' }]
      },
      rules23: {
        created: [{ required: true, message: '交易时间不能为空', trigger: 'change' }]
        // remark: [{ required: true, message: '备注仓库不能为空', trigger: 'change' }]
      },
      rulesUpdate: {},
      totalWeightDisabled: true,
      isPrincipal: JSON.parse(sessionStorage.getItem('isPrincipal')),
    }
  },
  created() {
    if (this.editType === 'tab1') {
      this.getApi = getWarehouseEntry
      this.updateApi = updateWarehouseEntry
    } else if (this.editType === 'tab2') {
      this.getApi = getWarehouseDelivery
      this.updateApi = updateWarehouseDelivery
    } else if (this.editType === 'tab3') {
      this.getApi = getPutApartJob
      this.updateApi = updatePutApartJob
    } else if (this.editType === 'tab4') {
      this.getApi = getSubwareIn
      this.updateApi = updateSubwareIn
      // 只有登陆人中具有”造币四部负责人“角色时，才能修改此字段
      if (this.isPrincipal) {
        this.totalWeightDisabled = false
      }
    } else if (this.editType === 'tab5') {
      this.getApi = getSubwareOut
      this.updateApi = updateSubwareOut
    }
    this.getData()
  },
  mounted() {},
  methods: {
    // 信息详情
    async getData() {
      const { code, retObj } = await this.getApi({ id: this.editId })
      if (code === 0) {
        this.editForm2 = retObj
        if (this.editForm2.creator02) {
          this.editForm2.creator01 = this.editForm2.creator01 + ',' + this.editForm2.creator02
        }
        if (this.editForm2.created && this.editForm2.created.length > 10) {
          const date =  this.editForm2.created.substr(0, 10)
          this.$set(this.editForm2, 'created', date)
        }
        this.clear()
      }
    },
    // 关闭窗口
    handleClose(index) {
      this.$parent.editShow2 = false
      if (index === 1) this.$parent.reload()
    },
    // 清除验证
    clear() {
      this.$nextTick(() => {
        this.$refs.editForm2.clearValidate()
      })
    },
    // 提交
    confirmClick() {
      this.$refs.editForm2.validate(async valid => {
        if (valid) {
          this.isDisable = true
          const param = {
            id: this.editForm2.id,
            voucherNo: this.editForm2.voucherNo,
            entranceDate: this.editForm2.entranceDate,
            created: this.editForm2.created,
            remark: this.editForm2.remark,
            drawbackQty: this.editForm2.drawbackQty,
            drawbackWeight: this.editForm2.drawbackWeight,
            wasteWhiteQty: this.editForm2.wasteWhiteQty,
            wasteWhiteWeight: this.editForm2.wasteWhiteWeight,
            qty: this.editForm2.qty,
            totalWeight: this.editForm2.totalWeight
          }
          const { code, msg } = await this.updateApi(param)
          if (code === 0) {
            this.$message.success(msg)
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
</style>

