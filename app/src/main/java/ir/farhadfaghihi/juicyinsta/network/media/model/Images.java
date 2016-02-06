package ir.farhadfaghihi.juicyinsta.network.media.model;

/**
 * Created by Farhad on 2/6/2016.
 */
public class Images
{
    private ImageDetail low_resolution ;
    private ImageDetail thumbnail ;
    private ImageDetail standard_resolution ;


    public ImageDetail getLow_resolution()
    {
        return low_resolution;
    }

    public void setLow_resolution(ImageDetail low_resolution)
    {
        this.low_resolution = low_resolution;
    }

    public ImageDetail getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(ImageDetail thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public ImageDetail getStandard_resolution()
    {
        return standard_resolution;
    }

    public void setStandard_resolution(
            ImageDetail standard_resolution)
    {
        this.standard_resolution = standard_resolution;
    }
}
