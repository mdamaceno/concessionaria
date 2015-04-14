package com.example.mdamaceno.concessionaria.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mdamaceno.concessionaria.DatabaseHelper;
import com.example.mdamaceno.concessionaria.model.Usuario;

import java.util.List;

/**
 * Created by mdamaceno on 13/04/15.
 */
public class UsuarioDAO {
    private SQLiteDatabase banco;
    private DatabaseHelper createDB;

    public UsuarioDAO(Context context){
        createDB = new DatabaseHelper(context);
    }

    public void open() {
        banco = createDB.getWritableDatabase();
    }

    public void close() {
        banco.close();
    }

}
