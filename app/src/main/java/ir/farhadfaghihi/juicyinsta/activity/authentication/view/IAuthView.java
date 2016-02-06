package ir.farhadfaghihi.juicyinsta.activity.authentication.view;

import android.net.Uri;

/**
 * Created by Farhad on 2/4/2016.
 */
public interface IAuthView
{
    void showLoginMessage() ;

    void showLoginButton();

    void showChooseBrowserMessage() ;

    void showChooseBrowserButtons() ;

    void showInAppBrowser() ;

    void showPhoneBrowser(Uri uri) ;

    void loadUrlInAppBrowser(String url) ;

    void showSuccessfulAuthMessage() ;

    void showFailedAuthMessage() ;

    void showRetryButton() ;

    void hideAllViews() ;

    void navigateToUserProfile() ;
}
