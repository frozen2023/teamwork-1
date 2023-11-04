<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<style lang="less">
#app {
  height: 100vh;
  width: 100vw;;
}
html{
  margin-right: calc(100% - 100vw);
  overflow-x: hidden;
  margin: 0;
}
html::-webkit-scrollbar{
  display: none;
}
</style>
