package ir.farhadfaghihi.juicyinsta.receiver;

/**
 * Created by Farhad on 2/7/2016.
 */
public class NetworkChangeEvent
{
    private String message ;

    public NetworkChangeEvent(String message)
    {
        this.message = message ;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
