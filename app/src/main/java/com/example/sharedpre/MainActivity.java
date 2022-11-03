package com.example.sharedpre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;

    Button btn,nextPagebtn;

    Intent intent;
    AlertDialog.Builder builder;
    SharedPreferences pre;
    SharedPreferences.Editor editor;
    CheckBox checkBox;
    private final String FILE_NAME="hello";
    private final String TAG = "MainActivity";
    private final String MASTERID = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        varInit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = e1.getText().toString();
                Log.d(TAG, "onClick: "+editText);
                editor.putString("write",editText);
                editor.apply();
            }
        });

        nextPagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(MASTERID.equals(e1.getText().toString())){
                    intent.putExtra("ID",MASTERID);
                    startActivity(intent);
                }

                else{
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("경고!!!").setMessage("MASTERID가 다릅니다").create().show();
                }
            }
        });


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){

                    e1.setText(pre.getString("write",""));
                    Log.d(TAG,"click on");
                }else{
                    Log.d(TAG,"click off");
                }
            }
        });
        if(checkBox.isChecked()){
        }
        else{
            t1.setText(pre.getString("write","없어"));

        }

    }

   private void varInit(){
        e1 = (EditText)findViewById(R.id.edit1);
        btn = (Button)findViewById(R.id.btn);
        t1 = (TextView)findViewById(R.id.t1);
        checkBox = (CheckBox)findViewById(R.id.checkbox);
        nextPagebtn = (Button)findViewById(R.id.nextIntent);
        intent = new Intent(this,nextPage.class);
       pre = getSharedPreferences(FILE_NAME,Activity.MODE_PRIVATE);
       editor = pre.edit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}