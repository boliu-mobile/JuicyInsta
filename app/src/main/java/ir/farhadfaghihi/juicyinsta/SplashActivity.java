package ir.farhadfaghihi.juicyinsta;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import ir.farhadfaghihi.juicyinsta.utils.JuicyIntents;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                JuicyIntents.openAuthActivity(SplashActivity.this);
            }
        },2000) ;
    }
}
