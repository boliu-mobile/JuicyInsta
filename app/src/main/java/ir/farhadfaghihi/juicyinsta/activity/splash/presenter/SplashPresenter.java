package ir.farhadfaghihi.juicyinsta.activity.splash.presenter;

import ir.farhadfaghihi.juicyinsta.activity.splash.model.OnCheckCredentialsListener;
import ir.farhadfaghihi.juicyinsta.activity.splash.view.ISplashView;
import ir.farhadfaghihi.juicyinsta.activity.splash.model.SplashInteractor;

/**
 * Created by Farhad on 2/4/2016.
 */
public class SplashPresenter implements ISplashPresenter,OnCheckCredentialsListener
{
    private ISplashView splashViewListener ;
    private SplashInteractor splashInteractor ;

    public SplashPresenter(ISplashView splashViewListener)
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
