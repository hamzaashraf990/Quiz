package com.example.hamza.assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
             Button stdsave, teachsave;
             Button next;
             EditText sfirstname;
             EditText slastname;
             EditText tfirstname;
             EditText tlastname;
             Student stduser=null;
             Teacher teachuser=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           stdsave=(Button)findViewById(R.id.btnsave1);
           teachsave=(Button)findViewById(R.id.btnsave2);
           next=(Button)findViewById(R.id.btnext1);
           sfirstname=(EditText)findViewById(R.id.edtname5);
           slastname=(EditText)findViewById(R.id.edtname6);
           tfirstname=(EditText)findViewById(R.id.edtname7);
           tlastname=(EditText)findViewById(R.id.edtname8);
           stduser=new Student();
           teachuser=new Teacher();


           stdsave.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String sfirst = sfirstname.getText().toString();
                   String slast=slastname.getText().toString();
                   Toast.makeText(MainActivity.this, "Successfully Save",Toast.LENGTH_SHORT).show();


               }
           });

           teachsave.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String tfirst = tfirstname.getText().toString();
                   String tlast = tlastname.getText().toString();
                   Toast.makeText(MainActivity.this, "Successfully Save", Toast.LENGTH_SHORT).show();

               }
           });
           next.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                       stduser.setFirstname(sfirstname.getText().toString());
                       stduser.setLastname(slastname.getText().toString());
                       teachuser.setFirstname(tfirstname.getText().toString());
                       teachuser.setLastname(tlastname.getText().toString());
                       Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                       intent.putExtra("student",stduser);
                       intent.putExtra("teacher",teachuser);
                       startActivity(intent);

               }
           });
    }
}
