package ir.farhadfaghihi.juicyinsta.user.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfilePresenter;
import ir.farhadfaghihi.juicyinsta.user.handler.IProfileView;
import ir.farhadfaghihi.juicyinsta.utils.image.ImageUtils;

public class ProfileActivity extends AppCompatActivity implements IProfileView, View.OnClickListener
{
    @Bind(R.id.toolbar)    Toolbar toolbar;
    @Bind(R.id.profile_imageview_avatar)    ImageView imageviewAvatar;
    @Bind(R.id.profile_tvUserFullName)    AppCompatTextView tvUserFullName;
    @Bind(R.id.profile_tvUserBio)    AppCompatTextView tvUserBio;
    @Bind(R.id.profile_tvPostCount)    AppCompatTextView tvPostCount;
    @Bind(R.id.profile_tvFollowers)    AppCompatTextView tvFollowerCount;
    @Bind(R.id.profile_tvFollowing)    AppCompatTextView tvFollowingCount;
    @Bind(R.id.profile_progress_userdata)    ProgressBar progressUser;
    @Bind(R.id.profile_fab)    FloatingActionButton fab;

    @BindString(R.string.profile_post) String posts ;
    @BindString(R.string.profile_follower) String followers ;
    @BindString(R.string.profile_following) String following ;

    IProfilePresenter profilePresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        profilePresenter = new ProfilePresenter(this);

        profilePresenter.loadUserData();
    }

    @Override
    public void showProgressBarUser()
    {
        progressUser.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadUserAvatar(String url)
    {
        ImageUtils.load(this, url, imageviewAvatar);
    }

    @Override
    public void showUserFullname(String fullName, String userName)
    {
        tvUserFullName.setText(fullName);
    }

    @Override
    public void showUserDescription(String desc)
    {
        tvUserBio.setText(desc);
    }

    @Override
    public void showPostCount(String count)
    {
        tvPostCount.setText(posts + "\r\n" + count);
    }

    @Override
    public void showFollowersCount(String followersCount)
    {
        tvFollowerCount.setText(followers + "\r\n" + followersCount);
    }

    @Override
    public void showFollowingCount(String followingCount)
    {
        tvFollowingCount.setText(following + "\r\n" + followingCount);
    }

    @Override
    public void hideProgressBarUser()
    {
        progressUser.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message)
    {
        showSnackMessage(message);
    }

    @Override
    public void onClick(View v)
    {

    }

    private void showSnackMessage(String message)
    {
        Snackbar.make(fab,message,Snackbar.LENGTH_LONG).show();
    }
}
