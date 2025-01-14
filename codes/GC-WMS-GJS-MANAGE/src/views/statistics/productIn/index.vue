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
      <el-select v-model="queryForm.outor01Id" class="filter-item" placeholder="入库人" clearable filterable>
        <el-option v-for="item in userOpt" :key="item.id" :label="item.name" :value="item.id" />
      </el-select>
      <el-select v-model="queryForm.creator01Id" class="filter-item" placeholder="库管" clearable filterable>
        <el-option v-for="item in userOpt" :key="item.id" :label="item.name" :value="item.id" />
      </el-select>
      <el-date-picker
        v-model="queryForm.startDate"
        class="filter-item"
        value-format="yyyy-MM-dd"
        type="date"
        placeholder="开始日期"
      />
      <el-date-picker
        v-model="queryForm.endDate"
        class="filter-item"
        value-format="yyyy-MM-dd"
        type="date"
        placeholder="结束日期"
      />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="search">查 询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-refresh" @click="resetQuery">重 置</el-button>
    </div>
    <!-- 功能 -->
    <div class="filter-container">
      <el-button :loading="expLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleExp">导 出</el-button>
    </div>
    <!-- 物料信息表列表 -->
    <el-table
      v-loading="listLoading"
      :data="tableData"
      :header-cell-style="{ background: '#eef1f6', color: '#606266' }"
      border
      stripe
      fit
      highlight-current-row
    >
      <el-table-column label="NO" prop="id" align="center" width="40" type="index" fixed />
      <el-table-column label="对应仓库" align="center" prop="ware" min-width="100" fixed />
      <el-table-column label="物料名称" align="center" prop="prdMat" min-width="150" fixed>
        <template slot-scope="{row}">
          {{ row.prdMat||row.mat }}
        </template>
      </el-table-column>
      <el-table-column label="规格" align="center" prop="spec" min-width="100" />
      <el-table-column label="单枚单位" align="center" prop="unit" min-width="100" />
      <el-table-column label="单枚重量" align="center" prop="perWeight" min-width="100">
        <template slot-scope="{row}">
          {{ row.perWeight.toFixed(6) }}
        </template>
      </el-table-column>
      <el-table-column label="原出库件数" align="center" prop="sourceQty" min-width="100" />
      <el-table-column label="样币件数" align="center" prop="proofCoinQty" min-width="100" />
      <el-table-column label="退饼件数" align="center" prop="drawbackQty" min-width="100" />
      <el-table-column label="废白件数" align="center" prop="wasteWhiteQty" min-width="100" />
      <el-table-column label="废花件数" align="center" prop="wasteFlowerQty" min-width="100" />
      <el-table-column label="成品件数" align="center" prop="subQty" min-width="100">
        <template slot-scope="{row}">
          {{ row.subQty||row.qty }}
        </template>
      </el-table-column>
      <el-table-column label="成品重量" align="center" prop="subWeight" min-width="100">
        <template slot-scope="{row}">
          {{ (row.subWeight||row.totalWeight).toFixed(6) }}
        </template>
      </el-table-column>
      <el-table-column label="入库人" align="center" min-width="150">
        <template slot-scope="{row}">
          <span>
            {{ row.outor01 }}
            <span v-if="row.outor01 && row.outor02">,</span>
            {{ row.outor02 }}
          </span>
        </template>
      </el-table-column>
      <el-table-column label="库管" align="center" min-width="150">
        <template slot-scope="{row}">
          <span>
            {{ row.creator01 }}
            <span v-if="row.creator01 && row.creator02">,</span>
            {{ row.creator02 }}
          </span>
        </template>
      </el-table-column>
      <el-table-column label="入库日期" align="center" prop="created" min-width="150" />
    </el-table>
    <!-- 分页 -->
    <pagination
      v-show="pageTotal>0"
      :total="pageTotal"
      :page.sync="page"
      :limit.sync="rows"
      @pagination="getList"
    />
  </div>
</template>

<script>
import { listPruduct, expPruduct } from '@/api/sib/subwareIn'
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
      listApi: listPruduct, // 列表
      expApi: expPruduct
    }
  },
  created() {
    this.listUserOptByRoleId(2) // 根据角色id查询用户列 2库管 3负责人
    this.getMatOptList(2) // 1:原料物料 2:产成品物料 3:全部
    this.getList()
  },
  mounted() {},
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
::v-deep .el-button + .el-button {
  margin-left: 0px;
}
</style>
