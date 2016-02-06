package ir.farhadfaghihi.juicyinsta.activity.authentication.presenter;

import android.net.Uri;

import ir.farhadfaghihi.juicyinsta.activity.authentication.model.AuthInteractor;
import ir.farhadfaghihi.juicyinsta.activity.authentication.model.IAuthInteractor;
import ir.farhadfaghihi.juicyinsta.activity.authentication.view.IAuthView;
import ir.farhadfaghihi.juicyinsta.activity.authentication.model.OnAuthListener;

/**
 * Created by Farhad on 2/5/2016.
 */
public class AuthPresenter implements IAuthPresenter,OnAuthListener
{
    private IAuthView authView ;
    private IAuthInteractor authInteractor ;

    public AuthPresenter(IAuthView authView)
    {
        this.authView = authView ;
        this.authInteractor = new AuthInteractor() ;
    }

    @Override
    public void onPause()
    {

    }

    @Override
    public void onSelectedRetry()
    {
        authView.hideAllViews();

        authView.showChooseBrowserButtons();
        authView.showChooseBrowserMessage();
    }

    @Override
    public void onSelectedLogin()
    {
        authView.hideAllViews();

        authView.showChooseBrowserMessage();
        authView.showChooseBrowserButtons();
    }

    @Override
    public void onSelectedInAppBrowser()
    {
        authView.hideAllViews();

        authView.showInAppBrowser();

        String url = authInteractor.getInstagramAuthUrl() ;

        authView.loadUrlInAppBrowser(url);
    }

    @Override
    public void onSelectedPhoneBrowser()
    {
        Uri uri = Uri.parse(authInteractor.getInstagramAuthUrl());

        authView.showPhoneBrowser(uri);
    }

    @Override
    public void onAuthStarted()
    {
        authView.hideAllViews();

        authView.showLoginMessage();
        authView.showLoginButton();
    }

    @Override
    public void onAuthFailed()
    {
        authView.hideAllViews();

        authView.showFailedAuthMessage();
    }

    @Override
    public void onAuthFinished(Uri uri)
    {
        authInteractor.checAuthCalllback(uri,this);
    }

    @Override
    public void onUserAllowAuth()
    {
        authView.hideAllViews();

        authView.showSuccessfulAuthMessage();

        authView.navigateToUserProfile();
    }

    @Override
    public void onUserDenyAuth()
    {
        authView.showFailedAuthMessage();
        authView.showRetryButton();
    }
}
