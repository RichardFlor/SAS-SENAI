const express = require('express');
const axios = require('axios').default;

const app = express();

app.use(express.json());
app.use(express.urlencoded({extended:true}));

app.post('/cliente/cadastrarcliente', (req, res)=>{

    let {name, lastname, email, celular} = req.body;

    console.log(req.body);
    // res.send('INSERÇÃO');

    const urlCadastrarCliente = 'http://localhost:3000/user';

    axios.post(urlCadastrarCliente, 
        {
            name : name,
            lastname : lastname,
            email : email,
            celular : celular,
        },
        {
            'content-type': 'application/json'
        }
    ).then(function (response) {
        res.send(response.data);
        console.log(response);
    })

});

app.get('/cliente/listarcliente', (req, res)=>{

    const urlListarCliente = 'http://localhost:3000/user';

    axios.get(urlListarCliente, 
        
        {
            'content-type': 'application/json'
        }
    ).then(function (response) {
        console.log(response.data);
        res.send(response.data);
        
    })

});

app.listen(3001, ()=>{
    console.log('SERVIDOR RODANDO EM http://localhost:3001');
});

