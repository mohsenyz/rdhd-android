package com.rdhd.app.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {
    private static final String APITOKEN= "ApiToken";



    private static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setAPITOKEN(Context ctx, String apitoken)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(APITOKEN, apitoken);
        editor.apply();
    }

    public static String getAPITOKEN(Context ctx)
    {
        return getSharedPreferences(ctx).getString(APITOKEN, "");
    }

}
