package ir.farhadfaghihi.juicyinsta.user.media;

/**
 * Created by Farhad on 2/6/2016.
 */
public class Media
{
    private String created_time ;

    private Comments comments ;
    private Likes likes ;
    private Images images ;
    private Caption caption ;

    public String getCreated_time()
    {
        return created_time;
    }

    public void setCreated_time(String created_time)
    {
        this.created_time = created_time;
    }

    public Comments getComments()
    {
        return comments;
    }

    public void setComments(Comments comments)
    {
        this.comments = comments;
    }

    public Likes getLikes()
    {
        return likes;
    }

    public void setLikes(Likes likes)
    {
        this.likes = likes;
    }

    public Images getImages()
    {
        return images;
    }

    public void setImages(Images images)
    {
        this.images = images;
    }

    public Caption getCaption()
    {
        return caption;
    }

    public void setCaption(Caption caption)
    {
        this.caption = caption;
    }
}
