const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../../src/main/resources/static',  // 调整输出目录到Spring Boot的静态资源目录
  indexPath: '../../src/main/resources/templates/index.html',  // 将入口文件输出到Spring Boot的模板目录
  publicPath: process.env.NODE_ENV === 'production' ? '/' : '/',
});
