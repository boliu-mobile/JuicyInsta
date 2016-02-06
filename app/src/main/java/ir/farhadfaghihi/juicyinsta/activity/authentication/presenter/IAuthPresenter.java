package ir.farhadfaghihi.juicyinsta.activity.authentication.presenter;

import android.net.Uri;

/**
 * Created by Farhad on 2/4/2016.
 */
public interface IAuthPresenter
{
    void onSelectedLogin() ;

    void onSelectedInAppBrowser() ;

    void onSelectedPhoneBrowser();

    void onSelectedRetry() ;

    void onAuthStarted() ;

    void onAuthFailed() ;

    void onAuthFinished(Uri uri) ;

    void onPause() ;

}
