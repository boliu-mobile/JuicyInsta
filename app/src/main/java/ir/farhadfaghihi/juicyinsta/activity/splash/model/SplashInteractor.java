package ir.farhadfaghihi.juicyinsta.activity.splash.model;

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
