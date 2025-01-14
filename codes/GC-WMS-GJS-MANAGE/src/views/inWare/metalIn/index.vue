<template>
  <div class="app-container">
    <!-- 新增/编辑 -->
    <Edit
      ref="edit"
      :edit-form="editForm"
      :mat-opt="matOpt"
      :other-ware-opt="otherWareOpt"
      @initParam="initParam"
    />
  </div>
</template>

<script>
import { listByNextWareId } from '@/api/sib/subwareOut'
import Edit from './components/edit'
import Mixin from '@/utils/mixin.js'
import Dictionaries from '@/utils/dictionaries.js'
import { formatTimeToStr } from '@/utils/date'

export default {
  name: 'MaterialInfo',
  components: { Edit },
  mixins: [Mixin, Dictionaries],
  data() {
    return {
      listApi: listByNextWareId, // 列表
      editForm: {}
    }
  },
  created() {
    this.getOtherWareOpt([1, 2])
    this.getMatOptList(1) // 1:原料物料 2:产成品物料 3:全部
    this.initParam()
  },
  mounted() {},
  methods: {
    // 初始数据
    initParam() {
      this.editForm = {
        wareId: 1,
        entranceDate: formatTimeToStr(new Date(), 'yyyy-MM-dd'),
        creator01: sessionStorage.getItem('username'),
        creator02: sessionStorage.getItem('username2')
      }
    },
    // 选择
    handleSelect(row) {
      this.editForm = Object.assign({}, row)
      this.showNotify(row.mat)
      this.$refs.edit.clear()
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
</style>
