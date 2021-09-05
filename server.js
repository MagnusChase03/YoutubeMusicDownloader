const express = require("express");
const path = require("path")
const app = express();
const port = 3000;

app.use(express.static(__dirname + "/assets"))

app.get("/", (req, res) => {

    res.sendFile(path.join(__dirname, 'assets/index.html'));

});

app.listen(port);
