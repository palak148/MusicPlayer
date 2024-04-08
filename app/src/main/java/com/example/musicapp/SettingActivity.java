package com.example.musicapp;

import static com.example.musicapp.AppController.StopSound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    Switch playmusic;
    Button bt;
     private boolean isMusicOn;
     private Context mContext;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext=SettingActivity.this;
        AppController.currentActivity=this;
        playmusic=findViewById(R.id.switch1);
        bt=findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        //method to play the sound
        populMusic();
    }
     private void switchMusicEnableCheckbox(){
        isMusicOn=!isMusicOn;
        if(isMusicOn){
             SharedThings.setMusicEnableDisbale(mContext,true);
             AppController.playSound();
        }
        else{
            SharedThings.setMusicEnableDisbale(mContext,false);
            AppController.StopSound();
        }
        populMusic();
     }
    private void populMusic(){
        if(SharedThings.getMusicEnabledisable(mContext)){
            AppController.playSound();
            playmusic.setChecked(true);
        }
        else{

            StopSound();
            playmusic.setChecked(false);
        }
        isMusicOn=SharedThings.getMusicEnabledisable(mContext);
    }

    public void viewClickHandler(View view) {
        switch(view.getId()){
            case R.id.switch1:
                switchMusicEnableCheckbox();
                break;
            case R.id.button:
                onBackPressed();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}