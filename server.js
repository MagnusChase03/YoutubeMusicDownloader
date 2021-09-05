const express = require("express");
const path = require("path")
const app = express();
const port = 3000;

app.get("/", (req, res) => {

    res.sendFile(path.join(__dirname, 'assets/index.html'));

});

app.listen(port);
