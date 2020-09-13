
// 这是一个用 node.js 写的微程序，来模拟非 java 的应用程序。这个程序可以单独运行（使用 node 命令执行，事先要安装好 node.js）。
// 启用后，可以直接在浏览器中访问（localhost:8060，localhost:8060/health.json）。

var http = require('http');
var url = require("url");
var path = require('path');

// 创建server
var server = http.createServer(function(req, res) {
  // 获得请求的路径
  var pathname = url.parse(req.url).pathname;  
  res.writeHead(200, { 'Content-Type' : 'application/json; charset=utf-8' });
  // 访问http://localhost:8060/，将会返回{"index":"欢迎来到首页"}
  if (pathname === '/') {
    res.end(JSON.stringify({ "index" : "欢迎来到首页" }));
  }
  // 访问http://localhost:8060/health，将会返回{"status":"UP"}，这个 status 会被引用为服务的可用状态。
  else if (pathname === '/health.json') {
    res.end(JSON.stringify({ "status" : "UP" }));
  }
  // 其他情况返回404
  else {
    res.end("404");
  }
});
// 创建监听，并打印日志
server.listen(8000, function() {
  console.log('listening on localhost:8060');
});