<template>
  <div class="app-container">
    <!-- <el-scrollbar> -->
    <div class="filter-container">
      <el-input
        v-model="queryForm.username"
        placeholder="用户名"
        class="filter-item"
        clearable
      />
      <el-input
        v-model="queryForm.realName"
        placeholder="姓名"
        class="filter-item"
        clearable
      />
      <el-date-picker v-model="queryForm.startDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="开始日期" />
      <el-date-picker v-model="queryForm.endDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="结束日期" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="search">查 询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-refresh" @click="resetQuery">重 置</el-button>
    </div>
    <div class="filter-container">
      <el-button
        :loading="deleteLoading"
        class="filter-item"
        type="danger"
        icon="el-icon-delete"
        @click="handleDeleteBatch"
      >批量删除</el-button>
    </div>

    <el-table
      v-loading="listLoading"
      row-key="id"
      :data="tableData"
      border
      stripe
      fit
      highlight-current-row
      style="width: 100%;"
      :header-cell-style="{background:'#eef1f6',color:'#606266'}"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" align="center" prop="id" />
      <el-table-column
        label="NO"
        prop="id"
        align="center"
        width="40"
        type="index"
      />
      <el-table-column label="用户Id" align="center" width="100">
        <template slot-scope="{row}">
          <span>{{ row.userId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" align="center">
        <template slot-scope="{row}">
          <span>{{ row.realName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户名" align="center">
        <template slot-scope="{row}">
          <span>{{ row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类型" width="100" align="center">
        <template slot-scope="{row}">
          <span>{{ row.type===1?"登录":"登出" }}</span>
        </template>
      </el-table-column>
      <el-table-column label="IP地址" align="center">
        <template slot-scope="{row}">
          <span>{{ row.ip }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" align="center">
        <template slot-scope="{row}">
          <span>{{ row.createTime }}</span>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="pageTotal>0"
      :total="pageTotal"
      :page.sync="page"
      :limit.sync="rows"
      @pagination="getList"
    />
    <!-- </el-scrollbar> -->
  </div>
</template>

<script>
import { loginList, loginDel } from '@/api/log/index'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination
import Mixin from '@/utils/mixin.js'

export default {
  name: 'Login',
  components: { Pagination },
  mixins: [Mixin],
  data() {
    return {
      listApi: loginList,
      delBatchApi: loginDel
    }
  },
  created() {
    this.getList()
  },
  methods: {
  }
}
</script>
<style lang="scss" scoped>
::v-deep .el-table--medium th, ::v-deep .el-table--medium td {
    padding: 4px 0;
}
</style>
