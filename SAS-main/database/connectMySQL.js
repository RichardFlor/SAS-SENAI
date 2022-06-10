"use strict";
import { Sequelize } from "sequelize";

const connection = new Sequelize(
    "sas",
    "root",
    "12345678",
    {
        host: "localhost",
        dialect: "mysql"
    }
);

connection.authenticate().then(()=>{
    console.log("Sucess database connection");
}).catch((error)=>{
    console.log(error || "Failed database connection");
});

export default connection;