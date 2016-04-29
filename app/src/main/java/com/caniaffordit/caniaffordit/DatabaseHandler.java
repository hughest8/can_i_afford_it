package com.caniaffordit.caniaffordit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tom on 26/04/2016.
 */
public class DatabaseHandler  extends SQLiteOpenHelper{
    //All Static variables
    //Database Version

    public void onCreate(SQLiteDatabase db){
    db.execSQL("CREATE TABLE accounts (id,item,value)");
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){

    }

    //private static final int DATABASE_VERSION=1;

    //Database Name
    //private static final String DATABASE_NAME= "userAccount";

    //Contacts table name
    //private static final String TABLE_CONTACTS = "accounts";


    public DatabaseHandler(Context context){
        super(context, "accounts",null,1);


    }

    public void addAccount(Account account){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put("id", account.getID());
        values.put("item", account.getItem());
        values.put("value", account.getValue());

        long result =db.insert("accounts", null, values);
        if (result >0){
            Log.d("dbhelper","inserted successfully");
        }else {
            Log.d("dbhelper", "failed to insert");
        }
        db.close();

    }


}


