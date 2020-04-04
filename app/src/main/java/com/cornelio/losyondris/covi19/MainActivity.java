package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef;
    //= database.getReference("message");
int p = 0;
Context mcontext;
TextInputLayout cedula, telefono;
//Button registro;
SharedPreferences preferences;
RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
      //  setContentView(R.layout.activity_menu);

        final SharedPreferences preferences = getSharedPreferences("Login",MODE_PRIVATE);
        final String precedula = preferences.getString("cedula","?");

        if(precedula != "?"){
            setContentView(R.layout.activity_menu);

            //TextView d = (TextView) ;
            findViewById(R.id.titulodos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Rv.class));
                    ///finish();
                    //getSharedPreferences("Login",MODE_PRIVATE).edit().clear().apply();
                }
            });

            findViewById(R.id.id_sos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Sos.class));
                }
            });

        }else {
            setContentView(R.layout.activity_main);

      Button registro =(Button) findViewById(R.id.btnRegistro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavarDatos();
                Toast.makeText(MainActivity.this,"Registrado",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,Rv.class));
                //finish();
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



}
