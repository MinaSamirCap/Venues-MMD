package com.example.andoird.venues_mmd.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andoird.venues_mmd.R;
import com.squareup.picasso.Picasso;

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


    public static void loadImage(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url)
                .placeholder(R.drawable.colors)
                .error(R.drawable.colors)
                .into(imageView);
    }
}
