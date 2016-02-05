package ir.farhadfaghihi.juicyinsta.user.mvp;

import ir.farhadfaghihi.juicyinsta.user.handler.IProfileInteractor;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfilePresenter;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfileView;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.user.model.UserData;

/**
 * Created by Farhad on 2/5/2016.
 */
public class ProfilePresenter implements IProfilePresenter,OnGetUserDataListener
{
    private IProfileView profileView ;
    private IProfileInteractor profileInteractor ;

    public ProfilePresenter(IProfileView profileView)
    {
        this.profileView = profileView ;
        profileInteractor = new ProfileInteractor();
    }


    @Override
    public void loadUserData()
    {
        profileInteractor.getUserData(this);
    }

    @Override
    public void onSelectedFollowers()
    {

    }

    @Override
    public void onSelectedFollowings()
    {

    }

    @Override
    public void onSelectedGridMode()
    {

    }

    @Override
    public void onSelectedListMode()
    {

    }

    /**
     * UserData data from the Instagram server
     * @param user
     */
    @Override
    public void onSuccess(UserData user)
    {
        profileView.hideProgressBarUser();

        profileView.loadUserAvatar(user.getProfile_picture());

        profileView.showUserFullname(user.getFull_name(), user.getUsername());
        profileView.showUserDescription(user.getBio());

        profileView.showPostCount(String.valueOf(user.getCounts().getMedia()));
        profileView.showFollowersCount(String.valueOf(user.getCounts().getFollowed_by()));
        profileView.showFollowingCount(String.valueOf(user.getCounts().getFollows()));

    }

    @Override
    public void onError(String message)
    {
        profileView.showErrorMessage(message);
    }
}
