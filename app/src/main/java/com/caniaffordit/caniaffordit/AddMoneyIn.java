package com.caniaffordit.caniaffordit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import java.io.OutputStreamWriter;

public class AddMoneyIn extends AppCompatActivity {
    EditText idText, itemText, valueText;
    public static final String fileName="Balance.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        file= new File(this.getFilesDir(),fileName);
        setContentView(R.layout.activity_add_money_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        idText=(EditText) findViewById(R.id.IDText);
        itemText=(EditText) findViewById(R.id.itemText);
        valueText=(EditText) findViewById(R.id.valueText);






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addthefunds(View view){
        //fun stuff before the data read write

        int anID = Integer.parseInt(idText.getText().toString());
        String aItem= itemText.getText().toString();
        String tempval = valueText.getText().toString();

        int aValue= Integer.parseInt(tempval);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addAccount(new Account(anID,aItem,aValue));
        TextView textView3=(TextView) findViewById(R.id.textView3);


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
                aValue= aValue+moneyint;
                tempval = String.valueOf(aValue);




            }





        } catch (Exception e){
            e.printStackTrace();
        }









        //try and write to file to store balance
        textView3.setText(String.valueOf(aValue));
        try{
            outputStream= new FileOutputStream(file);
            outputStream.write(tempval.getBytes());


            outputStream.close();
            Toast.makeText(AddMoneyIn.this, "data saved", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
        //TextView textViewcfunds=(TextView) findViewById(R.id.textViewcfunds);
        //textViewcfunds.setText(aValue);

        finish();

}


}
