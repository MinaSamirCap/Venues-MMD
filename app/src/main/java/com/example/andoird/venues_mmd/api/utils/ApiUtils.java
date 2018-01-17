package com.example.andoird.venues_mmd.api.utils;

/**
 * Created by mina on 07/12/17.
 */

public class ApiUtils {

    public static final String CLIENT_ID_KEY = "client_id";
    public static final String CLIENT_SECRET_KEY = "client_secret";
    public static final String DATE_VERSION_KEY = "v";
    public static final String VENUE_ID_KEY = "venue_id";
    public static final String QUERY_KEY = "query";
    public static final String NEAR_KEY = "near";
    public static final String LL_KEY = "ll";
    public static final String LIMIT_KEY = "limit";
    public static final String INTENT_KEY = "intent";
    public static final String INTENT_GLOBAL_KEY = "global";

    public static final String CLIENT_ID = "2HOZRRC3T2LXSZ133LEARQWHAOCSWAN1MXBUG0HW2QD2CJDJ";
    public static final String CLIENT_SECRET = "YYJWSVINY25SHAOVSSNGVGWOAVTRTAS0FMJWTTYY4YURINIJ";
    public static final String DATE_VERSION = "20171205";

    public static final String BASE_API_URL = "https://api.foursquare.com";
    public static final String BASE_FOURSQUARE_URL = "https://foursquare.com";

    public static final String CALLBACK_URL = "mmdforesquare://callback";
    public static final String AUTHENTICATION_URL = "/oauth2/authenticate?";
    public static final String O_AUTH_URL = BASE_FOURSQUARE_URL + AUTHENTICATION_URL +
            CLIENT_ID_KEY + "=" + CLIENT_ID + "&response_type=code&redirect_uri=" + CALLBACK_URL;

    public static final String FOURSQUARE_API_VERSION = "/v2";
    public static final String FOURSQUARE_API_VENUES = "/venues";

    public static final String SEARCH_VENUE_URL = FOURSQUARE_API_VERSION + FOURSQUARE_API_VENUES + "/search?";
    public static final String EXPLORE_VENUE_URL = FOURSQUARE_API_VERSION + FOURSQUARE_API_VENUES + "/explore?";
    public static final String DETAILS_VENUE_URL = FOURSQUARE_API_VERSION + "/venues/{" + VENUE_ID_KEY + "}?";


}
