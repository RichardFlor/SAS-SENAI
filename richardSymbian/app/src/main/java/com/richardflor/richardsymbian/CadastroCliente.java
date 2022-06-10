package com.richardflor.richardsymbian;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.richardflor.richardsymbian.model.Cliente;
import com.richardflor.richardsymbian.remote.APIUtil;
import com.richardflor.richardsymbian.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroCliente extends AppCompatActivity {


    TextView titulo, subtitulo, login;
    EditText txtNome, txtSobrenome, txtEmail, txtCelular;
    Button btnCadastrar;
    RouterInterface routerInterface;

    String nome, sobrenome, email, celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        login = findViewById(R.id.tvLogin2);
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtCelular = findViewById(R.id.txtTelefone);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        routerInterface = APIUtil.getClientInterface();


        btnCadastrar.setOnClickListener(view -> {

                    AlertDialog dialog = new AlertDialog.Builder(this)
                            .setTitle("CADASTRO COMO CLIENTE NA PLATAFORMA SYMBIAN")
                            .setMessage("O cadastro será concluído e você entrará em nossa base de dados! =)")
                            .setPositiveButton("CADASTRAR", (dialog1, which) -> {

                                nome = txtNome.getText().toString();
                                sobrenome = txtSobrenome.getText().toString();
                                email = txtEmail.getText().toString();
                                celular = txtCelular.getText().toString();

                                Log.d("Teste - Nome", nome);
                                Log.d("Teste - Sobrenome", sobrenome);
                                Log.d("Teste - Email", email);
                                Log.d("Teste - Celular", celular);

                                Cliente cliente = new Cliente();

                                cliente.setNome(nome);
                                cliente.setSobrenome(sobrenome);
                                cliente.setEmail(email);
                                cliente.setCelular(celular);

                                addCliente(cliente);

                                Call<Cliente> call = routerInterface.addCliente(cliente);

                            })
                            .setNegativeButton("CANCELAR", (dialog1, wich)->{})
                            .create();

                    dialog.show();
                }
        );

    }

    public void addCliente(Cliente cliente){

        Call<Cliente> call = routerInterface.addCliente(cliente);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Log.d("Teste - OnResponse:", response.message());
                Toast.makeText(CadastroCliente.this, "Você foi registrado como cliente na symbian, só agradece s2!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.d("Teste - OnResponse:", t.getMessage(), t);
                Toast.makeText(CadastroCliente.this, "Deu ruim meu patrão, desculpe!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
