package com.caniaffordit.caniaffordit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CanSplash extends AppCompatActivity {
    public static final String fileName="Balance.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        file= new File(this.getFilesDir(),fileName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_splash);
        int length =(int) file.length();
        byte[] bytes = new byte[length];
        String money="";

        try{
            InputStream inputStream=openFileInput(fileName);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                money=stringBuilder.toString();
                TextView textViewcfunds=(TextView) findViewById(R.id.textViewcfunds);
                textViewcfunds.setText(money);



            }





        } catch (Exception e){
            e.printStackTrace();
        }








        }



    public void openMoneyIn(View view){
        Intent intent = new Intent(this, AddMoneyIn.class);
        startActivity(intent);

    }
    public void gocanaffordit(View view){
        Intent intent = new Intent(this, CanIAffordIt.class);
        startActivity(intent);

    }

    public void openMoneyOut(View view){
        Intent intent = new Intent(this, AddMoneyOut.class);
        startActivity(intent);

    }

    public void openAccountdet(View view){
        Intent intent = new Intent(this, Yourbalance.class);
        startActivity(intent);

    }
    @Override
    public void onResume(){
        super.onResume();

        file= new File(this.getFilesDir(),fileName);

        int length =(int) file.length();
        byte[] bytes = new byte[length];
        String money="";

        try{
            InputStream inputStream=openFileInput(fileName);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                money=stringBuilder.toString();
                TextView textViewcfunds=(TextView) findViewById(R.id.textViewcfunds);
                textViewcfunds.setText(money);



            }





        } catch (Exception e){
            e.printStackTrace();
        }

    }

    }


