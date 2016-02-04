package ir.farhadfaghihi.juicyinsta.splash.mvp;

import ir.farhadfaghihi.juicyinsta.splash.handler.ISplashPresenter;
import ir.farhadfaghihi.juicyinsta.splash.handler.OnCheckCredentialsListener;
import ir.farhadfaghihi.juicyinsta.splash.handler.SplashView;

/**
 * Created by Farhad on 2/4/2016.
 */
public class SplashPresenter implements ISplashPresenter,OnCheckCredentialsListener
{
    private SplashView splashViewListener ;
    private SplashInteractor splashInteractor ;

    public SplashPresenter(SplashView splashViewListener)
    {
        this.splashViewListener = splashViewListener ;
        this.splashInteractor = new SplashInteractor() ;
    }

    //Methods from ISplashPresenter
    @Override
    public void authorizeUser()
    {
        splashInteractor.checkCredentials(this);
    }

    @Override
    public void onPause()
    {
        /**
         * We may save important data, using SplashInteractor
         */
    }

    @Override
    public void onDestroy()
    {

    }

    // Methods from OnCheckCredentialsListener
    @Override
    public void onUserAuthorized()
    {
        splashViewListener.navigateToUserProfile();
    }

    @Override
    public void onUserNotAuthorized()
    {
        splashViewListener.navigateToAuthentication();
    }
}
