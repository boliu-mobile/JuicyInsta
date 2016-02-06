package ir.farhadfaghihi.juicyinsta.network.profile.api;

import ir.farhadfaghihi.juicyinsta.network.profile.response.UserResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface ProfileApi
{
    @GET("/v1/users/self/")
    Call<UserResponse> getUserData(@Query("access_token")String accessToken);
}
