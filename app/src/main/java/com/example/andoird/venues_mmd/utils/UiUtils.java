package com.example.andoird.venues_mmd.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mina on 02/01/18.
 */

public class UiUtils {

    public static Toast displayToast(Context context,Toast currentToast, String text){
        if(currentToast != null){
            currentToast.cancel();
        }
        return Toast.makeText(context, text, Toast.LENGTH_LONG);
    }
}
