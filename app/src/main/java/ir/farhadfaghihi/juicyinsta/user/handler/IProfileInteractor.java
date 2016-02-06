package ir.farhadfaghihi.juicyinsta.user.handler;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface IProfileInteractor
{
    void getUserData(OnGetUserDataListener listener) ;

    void getUserMedia(OnGetUserMediaListener listener);
}
