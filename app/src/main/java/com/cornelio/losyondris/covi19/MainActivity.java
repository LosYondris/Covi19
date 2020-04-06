package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //= database.getReference("message");
int p = 0;
Context mcontext;
TextInputLayout cedula, telefono;
//Button registro;
SharedPreferences preferences;
RequestQueue queue;
GPSTracker gps;
Bd_Ajusted bd;
private static final int REQUEST_CODE_ASK_PERMISSIONS = 507;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bd = new Bd_Ajusted(this);
        if (bd.loanNight()==true){ setTheme(R.style.mythema);
        }else { setTheme(R.style.NoAppTheme); }
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
      //  setContentView(R.layout.activity_menu);
        btnpermisos();

        final SharedPreferences preferences = getSharedPreferences("Login",MODE_PRIVATE);
        final String precedula = preferences.getString("cedula","?");

        if(precedula != "?"){
            setContentView(R.layout.activity_menu);

            //TextView d = (TextView) ;
            findViewById(R.id.titulodos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Rv.class));
                    finish();
                    //getSharedPreferences("Login",MODE_PRIVATE).edit().clear().apply();
                }
            });

            findViewById(R.id.id_sos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Sos.class));
                    finish();
                }
            });

            findViewById(R.id.id_sos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Sos.class));
                    finish();
                }
            });

            findViewById(R.id.id_postnews).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,News.class));
                    finish();
                }
            });

            findViewById(R.id.id_abjuste).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Abjuste.class));
                    finish();
                }
            });







        }else {
            setContentView(R.layout.activity_main);

      Button registro =(Button) findViewById(R.id.btnRegistro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavarDatos();
                //Toast.makeText(MainActivity.this,"Registrado",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,Rv.class));
                finish();
            }
        });

        };



    }


    public  void SavarDatos(){
        preferences = getSharedPreferences("Login",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = preferences.edit();

        cedula = (TextInputLayout) findViewById(R.id.idCedula);
        telefono = (TextInputLayout) findViewById(R.id.idtelefono);

        String ced = cedula.getEditText().getText().toString();
        String tel = telefono.getEditText().getText().toString();
        Log.i("TAG","DATO :"+ced+" "+tel);
        ed.putString("cedula",ced);
        ed.putString("telefono",tel);
        ed.commit();

        cedula.getEditText().setText("");
        telefono.getEditText().setText("");

    }



    public void btnpermisos(){
        //Se realiza la petición de permisos para dispositivos con OS >= 6.0
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){

            }else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                        /* Manifest.permission.CAMERA,*/
                }, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }else{
            // No se necesita requerir permiso, OS menor a 6.0.
        }
    }


}
