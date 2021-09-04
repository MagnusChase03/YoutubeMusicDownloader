const http = require("http");
const fs = require("fs");

const hostname = "localhost";
const port = 3000;

const server = http.createServer((req, res) => {

    res.writeHeader(200, {"Content-Type": "text/html"});
    
    const html = fs.readFileSync("./index.html");
    res.write(html);

    res.end();

});

server.listen(port, hostname);