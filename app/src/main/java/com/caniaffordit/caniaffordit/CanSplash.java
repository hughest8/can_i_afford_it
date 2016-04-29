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
    //sets the variables so the correct file can be opened
    public static final String fileName="Balance.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets the file to the correct file name
        file= new File(this.getFilesDir(),fileName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_splash);
        //sets the variables so the file can be read and variables stored
        int length =(int) file.length();
        byte[] bytes = new byte[length];
        String money="";

        try{
            InputStream inputStream=openFileInput(fileName);
            if ( inputStream != null ) { //checks if there is no data in the input stream
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();


                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    //appends the data to the to the string builder variable until the data transfer is complete
                }
                inputStream.close(); //closes the input stream
                money=stringBuilder.toString(); //places the data stored in stringbuilder in the money variable
                TextView textViewcfunds=(TextView) findViewById(R.id.textViewcfunds);
                textViewcfunds.setText(money); //prints the money variable in the textbox



            }





        } catch (Exception e){
            e.printStackTrace();
        }
        }



    public void openMoneyIn(View view){
        Intent intent = new Intent(this, AddMoneyIn.class); //opens the activity addmoneyin
        startActivity(intent);

    }
    public void gocanaffordit(View view){
        Intent intent = new Intent(this, CanIAffordIt.class); //opens the activity can i afford it
        startActivity(intent);

    }

    public void openMoneyOut(View view){
        Intent intent = new Intent(this, AddMoneyOut.class); //opens the activity addmoneyout
        startActivity(intent);

    }

    //public void openAccountdet(View view){
        //Intent intent = new Intent(this, Yourbalance.class); //no longer used, kept for future versions
        //startActivity(intent);

    //}
    @Override
    public void onResume(){
        super.onResume();

        file= new File(this.getFilesDir(),fileName);
        //This runs the same read function as used when the file opens when the app returns to this menu
        //See the previous read section for further details
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


