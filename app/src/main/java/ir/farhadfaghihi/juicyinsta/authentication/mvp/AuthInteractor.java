package ir.farhadfaghihi.juicyinsta.authentication.mvp;

import android.net.Uri;
import android.text.TextUtils;

import ir.farhadfaghihi.juicyinsta.authentication.handler.IAuthInteractor;
import ir.farhadfaghihi.juicyinsta.authentication.handler.OnAuthListener;
import ir.farhadfaghihi.juicyinsta.utils.UrlUtils;

/**
 * Created by Farhad on 2/5/2016.
 */
public class AuthInteractor implements IAuthInteractor
{

    @Override
    public String getInstagramAuthUrl()
    {
        return UrlUtils.getInstagramAuthUrl() ;
    }

    @Override
    public void checAuthCalllback(Uri uriCallback, OnAuthListener onAuthListener)
    {
        String token = UrlUtils.extractAccessToken(uriCallback);

        if(!TextUtils.isEmpty(token))
            onAuthListener.onUserAllowAuth();

        else
            onAuthListener.onUserDenyAuth();
    }
}
