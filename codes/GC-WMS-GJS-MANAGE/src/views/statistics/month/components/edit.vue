<template>
  <div class="filter-container">
    <!-- 物料信息表表单 -->
    <el-dialog :title="textMap[editType]+'月度统计任务'" :visible.sync="editShow" :before-close="handleClose" :close-on-click-modal="false">
      <div style="text-align: center;margin-bottom: 20px;">
        <span style="font-weight: 600;margin-right: 10px;">将会{{ textMap[editType] }}以下报表任务:</span>
        <span>金饼料品收付存月报表, 银饼料品收付存月报表, 生产月报, 生产月报铜</span>
      </div>
      <el-form ref="editForm" :rules="editType==='update'?rulesUpdate:rules" :model="editForm" label-position="right" label-width="7rem" style="width: 90%; margin-left:2%;">
        <el-form-item label="统计年月" prop="monthly">
          <el-date-picker v-model="editForm.monthly" value-format="yyyy-MM" type="month" @change="chargeDate" />
        </el-form-item>
        <el-row>
          <el-col :xs="24" :sm="24" :lg="12">
            <el-form-item label="开始日期" prop="monthStart">
              <el-date-picker v-model="editForm.monthStart" value-format="yyyy-MM-dd" type="date" :disabled="dateDisable" />
            </el-form-item>
          </el-col>
          <el-col :lg="12">
            <el-form-item label="结束日期" prop="monthEnd">
              <el-date-picker v-model="editForm.monthEnd" value-format="yyyy-MM-dd" type="date" />
            </el-form-item>
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
import { delMonthReport } from '@/api/sib/statistics'
import { getLastDate, addMonthStatTask } from '@/api/sib/monthStatTask'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editShow', 'editType', 'editId'],
  data() {
    return {
      isDisable: false,
      dateDisable: false,
      editForm: {},
      textMap: {
        add: '创建',
        del: '删除'
      },
      rules: {
        monthly: [{ required: true, message: '请选择统计年月', trigger: 'change' }],
        monthStart: [{ required: true, message: '请选择开始日期', trigger: 'change' }],
        monthEnd: [{ required: true, message: '请选择结束日期', trigger: 'change' }]
      },
      rulesUpdate: {
        monthly: [{ required: true, message: '请选择统计年月', trigger: 'change' }],
        monthStart: [{ required: true, message: '请选择开始日期', trigger: 'change' }],
        monthEnd: [{ required: true, message: '请选择结束日期', trigger: 'change' }]
      }
    }
  },
  created() {
  },
  mounted() {

  },
  methods: {
    // 选择月度
    async chargeDate() {
      const { retObj } = await getLastDate({ monthly: this.editForm.monthly })
      if (retObj) {
        this.$set(this.editForm, 'monthStart', retObj)
        this.dateDisable = true
      } else {
        this.$set(this.editForm, 'monthStart', '')
        this.dateDisable = false
        this.clear()
      }
    },
    // 清除验证
    clear() {
      this.$nextTick(() => {
        this.$refs.editForm.clearValidate()
      })
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
          if (this.editType === 'add') {
            const { code, msg } = await addMonthStatTask({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          } else {
            const { code, msg } = await delMonthReport({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          }
          this.isDisable = false
          this.$parent.initWebSocket()
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

