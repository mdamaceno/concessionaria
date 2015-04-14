package com.example.mdamaceno.concessionaria;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText edtUsuario;
    private EditText edtSenha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void entrarOnClick(View view) {
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        String usuarioInformado = edtUsuario.getText().toString();
        String senhaInformada = edtSenha.getText().toString();

        if ("marco".equals(usuarioInformado) && "123".equals(senhaInformada)) {
            startActivity(new Intent(this, CadastroCarro.class));
        } else if ("victor".equals(usuarioInformado) && "123".equals(senhaInformada)){
            startActivity(new Intent(this, CadastroCarro.class));
        } else {
            String mensagemErro = "Usuário ou senha inválidos!";
            Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_LONG);
            toast.show();
            edtSenha.setText("");
        }
    }

    public void cadastrarUsuario(View view){
        startActivity(new Intent(this, CadastroCliente.class));
    }
}
