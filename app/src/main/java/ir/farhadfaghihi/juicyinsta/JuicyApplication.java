package ir.farhadfaghihi.juicyinsta;

import android.app.Application;

import ir.farhadfaghihi.juicyinsta.utils.setting.AppSetting;

/**
 * Created by Farhad on 2/5/2016.
 */
public class JuicyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        AppSetting.init(getApplicationContext());
    }
}
