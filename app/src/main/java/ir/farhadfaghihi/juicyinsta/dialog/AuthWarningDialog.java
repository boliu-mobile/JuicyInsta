package ir.farhadfaghihi.juicyinsta.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;

/**
 * Created by Farhad on 2/3/2016.
 */
public class AuthWarningDialog extends Dialog
{
    @Bind(R.id.dlg_auth_tvTitle)
    TextView dlgAuthTvTitle;
    @Bind(R.id.dlg_auth_tvMessage)
    TextView dlgAuthTvMessage;
    @Bind(R.id.dlg_auth_btnPositive)
    AppCompatButton dlgAuthBtnPositive;
    @Bind(R.id.dlg_auth_btnNegative)
    AppCompatButton dlgAuthBtnNegative;

    @BindString(R.string.dlg_auth_warning_title) String title ;
    @BindString(R.string.dlg_auth_warning_message) String message ;
    @BindString(R.string.dlg_auth_warning_btn_ok) String btnOk ;
    @BindString(R.string.dlg_auth_warning_btn_cancel) String btnCancel ;


    private Activity context;
    private View.OnClickListener clickListenerPositive;
    private View.OnClickListener clickListenerNegative;

    public AuthWarningDialog(Activity context)
    {
        super(context);

        this.context = context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public AuthWarningDialog(
            Activity context, View.OnClickListener clickListenerPositive,
            View.OnClickListener clickListenerNegative)
    {
        super(context);

        this.context = context ;

        this.clickListenerPositive = clickListenerPositive;
        this.clickListenerNegative = clickListenerNegative;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_auth_warning);

        ButterKnife.bind(this);

        dlgAuthTvTitle.setText(title);
        dlgAuthTvMessage.setText(message);
        dlgAuthBtnPositive.setText(btnOk);
        dlgAuthBtnNegative.setText(btnCancel);

        dlgAuthBtnPositive.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();

                clickListenerPositive.onClick(v);
            }
        });
        dlgAuthBtnNegative.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();

                clickListenerNegative.onClick(v);
            }
        });
    }
}
