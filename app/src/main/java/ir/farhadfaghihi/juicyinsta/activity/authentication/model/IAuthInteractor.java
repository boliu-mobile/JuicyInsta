package ir.farhadfaghihi.juicyinsta.activity.authentication.model;

import android.net.Uri;

/**
 * Created by Farhad on 2/4/2016.
 */
public interface IAuthInteractor
{
    String getInstagramAuthUrl() ;

    void checkAuthCallback(Uri uriCallback, OnAuthListener onAuthListener);
}
