package com.example.taruc.restart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity  extends AppCompatActivity {
    Intent intent;
    public static String ACTIVITY = "com.example.taruc.restart.extra.ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        intent = getIntent();
        TextView tv = findViewById(R.id.tv_username);
        String username = intent.getStringExtra(MainActivity.NAME);
        tv.setText(username);

    }

    public void onBackPressed(){
        String previousActivity = intent.getStringExtra(ACTIVITY);
        if(previousActivity.equalsIgnoreCase(MainActivity.class.getSimpleName())) {
            Toast toast = Toast.makeText(this, "You cannot return to the previous page.", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void logout(View view){
        Intent intent = new Intent(this,MainActivity.class);
        Log.d(SecondActivity.class.getSimpleName(),"Logout");
        startActivity(intent);
    }
}
