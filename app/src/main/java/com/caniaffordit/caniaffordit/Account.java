package com.caniaffordit.caniaffordit;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tom on 26/04/2016.
 */
public class Account {
// the following is the construction of a database class which was going to be used to operate a database.
    // However the database was not completed in time, so this section wasn't used
    //Setting the database variables
    int _id;
    String _item;
    int _value;

    //Empty constructor
    public Account(){

    }
    // Constructor 1
    public Account(int id, String item, int value){
        this._id=id;
        this._item=item;
        this._value=_value;
    }

    //constructor 2
    public Account(String item, int value){
        this._item=item;
        this._value=_value;
    }

    //getting ID
    public int getID(){
     return this._id;
    }

    //setting ID
    public void setID(int id){
        this._id= id;
    }

    //getting item
    public String getItem(){
        return this._item;
    }

    //setting item
    public void setItem(String item){
        this._item= item;
    }

    //getting value
    public int getValue(){
        return this._value;
    }

    //setting value
    public void setValue(int value){
        this._value=value;
    }

}
