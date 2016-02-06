package ir.farhadfaghihi.juicyinsta.activity.profile.presenter;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface IProfilePresenter
{
    void loadUserData() ;

    void onSelectedFollowers() ;

    void onSelectedFollowings() ;

    void onSelectedGridMode() ;

    void onSelectedListMode() ;
}
