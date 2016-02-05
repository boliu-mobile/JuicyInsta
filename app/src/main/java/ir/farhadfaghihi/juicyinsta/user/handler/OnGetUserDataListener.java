package ir.farhadfaghihi.juicyinsta.user.handler;

import ir.farhadfaghihi.juicyinsta.user.model.UserData;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface OnGetUserDataListener
{
    void onSuccess(UserData user) ;

    void onError(String message) ;
}
