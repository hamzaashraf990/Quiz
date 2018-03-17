package com.example.hamza.assessment;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Student stduser=null;
    Teacher teachuser=null;
    TextView studfirst,studlast;
    TextView teachfirst,teachlast;
    TextView teachexpert;
    RatingBar rating2;
    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        studfirst=(TextView)findViewById(R.id.textView);
        studlast=(TextView)findViewById(R.id.textView2);
        teachfirst=(TextView)findViewById(R.id.textView4);
        teachlast=(TextView)findViewById(R.id.textView5);
        teachexpert=(TextView)findViewById(R.id.txtExpert);
        rating2=(RatingBar)findViewById(R.id.ratingBar2);
        img1=(ImageView)findViewById(R.id.imview3);
        img2=(ImageView)findViewById(R.id.imview4);
        Bundle extras=getIntent().getExtras();
        stduser=(Student)extras.getSerializable("student");
        teachuser=(Teacher)extras.getSerializable("teacher");
        studfirst.setText(stduser.getFirstname());
        studlast.setText(stduser.getLastname());
        teachfirst.setText(teachuser.getFirstname());
        teachlast.setText(teachuser.getLastname());
        teachexpert.setText(teachuser.getExpertise());
        rating2.setRating(Float.parseFloat(stduser.getRating()));
        teachexpert.setText(teachuser.getExpertise());
        img1.setImageResource(R.drawable.hello);
        img2.setImageResource(R.drawable.logo);
    }
}
