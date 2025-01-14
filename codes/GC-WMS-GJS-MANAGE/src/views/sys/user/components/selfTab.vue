<template>
  <div class="app-container">
    <el-form v-if="type == 'self'" ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="80px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="temp.username" disabled class="lg-input" />
          </el-form-item>
        </el-col>
        <el-col :span="8">&nbsp;</el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="姓名" prop="realName">
            <el-input v-model="temp.realName" class="lg-input" />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="手机号" prop="mobile">
            <el-input v-model="temp.mobile" class="lg-input" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="姓别" prop="sex">
            <el-select v-model="temp.sex" class="filter-item" placeholder="请选择" style="width:30%;">
              <el-option v-for="item in sexOpt" :key="item.id" :label="item.name" :value="item.id" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="出生日期" prop="birthday">
            <el-date-picker v-model="temp.birthday" value-format="yyyy-MM-dd" type="date" class="lg-input" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="电话号" prop="telephone">
            <el-input v-model="temp.telephone" class="lg-input" />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="temp.email" class="lg-input" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="16">
          <el-form-item label="备注" prop="remark" class="lg-textarea">
            <el-input
              v-model="temp.remark"
              :autosize="{ minRows: 2, maxRows: 4}"
              type="textarea"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="primary" @click="updateData">保 存</el-button>
      </el-form-item>
    </el-form>
    <el-form v-else ref="pwdForm" :rules="rulesPwd" :model="pwdTemp" label-position="left" label-width="80px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="原密码" prop="oldPassword">
            <el-input v-model="pwdTemp.oldPassword" class="lg-input" />
          </el-form-item>
        </el-col>
        <el-col :span="8">&nbsp;</el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="新密码" prop="newPassword">
            <el-input v-model="pwdTemp.newPassword" class="lg-input" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="确认密码" prop="confirmPwd">
            <el-input v-model="pwdTemp.confirmPwd" class="lg-input" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="primary" @click="updatePwdData">提 交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getSelf, updateSelf, updateSelfPwd } from '@/api/sys/self'

export default {
  props: {
    type: {
      type: String,
      default: 'self'
    }
  },
  data() {
    return {
      temp: {
      },
      pwdTemp: {
        oldPassword: undefined,
        newPassword: undefined,
        confirmPwd: undefined
      },
      sexOpt: [{ name: '男', id: 1 }, { name: '女', id: 2 }, { name: '未知', id: 3 }],
      rules: {
        mobile: [{ required: true, message: '手机号不能为空', trigger: 'blur' },
          { pattern: /^1[345789]\d{9}$/, message: '请输入正确格式的手机号' }],
        realName: [{ required: true, message: '姓名不能为空', trigger: 'blur' }]
      },
      rulesPwd: {
        oldPassword: [{ required: true, message: '请输入原密码', trigger: 'blur' }],
        newPassword: [{ required: true, message: '请输入新密码', trigger: 'blur' }],
        confirmPwd: [{ required: true, message: '请输入新密码', trigger: 'blur' },
          { validator: (rule, value, callback) => {
            if (value === '') {
              callback(new Error('请再次输入新密码'))
            } else if (value !== this.pwdTemp.newPassword) {
              callback(new Error('两次输入密码不一致'))
            } else {
              callback()
            }
          },
          trigger: 'blur'
          }]
      }

    }
  },
  created() {
    this.get()
  },
  methods: {
    get() {
      this.$emit('create')
      getSelf().then(res => {
        this.temp = res.retObj
        if (res.retObj.sex === 0) {
          this.temp.sex = ''
        }
      })
    },
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          const tempData = Object.assign({}, this.temp)
          updateSelf(tempData).then(res => {
            if (res.code === 0) {
              this.$message.success(res.msg)
            }
          })
        }
      })
    },
    updatePwdData() {
      this.$refs['pwdForm'].validate((valid) => {
        if (valid) {
          const tempData = Object.assign({}, this.pwdTemp)
          updateSelfPwd(tempData).then(res => {
            if (res.code === 0) {
              this.$message.success(res.msg)
            }
          })
        }
      })
    }
  }
}
</script>
<style scoped>

.lg-input {
  width: 60%;
}

.lg-textarea {
  width: 84%;
}

</style>
