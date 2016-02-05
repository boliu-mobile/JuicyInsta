package ir.farhadfaghihi.juicyinsta.user.handler;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface IProfileView
{
    void showProgressBarUser() ;

    void loadUserAvatar(String url) ;

    void showUserFullname(String fullName,String userName) ;

    void showUserDescription(String desc) ;

    void showPostCount(String postCount) ;

    void showFollowersCount(String followersCount) ;

    void showFollowingCount(String followingCount) ;

    void hideProgressBarUser() ;

    void showErrorMessage(String message) ;
}
