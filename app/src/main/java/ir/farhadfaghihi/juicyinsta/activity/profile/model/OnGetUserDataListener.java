package ir.farhadfaghihi.juicyinsta.activity.profile.model;

import ir.farhadfaghihi.juicyinsta.network.profile.model.UserData;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface OnGetUserDataListener
{
    void onSuccess(UserData user) ;

    void onError(String message) ;
}
