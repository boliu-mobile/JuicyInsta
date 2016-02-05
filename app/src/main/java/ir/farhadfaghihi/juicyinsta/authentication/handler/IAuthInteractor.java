package ir.farhadfaghihi.juicyinsta.authentication.handler;

import android.net.Uri;

/**
 * Created by Farhad on 2/4/2016.
 */
public interface IAuthInteractor
{
    String getInstagramAuthUrl() ;

    void checAuthCalllback(Uri uriCallback,OnAuthListener onAuthListener);
}
