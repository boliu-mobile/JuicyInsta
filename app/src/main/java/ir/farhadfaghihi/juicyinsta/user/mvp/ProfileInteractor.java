package ir.farhadfaghihi.juicyinsta.user.mvp;

import ir.farhadfaghihi.juicyinsta.network.InstaApiClient;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfileInteractor;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserMediaListener;
import ir.farhadfaghihi.juicyinsta.utils.setting.AppSetting;
import ir.farhadfaghihi.juicyinsta.utils.setting.ConstSetting;

/**
 * Created by Farhad on 2/5/2016.
 */
public class ProfileInteractor implements IProfileInteractor
{
    @Override
    public void getUserData(OnGetUserDataListener listener)
    {
        String accessToken = AppSetting.getInstance().getString(ConstSetting.ACCESS_TOEKN);

        InstaApiClient.getInstance(accessToken).getUserData(listener);
    }

    @Override
    public void getUserMedia(OnGetUserMediaListener listener)
    {
        String accessToken = AppSetting.getInstance().getString(ConstSetting.ACCESS_TOEKN);

        InstaApiClient.getInstance(accessToken).getUserMedia(listener);

    }
}
