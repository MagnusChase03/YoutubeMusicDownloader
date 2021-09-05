const express = require("express");
const path = require("path");
const formidable = require("express-formidable");
const { exec } = require("child_process");

const app = express();
const port = 3000;

app.use(express.static(__dirname + "/assets"));
app.use(express.static(__dirname + "/music"));
app.use(formidable());

app.get("/", (req, res) => {

    res.sendFile(path.join(__dirname, 'assets/index.html'));

});

app.post("/post", (req, res) => {

    const URL = req.fields["URL"];
    const fileName = req.fields["fileName"];
    console.log(fileName);

    exec("java backend.Download " + URL + " " + fileName, (error, stdout, stderr) => {
        
        console.log(stdout);
        res.download(__dirname + "/music/" + fileName + ".mp3");

    });

});

app.listen(port);
