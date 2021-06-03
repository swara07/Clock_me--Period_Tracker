package com.example.periodtracker;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String SHARED_PRE = "session";
    String Sessionkey = "session_user";

    public SessionManagement(Context context) {
        sp = context.getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
        ed = sp.edit();


    }

    public void savesaession(User user) {

        String name=user.getName();
        ed.putString(Sessionkey,name).commit();


    }

    public String getSesion() {

        return  sp.getString(Sessionkey,"-1");


    }
    public void removeSession(){
        ed.putString(Sessionkey,"-1").commit();
    }

}
