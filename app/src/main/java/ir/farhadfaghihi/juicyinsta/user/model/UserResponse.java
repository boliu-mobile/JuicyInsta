package ir.farhadfaghihi.juicyinsta.user.model;

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
