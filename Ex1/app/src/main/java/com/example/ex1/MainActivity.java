package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editTextNumber);
        editText2 = (EditText)findViewById(R.id.editTextNumber2);
        textView = (TextView)findViewById(R.id.textView1);
        button = (Button)findViewById(R.id.button);
    }

     public void doSum(View view){
        textView.setText(Integer.toString(Integer.parseInt(editText1.getText().toString()) + Integer.parseInt(editText2.getText().toString())));
    }
}