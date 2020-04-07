package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Abjuste extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    Window window;
    Switch sw;
    Bd_Ajusted bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bd = new Bd_Ajusted(this);
        if (bd.loanNight()==true){ setTheme(R.style.mythema);
        }else { setTheme(R.style.AppTheme); }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abjuste);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sw = (Switch) findViewById(R.id.btnThema);
        ///AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        if (bd.loanNight()==true){
            sw.setChecked(true);
        }


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                     AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    bd.setNight(true);
                   // retarApp();
                }else {
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    bd.setNight(false);
                   retarApp();
                }
            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rv,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(Abjuste.this,MainActivity.class));
                break;
            case R.id.uno:
                break;
            case R.id.dos:
                break;

        }

        return true;
    }



    private void retarApp() {
        Intent i = new Intent(getApplicationContext(), Abjuste.class);
        startActivity(i);
        finish();

    }
}
