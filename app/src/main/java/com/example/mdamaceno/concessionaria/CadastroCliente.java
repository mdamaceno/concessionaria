package com.example.mdamaceno.concessionaria;

import android.app.ActionBar;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by mdamaceno on 30/03/15.
 */
public class CadastroCliente extends ActionBarActivity {

    private DatabaseHelper helper;
    private EditText edtNome, edtEmail, edtSenha, edtSenha2;
    RadioGroup rg;
    int pos, pos1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_cliente);

        helper = DatabaseHelper.getInstance(this);

        rg = (RadioGroup) findViewById(R.id.rdoTipo);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            pos = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

            Toast.makeText(getBaseContext(), "ID = " + String.valueOf(pos), Toast.LENGTH_SHORT).show();

            switch (pos){
                case 0 :
                    pos1 = 0;
                break;
                case 1 :
                    pos1 = 1;
                break;
            }
            }
        });
    }

    public void gravarUsuario(View view) {
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtSenha2 = (EditText) findViewById(R.id.edtSenha2);

        if (edtSenha2.getText().toString().equals(edtSenha.getText().toString())) {
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nome", edtNome.getText().toString());
            values.put("email", edtEmail.getText().toString());
            values.put("senha", edtSenha.getText().toString());
            values.put("tipo", pos1);

            long resultado = db.insert("usuarios", null, values);

            if(resultado != -1) {
                SQLiteDatabase dbh = helper.getReadableDatabase();
                Cursor c = dbh.rawQuery("select * from usuarios",null);
                c.moveToFirst();

                while (c.moveToNext()){
                    Log.d("Nome: ",c.getString(1));
                }

                c.close();
                Toast toast = Toast.makeText(this, "Registro salvo com sucesso.", Toast.LENGTH_LONG);
                toast.show();

                // Limpando o formulário
                edtNome.setText("");
                edtSenha.setText("");
                edtSenha2.setText("");
                edtEmail.setText("");

            } else {
                Toast toast = Toast.makeText(this, "Não foi possível cadastrar.", Toast.LENGTH_LONG);
                toast.show();
            }

        } else {
            Toast toast = Toast.makeText(this, "Senhas não conferem!", Toast.LENGTH_LONG);
            toast.show();

            // Limpando campo de senha
            edtSenha.setText("");
            edtSenha2.setText("");
        }
    }
}
