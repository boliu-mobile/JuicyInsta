package ir.farhadfaghihi.juicyinsta;

import android.content.DialogInterface;
import android.view.View;
import ir.farhadfaghihi.juicyinsta.activity.AuthActivity;
import ir.farhadfaghihi.juicyinsta.dialog.AuthWarningDialog;

/**
 * Created by Farhad on 2/3/2016.
 */
public class AuthPresenter implements View.OnClickListener,DialogInterface.OnClickListener
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
                AuthWarningDialog.getInstance(activity).show(this,this);
                break;
            }

        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
    }
}
