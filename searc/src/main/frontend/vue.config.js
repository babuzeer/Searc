const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../resources/static',  // 调整输出目录到Spring Boot的静态资源目录
  indexPath: 'index.html',  // 将入口文件输出到Spring Boot的模板目录
  publicPath: process.env.NODE_ENV === 'production' ? '/' : '/',
});
