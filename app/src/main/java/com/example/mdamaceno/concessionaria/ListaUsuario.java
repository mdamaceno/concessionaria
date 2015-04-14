package com.example.mdamaceno.concessionaria;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mdamaceno.concessionaria.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdamaceno on 13/04/15.
 */
public class ListaUsuario extends ActionBarActivity {
    ListView listView;
    private DatabaseHelper helper;
    private ArrayList<String> resultados = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_usuario);

        helper = DatabaseHelper.getInstance(this);

        SQLiteDatabase dbh = helper.getReadableDatabase();
        Cursor c = dbh.rawQuery("select * from usuarios",null);
        c.moveToFirst();

//        while (c.moveToNext()){
//            String name = c.getString(c.getColumnIndex("nome"));
//            resultados.add(name);
//        }

        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("nome"));
            String email = c.getString(c.getColumnIndex("email"));
            resultados.add(name + " - " + email);
        }

//        if (c != null) {
//            if (c.moveToFirst()) {
//                do {
//                    String name = c.getString(c.getColumnIndex("nome"));
//                    resultados.add(name);
//                } while (c.moveToNext());
//            }
//        }

        c.close();

        /*
        String[] values = new String[]{
                "Android List View",
                "Adapter Implementation",
                "Simple List View In Android",
                "Create List View in Android",
                "Android Example"
        };
        */

        ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados);

        ListView allValues = (ListView)findViewById(R.id.list);
        allValues.setAdapter(valuesArrayAdapter);
    }
}
