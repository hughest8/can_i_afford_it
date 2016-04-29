package com.caniaffordit.caniaffordit;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tom on 26/04/2016.
 */
public class Account {

    //private variables
    int _id;
    String _item;
    int _value;

    //Empty constructor
    public Account(){

    }
    // Constructor
    public Account(int id, String item, int value){
        this._id=id;
        this._item=item;
        this._value=_value;
    }

    //constructor
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
