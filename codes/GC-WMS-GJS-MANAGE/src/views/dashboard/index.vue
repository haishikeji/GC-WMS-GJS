<template>
  <div class="dashboard-container">
    <el-empty :image-size="300" description="欢迎使用品讯·造币四部库房管理系统" />
    <!-- <component :is="currentRole" /> -->
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import adminDashboard from './admin'
import editorDashboard from './editor'

export default {
  name: 'Dashboard',
  components: { adminDashboard, editorDashboard },
  data() {
    return {
      currentRole: 'adminDashboard'
    }
  },
  computed: {
    ...mapGetters(['roles'])
  },
  created() {
    this.currentRole = 'adminDashboard'
    // if (!this.roles.includes('admin')) {
    //   this.currentRole = 'editorDashboard'
    // }
  }
}
</script>
<style scoped>
.dashboard-container {
  margin: 100px auto;
}
</style>
