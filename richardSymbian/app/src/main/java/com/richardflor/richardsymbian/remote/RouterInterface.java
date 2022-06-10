package com.richardflor.richardsymbian.remote;

import com.richardflor.richardsymbian.model.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {

    @POST("/cliente/cadastrarcliente")
    Call<Cliente> addCliente(@Body Cliente cliente);

    @GET("/cliente/listarcliente")
    Call<List<Cliente>>getCliente();

}
