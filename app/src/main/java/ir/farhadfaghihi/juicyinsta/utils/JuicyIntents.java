package ir.farhadfaghihi.juicyinsta.utils;

import android.content.Context;
import android.content.Intent;

import ir.farhadfaghihi.juicyinsta.activity.AuthActivity;

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
        /**
         * Todo : show user profile activity
         */
    }
}
