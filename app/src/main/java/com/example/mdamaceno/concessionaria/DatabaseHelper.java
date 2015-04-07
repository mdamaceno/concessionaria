package com.example.mdamaceno.concessionaria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mdamaceno on 30/03/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper sInstance;
    private Context ctx;
    private static final String BANCO_DADOS = "Concessionaria";
    private static int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
        this.ctx = context;
    }

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you 
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usuarios (_id INTEGER PRIMARY KEY," +
            " nome TEXT, email TEXT, senha TEXT, tipo INTEGER);");

        db.execSQL("CREATE TABLE carros (_id INTEGER PRIMARY KEY," +
            " marca TEXT, modelo TEXT, ano INTEGER, km REAL," +
            " airbag INTEGER, arcondicionado INTEGER, cor TEXT, preco REAL);");

        db.execSQL("CREATE TABLE propostas (_id INTEGER PRIMARY KEY," +
            " idCarro INTEGER, idCliente INTEGER, idVendedor INTEGER" +
            " tipo_pgto INTEGER, num_parcelas INTEGER, valor_entrada REAL" +
            " valor_carro REAL, valor_final REAL, confirmado INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.ctx.deleteDatabase(BANCO_DADOS);
        //this.ctx.openOrCreateDatabase(BANCO_DADOS,077 7);
        onCreate(db);
    }
}
