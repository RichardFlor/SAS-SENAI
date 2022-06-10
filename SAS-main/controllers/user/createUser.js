"use strict";

import User from "../../models/User.js";


const createUser = async ({name, lastname, email,celular}) =>{
    try{
        const newRequest = await User.create({
            name: name,
            lastname: lastname,
            email: email,
            celular: celular,
        });
        return newRequest;
    }catch(err){
        console.log(err);
        return false;
    }
};

export {
    createUser
};