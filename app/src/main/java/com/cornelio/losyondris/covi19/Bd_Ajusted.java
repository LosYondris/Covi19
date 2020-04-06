package com.cornelio.losyondris.covi19;

import android.content.Context;
import android.content.SharedPreferences;

public class Bd_Ajusted {
    SharedPreferences sharedPref;
    public Bd_Ajusted(Context context){
        sharedPref = context.getSharedPreferences("thema",Context.MODE_PRIVATE);
    }

    public void setNight(Boolean stado){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Thema",stado);
        editor.commit();
    }

    public Boolean loanNight(){
        Boolean stado = sharedPref.getBoolean("Thema",false);
        return stado;
    }
}
