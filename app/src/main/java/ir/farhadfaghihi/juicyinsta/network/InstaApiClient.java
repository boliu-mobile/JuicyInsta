package ir.farhadfaghihi.juicyinsta.network;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ir.farhadfaghihi.juicyinsta.network.model.ConstsApi;
import ir.farhadfaghihi.juicyinsta.network.model.MediaApi;
import ir.farhadfaghihi.juicyinsta.network.model.UserApi;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.user.handler.OnGetUserMediaListener;
import ir.farhadfaghihi.juicyinsta.user.media.MediaResponse;
import ir.farhadfaghihi.juicyinsta.user.model.UserResponse;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Farhad on 2/5/2016.
 */
public class InstaApiClient implements Interceptor
{
    private static String accessToken ;
    private static Retrofit retrofit ;
    private static OkHttpClient httpClient ;

    private static InstaApiClient instance ;

    private InstaApiClient(String accessToken)
    {
        this.accessToken = accessToken ;

        httpClient = new OkHttpClient() ;
        httpClient.interceptors().add(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(ConstsApi.API_BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;



    }

    public static InstaApiClient getInstance(String accessToken)
    {
        if(instance == null)
            instance = new InstaApiClient(accessToken);
        return instance ;
    }


    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Log.e("URL CALLED : " ,chain.request().urlString()) ;

        Response response = chain.proceed(chain.request());
        return response;
    }

    public void getUserData(final OnGetUserDataListener listener)
    {
        UserApi userApi = retrofit.create(UserApi.class);

        Call<UserResponse> callUserData = userApi.getUserData(accessToken) ;
        callUserData.enqueue(new Callback<UserResponse>()
        {
            @Override
            public void onResponse(retrofit.Response<UserResponse> response)
            {
                int code = response.body().getMeta().getCode() ;

                if(code == 200)
                {
                    listener.onSuccess(response.body().getData());
                }

                else
                {
                    listener.onError(code + "");
                }

            }

            @Override
            public void onFailure(Throwable t)
            {
                listener.onError(t.getMessage());
            }
        });

    }

    public void getUserMedia(final OnGetUserMediaListener listener)
    {
        MediaApi mediaApi = retrofit.create(MediaApi.class);

        Call<MediaResponse> callMediaData = mediaApi.getUserMedia(accessToken);
        callMediaData.enqueue(new Callback<MediaResponse>()
        {
            @Override
            public void onResponse(retrofit.Response<MediaResponse> response)
            {
                int code = response.body().getMeta().getCode() ;

                if(code == 200)
                {
                    listener.onSuccess(response.body().getData());
                }

                else
                {
                    listener.onError(code + "");
                }
            }

            @Override
            public void onFailure(Throwable t)
            {
                listener.onError(t.getMessage());
            }
        });
    }

}
