package ir.farhadfaghihi.juicyinsta.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Farhad on 2/1/2016.
 */
public class InstaAuthWebViewClient extends WebViewClient
{
    Context context ;

    public InstaAuthWebViewClient(Context context)
    {
        super();
        this.context = context ;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        if (url.startsWith("juicyinsta"))
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            context.startActivity(intent);

            return true;
        }
        else
        {
            view.loadUrl(url);
            return true;
        }
    }

}
