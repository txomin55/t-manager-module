// vue.config.js
module.exports = {
  transpileDependencies: ["vuetify"],
  // proxy all webpack dev-server requests starting with /api
  // to our Spring Boot backend (localhost:8002) using http-proxy-middleware
  // see https://cli.vuejs.org/config/#devserver-proxy
  devServer: {
    port: 8080,
    proxy: {
      "/": {
        target: "http://localhost:8002", // this configuration needs to correspond to the Spring Boot backends' application.yml server.port
        ws: true,
        changeOrigin: true
      }
    }
  },
  // Change build paths to make them Maven compatible
  // see https://cli.vuejs.org/config/
  outputDir: "target/dist",
  assetsDir: "static",
  publicPath: "/module"
};
