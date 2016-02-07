package ir.farhadfaghihi.juicyinsta.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import ir.farhadfaghihi.juicyinsta.network.base.ConstsApi;

/**
 * Created by Farhad on 2/1/2016.
 */
public class NetworkUtils
{
    /**
     * Extract the acccesstoken from the redirect_url after
     * the Instagram implicit flow has successfully finished
     * @param uri
     * @return
     */
    public static String extractAccessToken(Uri uri)
    {
        try
        {
            String fragment = uri.getFragment();

            String token = fragment.replace("access_token=", "");

            return token ;
        }

        catch (Exception exc)
        {
            exc.printStackTrace();

            return "" ;
        }

    }

    public static String getInstagramAuthUrl()
    {
        String instagramAuthUrl = ConstsApi.AUTH_URL +
                "client_id=" + ConstsApi.CLIENT_ID
                + "&" +
                "redirect_uri=" + ConstsApi.CALLBACK_URL
                + "&" +
                "response_type=token" ;

        return instagramAuthUrl ;
    }

    public static boolean isConnected(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting() ;
    }
}
