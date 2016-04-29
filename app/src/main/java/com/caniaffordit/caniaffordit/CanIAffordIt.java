package com.caniaffordit.caniaffordit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CanIAffordIt extends AppCompatActivity {
    public static final String fileName="Balance.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;
    EditText editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //prepares the variables before the file is read
        file= new File(this.getFilesDir(),fileName);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_iafford_it);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        editText3=(EditText) findViewById(R.id.editText3);
    }
    public void caniaffordit(View view) {
        //reads the data from the file. Please see the splash page file for more details

        String affordhold =editText3.getText().toString();
        int canAfford= Integer.parseInt(affordhold);
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
                int moneyint= Integer.parseInt(money);


                if(canAfford<moneyint){ //checks if the file variable is greater than the user entered variable
                    TextView confirmer=(TextView) findViewById(R.id.confirmer);
                    confirmer.setText("Yes you can!"); //displayed if true
                }else{
                    TextView confirmer=(TextView) findViewById(R.id.confirmer);
                    confirmer.setText("No you can't!"); //displayed if false
                }




            }





        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void gomainmenu(View view) {
        finish();
    }
}
