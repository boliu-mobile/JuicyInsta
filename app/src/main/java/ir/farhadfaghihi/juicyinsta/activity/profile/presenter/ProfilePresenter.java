package ir.farhadfaghihi.juicyinsta.activity.profile.presenter;

import java.util.ArrayList;

import ir.farhadfaghihi.juicyinsta.activity.profile.model.ProfileInteractor;
import ir.farhadfaghihi.juicyinsta.activity.profile.model.IProfileInteractor;
import ir.farhadfaghihi.juicyinsta.activity.profile.view.IProfileView;
import ir.farhadfaghihi.juicyinsta.activity.profile.model.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.activity.profile.model.OnGetUserMediaListener;
import ir.farhadfaghihi.juicyinsta.network.media.model.Media;
import ir.farhadfaghihi.juicyinsta.network.profile.model.UserData;

/**
 * Created by Farhad on 2/5/2016.
 */
public class ProfilePresenter implements IProfilePresenter,OnGetUserDataListener
{
    private IProfileView profileView ;
    private IProfileInteractor profileInteractor ;

    private ArrayList<Media> listMedia ;

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
        /**
         * Todo : Show DialogFragment for showing the Followers list
         */
    }

    @Override
    public void onSelectedFollowings()
    {
        /**
         * Todo : Show DialogFragment for showing the followings list
         */
    }

    @Override
    public void onSelectedGridMode()
    {
        if(listMedia != null && listMedia.size() != 0)
        {
            profileView.showUserMediaGridMode(listMedia);
        }

        else
        {
            profileInteractor.getUserMedia(new OnGetUserMediaListener()
            {
                @Override
                public void onSuccess(ArrayList<Media> listMedia)
                {
                    ProfilePresenter.this.listMedia = listMedia ;

                    profileView.showUserMediaGridMode(listMedia);

                }

                @Override
                public void onError(String message)
                {
                    profileView.showErrorMessage(message);
                }
            });
        }

    }

    @Override
    public void onSelectedListMode()
    {
        if(listMedia != null && listMedia.size() != 0)
        {
            profileView.showUserMediaListMode(listMedia);
        }

        else
        {
            profileInteractor.getUserMedia(new OnGetUserMediaListener()
            {
                @Override
                public void onSuccess(ArrayList<Media> listMedia)
                {
                    ProfilePresenter.this.listMedia = listMedia ;

                    profileView.showUserMediaListMode(listMedia);

                }

                @Override
                public void onError(String message)
                {
                    profileView.showErrorMessage(message);
                }
            });
        }
    }

    /**
     * UserData data from the Instagram server
     * @param user
     */
    @Override
    public void onSuccess(UserData user)
    {
        profileView.hideProgressBarUser();

        profileView.showUsername(user.getUsername());

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
