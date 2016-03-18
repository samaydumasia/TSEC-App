package com.kalpnil.ksinfotech.tsec.tsec;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by KALPNIL ANJAN on 05-Jul-15.
 */
public class CheckNetwork {
    private static final String TAG = CheckNetwork.class.getSimpleName();
    public static boolean isInternetAvailable(Context context)
    {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null)
        {
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }
}
