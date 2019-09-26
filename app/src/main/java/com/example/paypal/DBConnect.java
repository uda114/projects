package com.example.paypal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static java.sql.Types.NULL;

public class DBConnect extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "payment.db";
    public static final String TABLE_NAME = "payment_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "P_ID";
    public static final String COL_3 = "PAYMENT";



    public DBConnect(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME  +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "P_ID INTEGER ," +
                "PAYMENT DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate(db);
    }
}
