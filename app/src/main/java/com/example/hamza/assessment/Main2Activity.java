package com.example.hamza.assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import static com.example.hamza.assessment.R.drawable.hello;

public class Main2Activity extends AppCompatActivity {
     Button   stdRatingsave, teachexpertisesave;
     Button next1;
    String rating_float = "0.0";
    CheckBox teachandroid, teachweb;
    ImageView studimg;
    ImageView teachimg;
    Student stduser=null;
    Teacher teachuser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        stdRatingsave = (Button) findViewById(R.id.btnsave3);
        teachexpertisesave = (Button) findViewById(R.id.btnsave4);
        next1 = (Button) findViewById(R.id.btnext1);
        studimg=(ImageView)findViewById(R.id.imview1);
        teachimg=(ImageView)findViewById(R.id.imview2);
        teachandroid = (CheckBox) findViewById(R.id.checkBox);
        teachweb = (CheckBox) findViewById(R.id.checkBox2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_float = String.valueOf(rating);
            }
        });

        if(teachandroid.isChecked()){
            Toast.makeText(Main2Activity.this,"Android",Toast.LENGTH_SHORT).show();
        }
        if(teachweb.isChecked()){
            Toast.makeText(Main2Activity.this,"Web",Toast.LENGTH_SHORT).show();
        }

        Bundle extras=getIntent().getExtras();
        stduser=(Student)extras.getSerializable("student");
        teachuser=(Teacher)extras.getSerializable("teacher");
        Toast.makeText(Main2Activity.this,stduser.getFirstname()+" "+stduser.getLastname(),Toast.LENGTH_SHORT).show();
        Toast.makeText(Main2Activity.this,teachuser.getFirstname()+""+teachuser.getLastname(),Toast.LENGTH_SHORT).show();

        stdRatingsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"Successfully Save",Toast.LENGTH_SHORT).show();
                  studimg.setImageResource(R.drawable.hello);
            }
        });
        teachexpertisesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      Toast.makeText(Main2Activity.this,teachandroid.isChecked()+"",Toast.LENGTH_SHORT).show();
                      Toast.makeText(Main2Activity.this,teachweb.isChecked()+"",Toast.LENGTH_SHORT);
                      teachimg.setImageResource(R.drawable.logo);
            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(Main2Activity.this,Main3Activity.class);
                in.putExtra("student",stduser);
                in.putExtra("teacher",teachuser);
                in.putExtra("rating",toString());
                in.putExtra("checkbox",teachandroid.isChecked());
                in.putExtra("checkbox",teachweb.isChecked());
                in.putExtra("studimg",stduser);
                in.putExtra("teachimg" ,teachuser);
                startActivity(in);
            }
        });
    }


}
