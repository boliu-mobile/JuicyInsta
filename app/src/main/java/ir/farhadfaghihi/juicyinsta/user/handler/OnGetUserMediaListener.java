package ir.farhadfaghihi.juicyinsta.user.handler;

import java.util.ArrayList;

import ir.farhadfaghihi.juicyinsta.user.media.Media;

/**
 * Created by Farhad on 2/6/2016.
 */
public interface OnGetUserMediaListener
{
    void onSuccess(ArrayList<Media> listMedia);

    void onError(String message);
}
