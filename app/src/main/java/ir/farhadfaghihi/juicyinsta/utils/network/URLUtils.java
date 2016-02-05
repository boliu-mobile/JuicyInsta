package ir.farhadfaghihi.juicyinsta.utils.network;

import android.net.Uri;

import ir.farhadfaghihi.juicyinsta.network.model.ConstsApi;

/**
 * Created by Farhad on 2/1/2016.
 */
public class URLUtils
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
}
