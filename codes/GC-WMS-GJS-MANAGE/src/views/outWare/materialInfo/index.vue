<template>
  <div class="app-container">
    <!-- 新增/编辑 -->
    <Edit
      ref="edit"
      :edit-form="editForm"
      :voucher-no-show="voucherNoShow"
      :edit-disabled="editDisabled"
      :other-ware-opt="otherWareOpt"
      @initParam="initParam"
    />
    <!-- 查询-->
    <div class="filter-container">
      <el-select
        v-model="queryForm.wareId"
        class="filter-item"
        placeholder="当前操作仓库"
        clearable
        @change="handleChange"
      >
        <el-option
          v-for="item in materialWareOpt"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        />
      </el-select>
    </div>
    <div class="filter-container sub-title">请选择要出库的物料</div>
    <!-- 物料信息表列表 -->
    <el-table row-key="id" :data="tableData" :header-cell-style="{ background: '#eef1f6', color: '#606266' }" border stripe fit highlight-current-row>
      <el-table-column label="NO" prop="id" align="center" width="40" type="index" />
      <el-table-column label="物料名称" align="center" prop="mat" min-width="150" />
      <el-table-column label="规格" align="center" prop="spec" min-width="100" />
      <el-table-column label="单枚单位" align="center" prop="unit" min-width="100" />
      <el-table-column label="库存件数" align="center" prop="qty" min-width="100" />
      <el-table-column label="库存重量" align="center" prop="totalWeight" min-width="100">
        <template slot-scope="{row}">
          {{ row.totalWeight.toFixed(6) }}
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="80">
        <template slot-scope="{row}">
          <el-link v-show="row.qty > 0" type="primary" :underline="false" @click="handleSelect(row)">选择</el-link>
        </template>
      </el-table-column>
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
import { listStockByWareId } from '@/api/sib/stock'
import Edit from './components/edit'
import Pagination from '@/components/Pagination'
import Mixin from '@/utils/mixin.js'
import Dictionaries from '@/utils/dictionaries.js'

export default {
  name: 'MaterialInfo',
  components: { Pagination, Edit },
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
      listApi: listStockByWareId, // 列表
      voucherNoShow: false,
      editForm: {}
    }
  },
  created() {
    this.getOtherWareOpt([1, 2])
    this.getMaterialWareOpt()
  },
  mounted() {},
  methods: {
    // 初始化
    initParam() {
      this.editForm = {}
      this.editDisabled = false
      this.voucherNoShow = false
      this.getList()
    },
    // 选择
    handleSelect(row) {
      this.editDisabled = true
      this.editForm = Object.assign({}, row)
      this.$set(this.editForm, 'creator01', sessionStorage.getItem('username'))
      this.$set(this.editForm, 'creator02', sessionStorage.getItem('username2'))
      this.$set(this.editForm, 'creator01Id', sessionStorage.getItem('userId1'))
      this.$set(this.editForm, 'creator02Id', sessionStorage.getItem('userId2'))
      this.$set(this.editForm, 'perWeight', this.editForm.perWeight.toFixed(6))
      this.$set(this.editForm, 'allQty', row.qty)
      this.$set(this.editForm, 'qty', '')
      this.$set(this.editForm, 'totalWeight', '')
      this.$set(this.editForm, 'nextWareId', parseInt(row.wareId) + 1)
      this.changeVoucherNo()
      this.showNotify(row.mat)
      this.$refs.edit.clear()
    },
    // 验证显示凭证号
    changeVoucherNo() {
      if (this.queryForm.wareId === 1 && this.editForm.categoryId === 2) {
        this.voucherNoShow = true
      } else {
        this.voucherNoShow = false
      }
    },
    // 切换大类
    handleChange(val) {
      if (val) {
        this.changeVoucherNo()
        this.getList()
      }
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
</style>
