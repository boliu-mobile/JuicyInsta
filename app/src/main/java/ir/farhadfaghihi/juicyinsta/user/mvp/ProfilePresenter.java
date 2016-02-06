package ir.farhadfaghihi.juicyinsta.user.mvp;

import java.util.ArrayList;

import ir.farhadfaghihi.juicyinsta.user.handler.IProfileInteractor;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfilePresenter;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfileView;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserMediaListener;
import ir.farhadfaghihi.juicyinsta.user.media.Media;
import ir.farhadfaghihi.juicyinsta.user.model.UserData;

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
