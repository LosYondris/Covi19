package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rv extends AppCompatActivity {
RecyclerView rv;
//RecyclerView.Adapter adapter;
ArrayList<Poo> pojo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = (RecyclerView) findViewById(R.id.rcCovi19);
        //rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(Rv.this));

       // pojo = new ArrayList<>();

        ConsurtaURL();

    }

    public void showVista(){
        MyAdapter myAdapter = new MyAdapter(pojo);
        rv.setAdapter(myAdapter);
    }


    public void ConsurtaURL(){
       // String url = "https://corona.lmao.ninja/countries";
        String url = "https://corona.lmao.ninja/countries";
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        pojo = new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                if (response !=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject datas = jsonArray.getJSONObject(i);

                            JSONObject datasInfo = datas.getJSONObject("countryInfo");

                            pojo.add(new Poo(
                                    datas.getString("country"),
                                    datasInfo.getString("flag"),
                                    datas.getString("cases"),
                                    datas.getString("todayCases"),
                                    datas.getString("deaths"),
                                    datas.getString("todayDeaths"),
                                    datas.getString("recovered")

                            ));

                            showVista();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getStackTrace();
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(request);

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
                startActivity(new Intent(Rv.this,MainActivity.class));
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
            startActivity(new  Intent(Rv.this,MainActivity.class));

        }
        return false;
    }


}
