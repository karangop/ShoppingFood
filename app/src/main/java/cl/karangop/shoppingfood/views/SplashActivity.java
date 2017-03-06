package cl.karangop.shoppingfood.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.data.QueriesDish;
import cl.karangop.shoppingfood.views.dish.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Llamar metodo para setear Splash
        start();

//        Creamos los platos al iniciar
        new QueriesDish().createData();


    }

    //Metodo setear splash
    public void start()
    {
        RelativeLayout relativeLayout= (RelativeLayout) findViewById(R.id.activity_splash);
        relativeLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        },3000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
