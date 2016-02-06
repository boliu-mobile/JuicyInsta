package ir.farhadfaghihi.juicyinsta.network.client;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ir.farhadfaghihi.juicyinsta.activity.profile.model.OnGetUserDataListener;
import ir.farhadfaghihi.juicyinsta.activity.profile.model.OnGetUserMediaListener;
import ir.farhadfaghihi.juicyinsta.network.base.ConstsApi;
import ir.farhadfaghihi.juicyinsta.network.media.api.MediaApi;
import ir.farhadfaghihi.juicyinsta.network.media.response.MediaResponse;
import ir.farhadfaghihi.juicyinsta.network.profile.api.ProfileApi;
import ir.farhadfaghihi.juicyinsta.network.profile.response.UserResponse;
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
        Response response = chain.proceed(chain.request());
        return response;
    }

    public void getUserData(final OnGetUserDataListener listener)
    {
        ProfileApi profileApi = retrofit.create(ProfileApi.class);

        Call<UserResponse> callUserData = profileApi.getUserData(accessToken) ;
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
