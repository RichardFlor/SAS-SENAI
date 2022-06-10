"use strict";
import Express from "express";

import { createUser } from "./controllers/user/createUser.js"

const app = Express();

app.use(Express.json());


app.post("/user", async (req, res)=>{
    const resCreate = await createUser(req.body);
    if(resCreate) return res.status(201).json(resCreate);
    res.status(400).send("bad request");
});

app.listen(3000, ()=>{
    console.log("server is running, url: http://localhost:3000");
});
