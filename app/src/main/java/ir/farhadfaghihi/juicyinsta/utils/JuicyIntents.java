package ir.farhadfaghihi.juicyinsta.utils;

import android.content.Context;
import android.content.Intent;

import ir.farhadfaghihi.juicyinsta.activity.AuthActivity;

/**
 * Created by Farhad on 2/3/2016.
 */
public class JuicyIntents
{
    public static void openAuthActivity(Context context)
    {
        Intent intentAuth = new Intent(context,AuthActivity.class);
        context.startActivity(intentAuth);
    }
}
