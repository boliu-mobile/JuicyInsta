package ir.farhadfaghihi.juicyinsta.splash.mvp;

import ir.farhadfaghihi.juicyinsta.splash.handler.ISplashInteractor;
import ir.farhadfaghihi.juicyinsta.splash.handler.OnCheckCredentialsListener;
import ir.farhadfaghihi.juicyinsta.utils.setting.AppSetting;
import ir.farhadfaghihi.juicyinsta.utils.setting.ConstSetting;

/**
 * Created by Farhad on 2/4/2016.
 */
public class SplashInteractor implements ISplashInteractor
{
    @Override
    public void checkCredentials( OnCheckCredentialsListener listener)
    {
        boolean isAuthorized = AppSetting.getInstance().getBoolean(ConstSetting.AUTH_STATUS,false) ;

        if(!isAuthorized)
            listener.onUserNotAuthorized();

        else
            listener.onUserAuthorized();
    }
}
