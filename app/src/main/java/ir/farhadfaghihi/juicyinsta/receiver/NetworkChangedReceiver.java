package ir.farhadfaghihi.juicyinsta.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import ir.farhadfaghihi.juicyinsta.utils.network.NetworkUtils;

/**
 * Created by Farhad on 2/7/2016.
 */
public class NetworkChangedReceiver extends BroadcastReceiver
{
    private EventBus eventBus = EventBus.getDefault() ;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        NetworkChangeEvent networkChangeEvent ;

        if(NetworkUtils.isConnected(context))
        {
            networkChangeEvent = new NetworkChangeEvent("network connection detected");
        }

        else
        {
            networkChangeEvent = new NetworkChangeEvent("no network connection");
        }

        eventBus.post(networkChangeEvent);
    }
}
