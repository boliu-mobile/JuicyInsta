package ir.farhadfaghihi.juicyinsta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.AuthPresenter;
import ir.farhadfaghihi.juicyinsta.R;

public class AuthActivity extends AppCompatActivity
{
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.auth_btn_login) AppCompatButton btnLogin;

    AuthPresenter authPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        authPresenter = new AuthPresenter(this);

        btnLogin.setOnClickListener(authPresenter);
    }
}
