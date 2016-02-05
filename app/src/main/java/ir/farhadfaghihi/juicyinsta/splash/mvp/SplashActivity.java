package ir.farhadfaghihi.juicyinsta.splash.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.splash.handler.ISplashView;
import ir.farhadfaghihi.juicyinsta.utils.intents.JuicyIntents;

public class SplashActivity extends AppCompatActivity implements ISplashView
{
    @Bind(R.id.splash_imageview)  ImageView ivLogo;
    @Bind(R.id.splash_tvAppName)  TextView tvAppName;

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        splashPresenter = new SplashPresenter(this);

        splashPresenter.authorizeUser();

    }

    @Override
    public void startLoadAnimation()
    {

    }

    @Override
    public void stopLoadAnimation()
    {

    }

    @Override
    public void navigateToAuthentication()
    {
        JuicyIntents.startAuthFlow(this);
    }

    @Override
    public void navigateToUserProfile()
    {
        JuicyIntents.showUserProfile(this) ;
    }


    @Override
    public void onDestroy()
    {
        splashPresenter.onDestroy();

        ButterKnife.unbind(this);

        super.onDestroy();
    }

    @Override
    public void onPause()
    {
        splashPresenter.onPause();
        super.onPause();
    }
}
