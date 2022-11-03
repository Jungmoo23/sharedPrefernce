package com.example.sharedpre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class nextPage extends AppCompatActivity {

    TextView nextTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextpage);

        nextTextView = (TextView)findViewById(R.id.nextpagetext);

        Intent intent = getIntent();

        nextTextView.setText(intent.getStringExtra("ID"));

    }

}
