<template>
  <div class="home-container">
    <!-- 头部区域 -->
    <myHeader></myHeader>

    <!-- 页面主体区域 -->
    <div class="home-main-box">
      <!-- 左侧边栏 -->
      <myAside></myAside>
      <!-- 右侧内容主体区域 -->
      <div class="home-main-body">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
// 头部区域组件
import myHeader from '@/views/home/myHead.vue'
// 左侧边栏组件
import myAside from '@/views/home/Aside.vue'
export default {
  name: 'homeIndex',
  components: {
    myHeader,
    myAside
  },
  data () {
    return {}
  },
  methods: {},
  created () {},
}
</script>
<style scoped lang='less'>
.home-container {
  height: 100%;
  width: 100vw;
  display: flex;
  flex-direction: column;

  .home-main-box {
    height: 100%;
    width: 100vw;
    display: flex;
    .home-main-body {
      width: calc(100vw - 250px);
      height: 100%;
      flex: 1;
    }
  }
}
</style>
