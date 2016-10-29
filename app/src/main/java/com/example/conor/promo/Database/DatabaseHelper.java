package com.example.conor.promo.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by conor on 25/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper implements IStorage{

    // DB NAME
    public static final String DATABASE_NAME = "Promo.db";

    // VENUE TABLE
    public static final String VENUE_TABLE = "venue_table";
    // VENUE COLUMNS
    public static final String VT_COL1 = "ID";
    public static final String VT_COL2 = "NAME";
    public static final String VT_COL3 = "ADDRESS";

    // PROMOTION TABLE
    public static final String PROMOTION_TABLE = "promotion_table";
    // PROMOTION COLUMNS
    public static final String PRO_COL1 = "ID";
    public static final String PRO_COL2 = "NAME";
    public static final String PRO_COL3 = "DESCRIPTION";
    public static final String PRO_COL4 = "DRINK";
    public static final String PRO_COL5 = "PRICE";

    // DRINK TABLE
    public static final String DRINK_TABLE = "drink_table";
    // DRINK COLUMNS
    public static final String DRINK_COL1 = "ID";
    public static final String DRINK_COL2 = "NAME";
    public static final String DRINK_COl3 = "TYPE";


    public DatabaseHelper(Context context) {
        // CREATES DB WHEN CALLED
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // EXECUTES STRING QUERY
        db.execSQL("create table " + VENUE_TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, ADDRESS TEXT) ");
        db.execSQL("create table " + PROMOTION_TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, ADDRESS TEXT) ");
        db.execSQL("create table " + DRINK_TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, ADDRESS TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ VENUE_TABLE);
        onCreate(db);
    }

    // CRUD Functionality

    @Override
    public void CREATE() {

    }

    @Override
    public Object READ(Object obj) {
        return null;
    }

    @Override
    public void UPDATE(Object obj) {

    }

    @Override
    public void DELETE(Object obj) {

    }
}
