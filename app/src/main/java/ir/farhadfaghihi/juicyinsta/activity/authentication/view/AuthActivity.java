package ir.farhadfaghihi.juicyinsta.activity.authentication.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.activity.authentication.presenter.AuthPresenter;
import ir.farhadfaghihi.juicyinsta.activity.authentication.presenter.IAuthPresenter;
import ir.farhadfaghihi.juicyinsta.utils.intents.JuicyIntents;
import ir.farhadfaghihi.juicyinsta.utils.widget.InstaAuthWebViewClient;

public class AuthActivity extends AppCompatActivity implements IAuthView, View.OnClickListener
{
    @Bind(R.id.auth_tvMessage)   AppCompatTextView tvMessage;
    @Bind(R.id.auth_btn_login)   AppCompatButton btnLogin;
    @Bind(R.id.auth_webview)     WebView webView;
    @Bind(R.id.auth_choosebrowser_btnInApp)   AppCompatButton btnInAppBrowser;
    @Bind(R.id.auth_choosebrowser_btnPhoneDefault)   AppCompatButton btnPhoneBrowser;
    @Bind(R.id.auth_linear_choosebrowser)   LinearLayout linearChooseBrowser;
    @Bind(R.id.auth_btnRetry)    AppCompatButton btnRetry;

    @BindString(R.string.auth_app_desc) String appDesc ;
    @BindString(R.string.auth_login_with_instagram) String loginButton ;

    @BindString(R.string.auth_message_choosebrowser) String chooseBrowser ;
    @BindString(R.string.auth_btn_juicybrowser) String juicyBroswer ;
    @BindString(R.string.auth_btn_phonebrowser) String phoneBrowser ;

    @BindString(R.string.auth_message_success) String authSuccesful ;
    @BindString(R.string.auth_message_error) String authError ;
    @BindString(R.string.auth_retry) String retry ;

    @BindDrawable(R.drawable.auth_failed)  Drawable imageAuthFailed ;
    @BindDrawable(R.drawable.auth_successful) Drawable imageAuthSuccessful ;
    @BindDrawable(R.drawable.instagram_small) Drawable imageInstagram ;
    @BindDrawable(R.drawable.auth_choosebrowser) Drawable imageChooseBrowser ;


    IAuthPresenter authPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        authPresenter = new AuthPresenter(this);
    }


    @Override
    public void onResume()
    {
        Uri data = getIntent().getData() ;

        if(data != null)
        {
            authPresenter.onAuthFinished(data);
        }

        else
        {
            authPresenter.onAuthStarted();
        }

        super.onResume();
    }

    @Override
    public void onNewIntent(Intent newIntent)
    {
        setIntent(newIntent);

        super.onNewIntent(newIntent);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.auth_btn_login :
            {
                authPresenter.onSelectedLogin();
                break;
            }

            case R.id.auth_choosebrowser_btnInApp :
            {
                authPresenter.onSelectedInAppBrowser();
                break;
            }

            case R.id.auth_choosebrowser_btnPhoneDefault :
            {
                authPresenter.onSelectedPhoneBrowser();
                break;
            }

            case R.id.auth_btnRetry :
            {
                authPresenter.onSelectedRetry();
                break;
            }
        }
    }

    @Override
    public void showLoginMessage()
    {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(appDesc);
        tvMessage.setCompoundDrawablesWithIntrinsicBounds(null, imageInstagram, null, null);
    }

    @Override
    public void showLoginButton()
    {
        btnLogin.setVisibility(View.VISIBLE);
        btnLogin.setText(loginButton);
    }

    @Override
    public void showChooseBrowserMessage()
    {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(chooseBrowser);
        tvMessage.setCompoundDrawablesWithIntrinsicBounds(null, imageChooseBrowser, null, null);
    }

    @Override
    public void showChooseBrowserButtons()
    {
        linearChooseBrowser.setVisibility(View.VISIBLE);

        btnInAppBrowser.setVisibility(View.VISIBLE);
        btnPhoneBrowser.setVisibility(View.VISIBLE);

        btnInAppBrowser.setText(juicyBroswer);
        btnPhoneBrowser.setText(phoneBrowser);
    }

    @Override
    public void showInAppBrowser()
    {
        webView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPhoneBrowser(Uri uri)
    {
        JuicyIntents.showPhoneBrowser(this, uri) ;
    }

    @Override
    public void loadUrlInAppBrowser(String url)
    {
        InstaAuthWebViewClient instaAuthWebViewClient = new InstaAuthWebViewClient(this);

        webView.setWebViewClient(instaAuthWebViewClient);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);
    }


    @Override
    public void showSuccessfulAuthMessage()
    {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(authSuccesful);
        tvMessage.setCompoundDrawablesWithIntrinsicBounds(null, imageAuthSuccessful, null, null);
    }

    @Override
    public void showFailedAuthMessage()
    {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(authError);
        tvMessage.setCompoundDrawablesWithIntrinsicBounds(null, imageAuthFailed, null, null);
    }

    @Override
    public void showRetryButton()
    {
        btnRetry.setVisibility(View.VISIBLE);
        btnRetry.setText(retry);
    }

    @Override
    public void hideAllViews()
    {
        tvMessage.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        linearChooseBrowser.setVisibility(View.GONE);
        webView.setVisibility(View.GONE);
    }

    @Override
    public void showConnectivityChangedMessage(String message)
    {
        Snackbar.make(webView,message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void navigateToUserProfile()
    {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                JuicyIntents.showUserProfile(AuthActivity.this);
            }
        },1500) ;
    }
}
