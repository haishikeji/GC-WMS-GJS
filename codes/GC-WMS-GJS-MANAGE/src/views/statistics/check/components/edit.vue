<template>
  <div class="applyfor-edit">
    <el-drawer
      :with-header="false"
      :visible.sync="editShow"
      direction="rtl"
      :wrapper-closable="false"
    >
      <div class="drawer-header" :style="{'color':theme}">
        <span class="con">历史记录</span>
        <i class="el-icon-close drawer-icon" @click="handleClose" />
      </div>
      <div style="padding: 10px 20px; height: 90%">
        <el-table
          :data="tableData"
          :header-cell-style="{ background: '#eef1f6', color: '#606266' }"
        >
          <el-table-column
            label="NO"
            prop="id"
            align="center"
            width="40"
            type="index"
          />
          <el-table-column
            align="center"
            prop="name"
            label="名称"
            min-width="150"
          />
          <el-table-column
            label="操作"
            align="center"
            min-width="100"
          >
            <template slot-scope="{ row }">
              <el-button type="text" @click="handleDelete(row)">
                删除
              </el-button>
              <el-button type="text" @click="handleExp(row)">
                下载
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <pagination v-show="pageTotal>0" layout="prev, pager, next" :total="pageTotal" :page.sync="page" :limit.sync="rows" @pagination="getChildList" />
      </div>
      <div class="drawer-bootom-button">
        <el-button type="danger" @click="handleClose">关 闭</el-button>
      </div>
    </el-drawer>
  </div>
</template>

<script>
// import { deepClone } from "@/utils"

import Pagination from '@/components/Pagination'
import { listCheckFile, delCheckFile } from '@/api/sib/checkFile'

export default {
  components: { Pagination },
  // eslint-disable-next-line vue/require-prop-types
  props: ['editShow'],
  data() {
    return {
      tableData: [],
      listLoading: true, // 加载动画
      page: 1, // 页码
      rows: 20, // 条数
      pageTotal: 0 // 总条数
    }
  },
  computed: {
    theme() {
      return this.$store.state.settings.theme
    }
  },
  created() {
    this.getChildList()
  },
  methods: {
    // 下载
    async handleExp(row) {
      window.open(window.Glod.baseURLConfig + row.url)
    },
    // 获取用户信息
    async getChildList() {
      const { retObj } = await listCheckFile({ page: this.page, rows: this.rows })
      this.tableData = retObj.list
      this.pageTotal = retObj.total
    },
    // 删除角色下的用户
    async handleDelete(row) {
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(async() => {
        const { code } = await delCheckFile({
          id: row.id
        })
        if (code === 0) {
          this.getChildList()
        }
      })
    },
    // 关闭窗口
    handleClose() {
      this.$parent.editShow = false
    }
    // end
  }
}
</script>

<style lang="scss" scoped>
.drawer-bootom-button {
  position: absolute;
  bottom: 0;
  width: 100%;
  border-top: 1px solid #e8e8e8;
  padding: 10px 16px;
  text-align: right;
  left: 0;
  background: #fff;
  border-radius: 0 0 2px 2px;
  z-index: 100;
}
.drawer-header {
  font-size: 16px;
  // color: #14889a;
  border-bottom: 1px solid #e8e8e8;
  padding: 16px 16px;
  .drawer-icon {
    float: right;
  }
}
::v-deep .el-icon-close:before {
  color: #000;
}
::v-deep .el-dialog__body {
  max-height: 420px;
  overflow-y: auto;
}

::v-deep .el-checkbox__label {
  padding-left: 1px;
  font-size: 12px;
}
::v-deep .el-tree-node__content {
  font-size: 12px;
}
</style>
