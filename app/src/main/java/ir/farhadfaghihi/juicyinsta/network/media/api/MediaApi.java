package ir.farhadfaghihi.juicyinsta.network.media.api;

import ir.farhadfaghihi.juicyinsta.network.media.response.MediaResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface MediaApi
{
    @GET("/v1/users/self/media/recent/")
    Call<MediaResponse> getUserMedia(@Query("access_token") String accessToken);
}
