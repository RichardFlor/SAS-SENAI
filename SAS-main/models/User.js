"use strict";
import { Sequelize } from "sequelize";
import connection from "../database/connectMySQL.js";


const User = connection.define("tblUser", {
    userId: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    name:{
        type: Sequelize.STRING(50),
        allowNull: false
    },
    lastname:{
        type: Sequelize.STRING(50),
        allowNull: false
    },
    email:{
        type: Sequelize.STRING(100),
        allowNull: false
    },
    celular:{
        type: Sequelize.STRING(15),
        allowNull: false
    },
},
{
    timestamps: false,
});

//User.sync({force:true});


export default User;