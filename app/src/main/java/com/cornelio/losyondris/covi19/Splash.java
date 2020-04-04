package com.cornelio.losyondris.covi19;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    Animation equinaanimacion, bottonanimacion,topanimacion;
    CircleImageView img;
    TextView tituloLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topanimacion = AnimationUtils.loadAnimation(this, R.anim.top_animacion);
        bottonanimacion = AnimationUtils.loadAnimation(this, R.anim.botton_animacion);

        img = (CircleImageView) findViewById(R.id.id_login_img);
        tituloLogin = (TextView) findViewById(R.id.id_login_titulo);

        img.setAnimation(topanimacion);
        tituloLogin.setAnimation(bottonanimacion);
       // losyondris.setAnimation(bottonanimacion);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(Splash.this, MainActivity.class));
                finish();
            }
        },5000);


    }
}
