<template>
  <div class="applyfor-edit">
    <el-dialog
      :title="textMap[editType]"
      :visible.sync="editShow"
      :before-close="handleClose"
      :close-on-click-modal="false"
      custom-class="customWidth_30"
    >
      <el-form ref="editForm" class="myForm" :model="editForm" :rules="rules" label-position="right" label-width="25%">
        <el-form-item label="角色名称">
          <el-input v-model="editForm.name" placeholder="角色名称 " />
        </el-form-item>
        <el-form-item label="角色描述">
          <el-input
            v-model="editForm.remark"
            :autosize="{ minRows: 2, maxRows: 5}"
            type="textarea"
            placeholder="角色描述"
          />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="handleClose">取 消</el-button>
        <el-button :disabled="disabledSee" type="primary" @click="confirmClick">保 存</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { addRole, updateRole, getRole } from '@/api/sys/role'

export default {
  props: ['editShow', 'editType', 'editId'],
  data() {
    return {
      editForm: {},
      rules: {
        name: [{ required: true, message: '部门名称不能为空', trigger: 'change' }]
      },
      disabledSee: false,
      textMap: {
        update: '编辑角色',
        add: '新增角色'
      }
    }
  },
  created() {
    if (this.editType === 'update') {
      this.getInfo()
    }
  },
  methods: {
    // 信息详情
    async getInfo() {
      const { code, retObj } = await getRole({ id: this.editId })
      if (code === 0) {
        this.editForm = retObj
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
          if (this.editType === 'update') {
            const { code, msg } = await updateRole({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          } else {
            const { code, msg } = await addRole({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          }
          this.handleClose(1)
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
