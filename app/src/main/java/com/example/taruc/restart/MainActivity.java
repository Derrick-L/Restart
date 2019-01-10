package com.example.taruc.restart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    public static String NAME = "com.example.taruc.restart.extra.NAME";
    public static String ACTIVITY = "com.example.taruc.restart.extra.ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        if(intent !=null){
            Toast toast = Toast.makeText(this,"You have logged out",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onBackPressed(){
        if(intent !=null){
            Toast toast = Toast.makeText(this,"You cannot return to the previous page.",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            super.onBackPressed();
        }
    }

    public void nextPage(View view){
        EditText et_password = findViewById(R.id.etPassword);
        Integer password = Integer.parseInt(et_password.getText().toString());

        if(password == 123) {
            Intent intent = new Intent(this, SecondActivity.class);
            EditText etName = findViewById(R.id.editText);
            intent.putExtra(NAME, etName.getText().toString());
            String thisActivity = MainActivity.class.getSimpleName();
            intent.putExtra(ACTIVITY, thisActivity);
            Log.d(MainActivity.class.getSimpleName(), "Clicked!");
            startActivity(intent);
        }
        else{
            TextView tv_err = findViewById(R.id.tv_err);
            tv_err.setVisibility(View.VISIBLE);

            Log.d(MainActivity.class.getSimpleName(), "Denied");
        }
    }
}
