package ir.farhadfaghihi.juicyinsta.user.model;

/**
 * Created by Farhad on 2/5/2016.
 */
public class UserData
{
    private String username ;
    private String full_name ;
    private String profile_picture ;
    private String bio ;
    private String website ;

    private Counts counts ;

    private String id ;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFull_name()
    {
        return full_name;
    }

    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }

    public String getProfile_picture()
    {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture)
    {
        this.profile_picture = profile_picture;
    }

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Counts getCounts()
    {
        return counts;
    }

    public void setCounts(Counts counts)
    {
        this.counts = counts;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
