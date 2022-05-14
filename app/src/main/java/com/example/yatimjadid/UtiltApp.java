package com.example.yatimjadid;

import android.content.Context;

import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.Models.FamilyMembersModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class UtiltApp {

    private static SharedPManger sharedPManger;

    public static ArrayList<FamilyMembersModel> getFamilyMembers(Context context) {

        String json = getFromPref(context, Constants.KEY_FAMILY_MEMBERS);
        if (json != null) {
            return new Gson().fromJson(json, new TypeToken<ArrayList<FamilyMembersModel>>() {}.getType());
        } else {
            return new ArrayList<>();
        }
    }

    public static void setFamilyMembers(Context context, ArrayList<FamilyMembersModel> list) {

        String json = list != null ? new Gson().toJson(list) : null;
        setToPref(context, Constants.KEY_FAMILY_MEMBERS, json);
    }

    private static String getFromPref(Context context, String type) {
        if (sharedPManger == null)
            sharedPManger = new SharedPManger(context);
        return sharedPManger.getDataString(type);

    }

    private static void setToPref(Context context, String type, String data) {
        if (sharedPManger == null)
            sharedPManger = new SharedPManger(context);
        sharedPManger.SetData(type, data);

    }



    public static ArrayList<AddYatimModel> getYatemData(Context context) {

        String json = getYatimFromPref(context, Constants.KEY_NEW_YATIM_DATA_MODEL);
        if (json != null) {
            return new Gson().fromJson(json, new TypeToken<ArrayList<AddYatimModel>>() {}.getType());
        } else {
            return new ArrayList<>();
        }
    }

    public static void setYatimData(Context context, ArrayList<AddYatimModel> list) {

        String json = list != null ? new Gson().toJson(list) : null;
        setYatimToPref(context, Constants.KEY_NEW_YATIM_DATA_MODEL, json);
    }

    private static String getYatimFromPref(Context context, String type) {
        if (sharedPManger == null)
            sharedPManger = new SharedPManger(context);
        return sharedPManger.getDataString(type);

    }

    private static void setYatimToPref(Context context, String type, String data) {
        if (sharedPManger == null)
            sharedPManger = new SharedPManger(context);
        sharedPManger.SetData(type, data);

    }

}
