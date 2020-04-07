package com.cornelio.losyondris.covi19;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cornelio.losyondris.covi19.api.ApiClient;
import com.cornelio.losyondris.covi19.api.ApiInterface;
import com.cornelio.losyondris.covi19.models.Article;
import com.cornelio.losyondris.covi19.models.New;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News extends AppCompatActivity implements  SwipeRefreshLayout.OnRefreshListener {



    public static  final String API_KEY = "d4e50909c11041fd8f5164a03f3e6154";
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = News.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.rvNews);
        layoutManager = new LinearLayoutManager(News.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

//        recyclerView = findViewById(R.id.rvNews);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setHasFixedSize(true);
//        adapter = new Adapter(articles,getApplicationContext());
//        recyclerView.setAdapter(adapter);



        LoadJson();


    }

    public  void  LoadJson(){
        ApiInterface apiInterface = ApiClient.getApiCliente().create(ApiInterface.class);
        String country = Utils.getCountry();
        Call<New> call;
        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<New>() {
            @Override
            public void onResponse(Call<New> call, Response<New> response) {
                if(response.isSuccessful() && response.body().getArticle() != null){
                        if(!articles.isEmpty()){
                            articles.clear();

                        }

                    articles = response.body().getArticle();
                    adapter = new Adapter(articles, News.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                }else {
                    Toast.makeText(News.this,"Error Digo yo" , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<New> call, Throwable t) {

            }
        });

    }


    @Override
    public void onRefresh() {
        LoadJson();
    }
}

