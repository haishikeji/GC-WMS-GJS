<template>
  <div class="app-container">
    <!-- 查询 -->
    <div class="filter-container">
      <el-select
        v-model="queryForm.matId"
        class="filter-item"
        placeholder="物料名称"
        clearable
        filterable
        @change="handleChange"
      >
        <el-option
          v-for="item in matOpt"
          :key="item.id"
          :label="item.name + item.val"
          :value="item.id"
        />
      </el-select>
      <el-input v-model="queryForm.spec" class="filter-item" placeholder="规格" disabled />
      <el-select v-model="queryForm.userOpt" class="filter-item" placeholder="经办人" clearable filterable>
        <el-option
          v-for="item in userOpt"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        />
      </el-select>
      <el-select v-model="queryForm.creator01" class="filter-item" placeholder="库管" clearable filterable>
        <el-option
          v-for="item in userOpt"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        />
      </el-select>
      <el-date-picker v-model="queryForm.startDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="开始日期" />
      <el-date-picker v-model="queryForm.endDate" class="filter-item" value-format="yyyy-MM-dd" type="date" placeholder="结束日期" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="search">查 询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-refresh" @click="resetQuery">重 置</el-button>
    </div>
    <!-- 功能 -->
    <div class="filter-container">
      <el-button class="filter-item" type="primary" icon="el-icon-download" @click="handleExp()">导 出</el-button>
    </div>
    <!-- 物料信息表列表 -->
    <el-table v-loading="listLoading" row-key="id" :data="tableData" border stripe fit highlight-current-row>
      <el-table-column label="NO" prop="id" align="center" width="40" type="index" />
      <el-table-column label="下道工序" align="center" prop="ware" min-width="100" />
      <el-table-column label="交接凭证号" align="center" prop="principal" min-width="100" />
      <el-table-column label="类型" align="center" prop="mat" min-width="150" />
      <el-table-column label="物料名称" align="center" prop="mat" min-width="150" />
      <el-table-column label="物料规格" align="center" prop="unit" min-width="100" />
      <el-table-column label="单位" align="center" prop="perWeight" min-width="100" />
      <el-table-column label="出库件数" align="center" prop="qty" min-width="100" />
      <el-table-column label="出库重量" align="center" prop="totalWeight" min-width="100">
        <template slot-scope="{row}">
          {{ row.totalWeight.toFixed(6) }}
        </template>
      </el-table-column>
      <el-table-column label="经办人" align="center" prop="principal" min-width="100" />
      <el-table-column label="库管" align="center" prop="principal" min-width="100" />
      <el-table-column label="出库日期" align="center" prop="principal" min-width="150" />
    </el-table>
    <!-- 分页 -->
    <pagination v-show="pageTotal>0" :total="pageTotal" :page.sync="page" :limit.sync="rows" @pagination="getList" />
  </div>
</template>

<script>
import { listMaterialInfo } from '@/api/sib/materialInfo'
import Pagination from '@/components/Pagination'
import Mixin from '@/utils/mixin.js'
import Dictionaries from '@/utils/dictionaries.js'

export default {
  name: 'MaterialInfo',
  components: { Pagination },
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
  mixins: [Mixin, Dictionaries],
  data() {
    return {
      listApi: listMaterialInfo // 列表
    }
  },
  created() {
    this.listUserOptByRoleId(2) // 根据角色id查询用户列 2库管 3负责人
    this.getMatOptList(1) // 1:原料物料 2:产成品物料 3:全部
    this.getList()
  },
  mounted() {
  },
  methods: {
    // 切换物料
    handleChange(val) {
      if (val) {
        this.queryForm.spec = this.getArrayValById(this.matOpt, val)
      } else {
        this.queryForm.spec = ''
      }
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
::v-deep .el-button+.el-button{margin-left:0px}
</style>
