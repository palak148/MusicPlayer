package com.example.musicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedThings {
    public static final String Show_music_ONOFF="show_music_enable_disable";
    public static void setMusicEnableDisbale(Context context,boolean result){
        //shared preferences are basically the key value pair storing and receiving data without using database
        SharedPreferences prfs= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEdit= prfs.edit();
        prefsEdit.putBoolean(Show_music_ONOFF,result);
        prefsEdit.commit();//we want music to play instantly in the background so we will use commit instead
        //of apply


    }
    public static boolean getMusicEnabledisable(Context context){
        SharedPreferences prfs= PreferenceManager.getDefaultSharedPreferences(context);
        return prfs.getBoolean(Show_music_ONOFF,Constant.Default_music_setting);
        //initially music is disabled
    }
}
