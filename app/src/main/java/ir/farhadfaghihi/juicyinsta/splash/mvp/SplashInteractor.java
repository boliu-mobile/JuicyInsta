package ir.farhadfaghihi.juicyinsta.splash.mvp;

import android.text.TextUtils;

import ir.farhadfaghihi.juicyinsta.splash.handler.ISplashInteractor;
import ir.farhadfaghihi.juicyinsta.splash.handler.OnCheckCredentialsListener;

/**
 * Created by Farhad on 2/4/2016.
 */
public class SplashInteractor implements ISplashInteractor
{
    @Override
    public void checkCredentials( OnCheckCredentialsListener listener)
    {
        /**
         * Todo : read accessToken from database
         */
        String accessToken = "" ;

        if(TextUtils.isEmpty(accessToken))
            listener.onUserNotAuthorized();

        else
            listener.onUserAuthorized();
    }
}
