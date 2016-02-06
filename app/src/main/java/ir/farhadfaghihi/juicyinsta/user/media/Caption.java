package ir.farhadfaghihi.juicyinsta.user.media;

/**
 * Created by Farhad on 2/6/2016.
 */
public class Caption
{
    private String text ;

    public String getText()
    {
        if(text == null)
            return "" ;
        else
           return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
