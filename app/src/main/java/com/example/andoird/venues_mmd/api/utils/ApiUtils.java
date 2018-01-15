package com.example.andoird.venues_mmd.api.utils;

/**
 * Created by mina on 07/12/17.
 */

public class ApiUtils {

    public static final String CLIENT_ID_KEY = "client_id";
    public static final String CLIENT_SECRET_KEY = "client_secret";
    public static final String DATE_VERSION_KEY = "v";

    public static final String CLIENT_ID = "2HOZRRC3T2LXSZ133LEARQWHAOCSWAN1MXBUG0HW2QD2CJDJ";
    public static final String CLIENT_SECRET = "YYJWSVINY25SHAOVSSNGVGWOAVTRTAS0FMJWTTYY4YURINIJ";
    public static final String DATE_VERSION = "20171205";

    public static final String BASE_URL = "https://api.foursquare.com";
    public static final String FOURSQUARE_API_VERSION = "/v2";

    public static final String CALLBACK_URL = "mmdforesquare://callback";
    public static final String O_AUTH_URL = BASE_URL +"/oauth2/authenticate?" +
            CLIENT_ID_KEY + CLIENT_ID + "&response_type=code&redirect_uri=" + CALLBACK_URL;

    public static final String VENUE_ID = "venue_id";
    public static final String SEARCH_VENUE_URL = FOURSQUARE_API_VERSION + "/venues/search?";
    public static final String DETAILS_VENUE_URL = FOURSQUARE_API_VERSION + "/venues/{" + VENUE_ID + "}?";




}
