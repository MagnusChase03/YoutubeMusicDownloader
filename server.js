const http = require("http");

const hostname = "localhost";
const port = 3000;

const server = http.createServer((req, res) => {

    res.writeHeader(200, {"Content-Type": "text/plain"});
    res.write("Hello World!");
    res.end();

});

server.listen(port, hostname);