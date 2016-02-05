package ir.farhadfaghihi.juicyinsta.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

/**
 * Created by Farhad on 2/5/2016.
 */
public class ImageUtils
{
    public static void load(Context context, String url, ImageView imageView, final ProgressBar progressBar)
    {
        progressBar.setVisibility(View.VISIBLE);

        try
        {
            Picasso.with(context).load(Uri.parse(url)).into(imageView, new com.squareup.picasso.Callback()
            {
                @Override
                public void onSuccess()
                {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError()
                {
                    progressBar.setVisibility(View.GONE);
                }
            });

        }
        catch (Exception e)
        {
            e.printStackTrace();
            progressBar.setVisibility(View.GONE);
        }
    }

    public static void load(final Context ctx, final String url, final ImageView img)
    {
        if (url != null && !url.equals(""))
        {
            try
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final Bitmap bmp = Picasso.with(ctx).load(Uri.parse(url)).get();
                            Handler h = new Handler(Looper.getMainLooper());
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    img.setImageBitmap(getFullyCircledImage(bmp));
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Bitmap getFullyCircledImage(Bitmap bitmap)
    {
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        final Bitmap outputBitmap = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);

        final Path path = new Path();
        path.addCircle((float) (width / 2), (float) (height / 2),
                       (float) Math.min(width, (height / 2)), Path.Direction.CW);

        final Canvas canvas = new Canvas(outputBitmap);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 0, 0, null);

        return outputBitmap;
    }
}
