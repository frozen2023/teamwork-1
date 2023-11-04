const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath: './',
  css: {
    loaderOptions: {
      less: {
        additionalData: `@import "@/assets/style/utils.less";`,
      },
    },
  }
})
