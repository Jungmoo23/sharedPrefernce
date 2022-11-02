package com.example.sharedpre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;
    Button btn;
    SharedPreferences pre;
    SharedPreferences.Editor editor;
    private final String FILE_NAME="hello";
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        varInit();
        pre = getSharedPreferences(FILE_NAME,Activity.MODE_PRIVATE);
        editor = pre.edit();
        t1.setText(pre.getString("write","ewqeqweqw"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = e1.getText().toString();
                Log.d(TAG, "onClick: "+editText);
                editor.putString("write",editText);
                editor.apply();
            }
        });
    }

    private void varInit(){
        e1 = (EditText)findViewById(R.id.edit1);
        btn = (Button)findViewById(R.id.btn);
        t1 = (TextView)findViewById(R.id.t1);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}