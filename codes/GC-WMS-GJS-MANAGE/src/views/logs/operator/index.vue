<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input
        v-model="queryForm.realName"
        placeholder="操作人"
        class="filter-item"
        clearable
        @keyup.enter.native="search"
      />
      <el-input
        v-model="queryForm.className"
        placeholder="操作类名"
        class="filter-item"
        clearable
        @keyup.enter.native="search"
      />
      <el-date-picker v-model="queryForm.startDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="开始日期" />
      <el-date-picker v-model="queryForm.endDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="结束日期" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="search">查 询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-refresh" @click="resetQuery">重 置</el-button>
    </div>
    <!--
    <div class="filter-container">
      <el-button
        :loading="deleteLoading"
        class="filter-item"
        type="danger"
        icon="el-icon-delete"
        @click="handleDeleteBatch"
      >批量删除</el-button>
    </div>
    -->

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
      <el-table-column
        label="NO"
        prop="id"
        align="center"
        width="40"
        type="index"
      />
      <el-table-column label="操作人" align="center" prop="realName" min-width="60" />
      <el-table-column label="请求地址" align="center"  prop="url"  min-width="150" />
      <el-table-column label="请求方式" align="center" prop="way"  min-width="60" />
      <el-table-column label="操作类名" align="center" min-width="150" show-overflow-tooltip>
        <template slot-scope="{row}">
          <span class="link-type" @click="handleView(row)">{{ row.className }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作内容" align="center" prop="name" min-width="150" show-overflow-tooltip />
      <el-table-column label="操作时间" align="center" prop="startTime" min-width="100" />
      <el-table-column label="操作" align="center" min-width="60">
        <template slot-scope="{row}">
          <el-link
            :underline="false"
            type="primary"
            @click="handleView(row)"
          >查看</el-link>
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
    <Edit
      v-if="editShow"
      ref="edit"
      :edit-show="editShow"
      :edit-type="editType"
      :edit-row="editRow"
    />
  </div>
</template>

<script>
import { operateList } from '@/api/log/index'
import Pagination from '@/components/Pagination'
import Edit from './components/edit'
import Mixin from '@/utils/mixin.js'

export default {
  name: 'OperateLogs',
  components: { Pagination, Edit },
  mixins: [Mixin],
  data() {
    return {
      listApi: operateList,
      temp: {
        id: undefined,
        remark: '',
        methodName: ''
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '查看内容'
      },
      dialogPvVisible: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
  }
}
</script>
