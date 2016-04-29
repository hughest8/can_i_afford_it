package com.caniaffordit.caniaffordit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddMoneyOut extends AppCompatActivity {

    EditText idText, editText, editText2;
    public static final String fileName="Balance.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        file= new File(this.getFilesDir(),fileName);
        setContentView(R.layout.activity_add_money_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //idText=(EditText) findViewById(R.id.IDText);
        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

    }






    public void takethefunds(View view) {
            //fun stuff before the data read write

            //int anID = Integer.parseInt(idText.getText().toString());
            String aItem= editText.getText().toString();
            String tempval = editText2.getText().toString();

            int aValue= Integer.parseInt(tempval);
            //DatabaseHandler db = new DatabaseHandler(this);
            //db.addAccount(new Account(anID,aItem,aValue));



            //try and read the current data
            int length =(int) file.length();
            byte[] bytes = new byte[length];
            String money="";
            int moneyint=0;

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
                    moneyint= Integer.parseInt(money);
                    aValue= moneyint-aValue;
                    tempval = String.valueOf(aValue);




                }





            } catch (Exception e){
                e.printStackTrace();
            }









            //try and write to file to store balance

            try{
                outputStream= new FileOutputStream(file);
                outputStream.write(tempval.getBytes());


                outputStream.close();
                Toast.makeText(AddMoneyOut.this, "data saved", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.printStackTrace();
            }


            finish();


    }
}
