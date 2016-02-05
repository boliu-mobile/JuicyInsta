package ir.farhadfaghihi.juicyinsta.network.model;

import ir.farhadfaghihi.juicyinsta.user.model.UserResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Farhad on 2/5/2016.
 */
public interface UserApi
{
    @GET("/v1/users/self/")
    Call<UserResponse> getUserData(@Query("access_token")String accessToken);
}
