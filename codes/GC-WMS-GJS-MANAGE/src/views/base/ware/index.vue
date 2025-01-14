<template>
  <div class="app-container">
    <!-- 查询 -->
    <div class="filter-container">
      <el-input v-model="queryForm.ware" class="filter-item" placeholder="仓库名称" clearable />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="search">查 询</el-button>
    </div>
    <!-- 功能 -->
    <div class="filter-container">
      <el-button class="filter-item" type="success" icon="el-icon-plus" @click="handleAdd()">新 增</el-button>
    </div>
    <!-- 仓库信息表，包含子库定义与工序属性列表 -->
    <el-table v-loading="listLoading" row-key="id" :data="tableData" 
    :header-cell-style="{ background: '#eef1f6', color: '#606266' }" border stripe fit highlight-current-row>
      <!-- <el-table-column type="selection" align="center" prop="id" /> -->
      <el-table-column label="NO" prop="id" align="center" width="40" type="index" />
      <el-table-column label="子库名称" align="center" prop="ware" min-width="150" />
      <el-table-column label="排序" align="center" prop="sort" min-width="80" />
      <el-table-column label="对应仓库" align="center" prop="bigWare" min-width="100" />
      <el-table-column label="对应工序" align="center" prop="procedure" min-width="100" />
      <el-table-column label="状态" align="center" prop="status" min-width="80">
        <template slot-scope="{ row }">
          <el-tag
            style="cursor: pointer"
            :type="row.status | statusFilter"
            @click="handleStatus(row)"
          >
            {{ $commonArray.methods.getArrayVal('statusOpt', row.status) }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="80">
        <template slot-scope="{row}">
          <el-link type="primary" :underline="false" @click="handleUpdate(row)">编辑</el-link>
        </template>
      </el-table-column>
    </el-table>
    <!-- 新增/编辑 -->
    <Edit
      v-if="editShow"
      ref="edit"
      :edit-show="editShow"
      :edit-type="editType"
      :edit-id="editId"
    />
  </div>
</template>

<script>
import { listWareInfo, delWareInfo, statusWareInfo } from '@/api/sib/wareInfo'
import Edit from './components/edit'
import Mixin from '@/utils/mixin.js'

export default {
  name: 'WareInfo',
  components: { Edit },
  filters: {
    statusFilter(status) {
      const statusMap = {
        1: 'success',
        2: 'danger',
        3: 'info',
        0: 'danger'
      }
      return statusMap[status]
    }
  },
  mixins: [Mixin],
  data() {
    return {
      listApi: listWareInfo, // 列表
      deleteApi: delWareInfo, // 删除
      statusApi: statusWareInfo // 列表
    }
  },
  created() {
    this.getList()
  },
  mounted() {
  },
  methods: {
    // methods-end
  }
}
</script>
