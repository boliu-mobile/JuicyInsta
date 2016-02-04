package ir.farhadfaghihi.juicyinsta;

import android.view.View;

import ir.farhadfaghihi.juicyinsta.activity.AuthActivity;
import ir.farhadfaghihi.juicyinsta.dialog.AuthWarningDialog;

/**
 * Created by Farhad on 2/3/2016.
 */
public class AuthPresenter implements View.OnClickListener
{
    private AuthActivity activity ;

    public AuthPresenter(AuthActivity activity)
    {
        this.activity = activity ;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.auth_btn_login :
            {
                new AuthWarningDialog(activity,this,this).show();

                break;
            }

            case R.id.dlg_auth_btnPositive :
            {
                
                break;
            }

            case R.id.dlg_auth_btnNegative :
            {

                break;
            }

        }
    }

}
