<template>
  <div class="app-container">
    <!-- 新增/编辑 -->
    <Edit ref="edit" :edit-form="editForm" :mat-scrap-opt="matScrapOpt" @initParam="initParam" />
  </div>
</template>

<script>
import Edit from './components/edit'
import { getMatScrapOpt } from '@/api/sib/materialInfo'
import { getMaxNo } from '@/api/sib/scrap'
import { formatTimeToStr } from '@/utils/date'
import Dictionaries from '@/utils/dictionaries.js'

export default {
  name: 'MaterialInfo',
  components: { Edit },
  mixins: [Dictionaries],
  data() {
    return {
      readOnly: true,
      matScrapOpt: [],
      editForm: {}
    }
  },
  created() {
    this.listMatScrapOpt()
    this.initParam()
  },
  mounted() {},
  methods: {
    // 初始数据
    async initParam() {
      const { retObj } = await getMaxNo()
      this.editForm = {
        deadline: formatTimeToStr(new Date(), 'yyyy-MM-dd'),
        voucherNo: retObj,
        year: formatTimeToStr(new Date(), 'yyyy')
      }
      this.$refs.edit.clear()
    },
    async listMatScrapOpt() {
      const { retObj } = await getMatScrapOpt()
      this.matScrapOpt = retObj
    }
    // methods-end
  }
}
</script>

<style scoped lang="scss">
</style>
