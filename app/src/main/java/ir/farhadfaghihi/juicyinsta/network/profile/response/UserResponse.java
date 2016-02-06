package ir.farhadfaghihi.juicyinsta.network.profile.response;

import ir.farhadfaghihi.juicyinsta.network.profile.model.Meta;
import ir.farhadfaghihi.juicyinsta.network.profile.model.UserData;

/**
 * Created by Farhad on 2/5/2016.
 */
public class UserResponse
{
    private Meta meta ;
    private UserData data ;

    public Meta getMeta()
    {
        return meta;
    }

    public void setMeta(Meta meta)
    {
        this.meta = meta;
    }

    public UserData getData()
    {
        return data;
    }

    public void setData(UserData data)
    {
        this.data = data;
    }
}
