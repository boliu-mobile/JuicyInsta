package ir.farhadfaghihi.juicyinsta.activity.profile.model;

import java.util.ArrayList;

import ir.farhadfaghihi.juicyinsta.network.media.model.Media;

/**
 * Created by Farhad on 2/6/2016.
 */
public interface OnGetUserMediaListener
{
    void onSuccess(ArrayList<Media> listMedia);

    void onError(String message);
}
