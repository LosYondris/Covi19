package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Sos extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btn_sosE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gps = new GPSTracker(v.getContext());
                String Ids = UUID.randomUUID().toString();
                Map<String, Object> f = new HashMap<>();
                f.put("Lat", gps.latitude);
                f.put("Log", gps.longitude);
                myRef.child("Covid19").child(Ids).setValue(f);

                String myToken = FirebaseInstanceId.getInstance().getToken();
                String Nombre = "Pedro";
                Map<String, Object> fd = new HashMap<>();
                fd.put("Nombre", "myToken");
                myRef.child("Token").child(myToken).child(Nombre).setValue(fd);


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
                startActivity(new Intent(Sos.this,MainActivity.class));
                break;
            case R.id.uno:
                break;
            case R.id.dos:
                break;

        }

        return true;
    }


    public boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            // Toast.makeText(getApplicationContext(),"tb",Toast.LENGTH_LONG).show();
            startActivity(new  Intent(Sos.this,MainActivity.class));

        }
        return false;
    }

}
