package ir.farhadfaghihi.juicyinsta.authentication.handler;

import android.net.Uri;

/**
 * Created by Farhad on 2/4/2016.
 */
public interface IAuthView
{
    void showLoginMessage() ;

    void hideMessage() ;

    void showLoginButton();

    void hideLoginButton() ;

    void showChooseBrowserMessage() ;

    void showChooseBrowserButtons() ;

    void hideChooseBrowserButtons() ;

    void showInAppBrowser() ;

    void showPhoneBrowser(Uri uri) ;

    void loadUrlInAppBrowser(String url) ;

    void hideInAppBrowser() ;

    void showSuccessfulAuthMessage() ;

    void showFailedAuthMessage() ;

    void showRetryButton() ;

    void hideRetryButton() ;

    void navigateToUserProfile() ;
}
