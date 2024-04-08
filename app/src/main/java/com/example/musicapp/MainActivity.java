package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btStart;
    public static Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=getApplicationContext();
        AppController.currentActivity= this;

        if(SharedThings.getMusicEnabledisable(context)){
            try{
                AppController.playSound();
            }
            catch(IllegalStateException e){
                e.printStackTrace();
            }
        }
        btStart=findViewById(R.id.button2);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onPause(){
        AppController.StopSound();
        super.onPause();
    }
    protected void onResume(){

        super.onResume();
        AppController.playSound();
    }

}