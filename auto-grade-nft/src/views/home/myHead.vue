 <template>
  <div class="layout-header-container d-flex justify-content-between align-items-center p-3">
    <!-- 左侧 logo 和 标题区域 -->
    <div class="layout-header-left d-flex align-items-center user-select-none">
      <!-- logo -->
      <img class="layout-header-left-img" src="" alt="">
      <!-- 标题 -->
      <h4 class="layout-header-left-title ml-3">自动化学生成绩通知平台</h4>
    </div>

    <!-- 右侧按钮区域 -->
    <div class="layout-header-right">
      <button type="button" class="btn btn-light" @click="log">登录</button>
    </div>
  </div>
 </template>
 
 <script>
 export default {
  name: 'myHead',
  components: {},
  data () {
    return {}
  },
  methods: {
    log() {

    }
  },
  created () {},
 }
 </script>
 <style scoped lang='less'>
.layout-header-container {
  .px2vh(height, 65);
  border-bottom: 0.1vh solid #eaeaea;
}

.layout-header-left-img {
  height: 50px;
}
 </style>
 