package com.example.andoird.venues_mmd.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by mina on 21/01/18.
 */

public class IntentUtils {

    public static void openBrowser(Context context, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }

    public static void openDialScreen(Context context, String phone) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + phone));
        context.startActivity(i);
    }

    public static void openMapWithLatLng(Context context, double lat, double lng) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:" + lat + "," + lng));
        context.startActivity(i);
    }
}
