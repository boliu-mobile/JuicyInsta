package ir.farhadfaghihi.juicyinsta.activity.profile.view;

import java.util.ArrayList;

import ir.farhadfaghihi.juicyinsta.network.media.model.Media;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface IProfileView
{
    void showUsername(String username) ;

    void showProgressBarUser() ;

    void loadUserAvatar(String url) ;

    void showUserFullname(String fullName,String userName) ;

    void showUserDescription(String desc) ;

    void showPostCount(String postCount) ;

    void showFollowersCount(String followersCount) ;

    void showFollowingCount(String followingCount) ;

    void hideProgressBarUser() ;

    void showErrorMessage(String message) ;

    void showUserMediaGridMode(ArrayList<Media> listMedia);

    void showUserMediaListMode(ArrayList<Media> listMedia);

    void showConnectivityChangedMessage(String message) ;
}
