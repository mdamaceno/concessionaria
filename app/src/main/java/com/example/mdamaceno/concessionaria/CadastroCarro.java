package com.example.mdamaceno.concessionaria;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mdamaceno on 25/03/15.
 */
public class CadastroCarro extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_carro);
    }

    public void salvarCadastro(View view) {
        Toast toast = Toast.makeText(this, "TESTANDO MENSAGEM", Toast.LENGTH_LONG);
        toast.show();
    }
}
