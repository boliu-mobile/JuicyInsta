package ir.farhadfaghihi.juicyinsta.utils.intents;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import ir.farhadfaghihi.juicyinsta.activity.authentication.view.AuthActivity;
import ir.farhadfaghihi.juicyinsta.activity.profile.view.ProfileActivity;

/**
 * Created by Farhad on 2/3/2016.
 */
public class JuicyIntents
{
    public static void startAuthFlow(Context context)
    {
        Intent intentAuth = new Intent(context,AuthActivity.class);
        context.startActivity(intentAuth);
    }

    public static void showUserProfile(Context context)
    {
        Intent intentUserProfile = new Intent(context, ProfileActivity.class);
        context.startActivity(intentUserProfile);
    }

    public static void showPhoneBrowser(Context context,Uri uri)
    {
        Intent intentBrowser = new Intent("android.intent.action.VIEW");
        intentBrowser.setData(uri);

        ComponentName resolveInfo = intentBrowser.resolveActivity(context.getPackageManager());

        if(resolveInfo != null)
        {
            context.startActivity(Intent.createChooser(intentBrowser,"Choose your browser")) ;
        }

        else
        {
            Toast.makeText(context,"No web browser found on your device !",Toast.LENGTH_LONG).show();
        }
    }
}
