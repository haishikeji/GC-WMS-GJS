<template>
  <div class="applyfor-edit">
    <el-dialog
      :title="textMap[editType]"
      :visible.sync="editShow"
      :before-close="handleClose"
      :close-on-click-modal="false"
      custom-class="customWidth_30"
    >
      <el-form
        ref="editForm"
        class="myForm"
        :model="editForm"
        :rules="rules"
        label-position="right"
        label-width="25%"
      >
        <el-form-item label="上级菜单">
          <el-input v-model="editForm.parentMenu" disabled />
        </el-form-item>
        <el-form-item label="菜单名称" prop="title">
          <el-input v-model="editForm.title" />
        </el-form-item>
        <el-form-item label="访问路径" prop="path">
          <el-input v-model="editForm.path" />
        </el-form-item>
        <el-form-item label="组件" prop="component">
          <el-input v-model="editForm.component" placeholder="子菜单以/开头" />
        </el-form-item>
        <el-form-item label="功能排序" prop="sorted">
          <el-input v-model="editForm.sorted" />
        </el-form-item>
        <!-- <el-form-item label="是否隐藏" prop="hideMenu">
          <el-radio-group v-model="editForm.hideMenu">
            <el-radio v-for="item in $commonArray.options['showMenuOpt']" :key="item.id" :label="item.id">{{ item.name }}</el-radio>
          </el-radio-group>
        </el-form-item> -->
        <el-form-item label="跳转路径">
          <el-input v-model="editForm.redirect" />
        </el-form-item>
        <el-form-item label="菜单icon" prop="icon">
          <el-input v-model="editForm.icon" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="handleClose">取 消</el-button>
        <el-button
          :disabled="disabledSee"
          type="primary"
          @click="confirmClick"
        >保 存</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { addMenu, updateMenu, getMenu } from '@/api/sys/menu'

export default {
  // eslint-disable-next-line vue/require-prop-types
  props: ['editShow', 'editType', 'parentEdit', 'editId'],
  data() {
    return {
      editForm: {},
      rules: {
        title: [{ required: true, message: '名称不能为空', trigger: 'change' }],
        path: [{ required: true, message: '访问路径不能为空', trigger: 'change' }],
        hideMenu: [{ required: true, message: '请选择菜单是否隐藏', trigger: 'change' }]

      },
      disabledSee: false,
      textMap: {
        update: '编辑菜单',
        add: '新增菜单'
      }
    }
  },
  created() {
    if (this.editType === 'update') {
      this.getInfo()
    } else {
      if (typeof this.parentEdit !== 'undefined') {
        this.editForm = {
          pid: this.parentEdit.id,
          parentMenu: this.parentEdit.title,
          hideMenu: 0
        }
      } else {
        this.editForm = {
          pid: 0,
          parentMenu: '顶级',
          hideMenu: 0
        }
      }
    }
  },
  methods: {
    // 信息详情
    async getInfo() {
      const { code, retObj } = await getMenu({ id: this.editId })
      if (code === 0) {
        this.editForm = retObj
      }
    },
    // 关闭窗口
    handleClose(index) {
      this.$parent.toggleEditNoPage(false, index)
    },
    // 提交
    confirmClick() {
      this.$refs.editForm.validate(async valid => {
        if (valid) {
          if (this.editType === 'update') {
            const { code, msg } = await updateMenu({ ...this.editForm })
            if (code === 0) {
              this.$message.success(msg)
            }
          } else {
            const { code, msg } = await addMenu({ ...this.editForm })
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

<style lang="scss" scoped></style>
