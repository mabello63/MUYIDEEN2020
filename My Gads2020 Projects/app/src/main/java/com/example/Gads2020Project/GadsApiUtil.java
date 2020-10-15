package com.example.Gads2020Project;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class GadsApiUtil {
    private GadsApiUtil(){}
    public static final String BASE_API_URL = "https://gadsapi.herokuapp.com/api/";
    public static final String LEARNING_HOURS = "hours";
    public static final String SKILL_IQ = "skilliq";
    public static final String KEY = "key";

    public String json = null;

    public static URL buildUrl(String qry_parameter){
        String fullUrl = "";
        URL url = null;
        Uri uri = null;

        if (qry_parameter.isEmpty() == false) {
            fullUrl = BASE_API_URL + qry_parameter;
            uri = Uri.parse(fullUrl).buildUpon()
         //           .appendQueryParameter(KEY,API_KEY)
                    .build();

        }
        try {
            url = new URL(uri.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  url;
    }
    public static String getJASON(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasNext = scanner.hasNext();
            if(hasNext) {
                return scanner.next();
            }
            else {
                return null;
            }
        }
        catch (Exception e) {
            Log.d("Error", e.toString());
            return null;
        }
        finally {
            connection.disconnect();
        }
    }

    public static ArrayList<HoursData> getHoursFromJason(String json){
        final String ID = "id";
        final String NAME = "name";
        final String HOURS = "hours";
        final String COUNTRY = "country";
        final String BADGURL = "badgeUrl";
        ArrayList<HoursData> hoursArray = new ArrayList<HoursData>();
        try {
            JSONArray jsonHours = new JSONArray(json);

            int numberOfUsers = jsonHours.length();

            for (int i=0; i< numberOfUsers; i++){
                JSONObject hoursRecordJSON = jsonHours.getJSONObject(i);

                HoursData hoursRecord = new HoursData(
                        (hoursRecordJSON.isNull(NAME )?"":hoursRecordJSON.getString(NAME )),
                        (hoursRecordJSON.isNull(HOURS )?"0":hoursRecordJSON.getString(HOURS )),
                        (hoursRecordJSON.isNull(COUNTRY )?"":hoursRecordJSON.getString(COUNTRY)),
                        (hoursRecordJSON.isNull(BADGURL )?"":hoursRecordJSON.getString(BADGURL ))
                );
                hoursArray.add(hoursRecord);

            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return hoursArray;
    }

    public static ArrayList<SkillsData> getSkillsFromJason(String json){
        final String ID = "id";
        final String NAME = "name";
        final String SCORE = "score";
        final String COUNTRY = "country";
        final String BADGEURL = "badgeUrl";
        ArrayList<SkillsData> skillsArray = new ArrayList<SkillsData>();
        try {
            JSONArray jsonSkills = new JSONArray(json);

            int numberOfUsers = jsonSkills.length();

            for (int i=0; i< numberOfUsers; i++){
                JSONObject skillsRecordJSON = jsonSkills.getJSONObject(i);

                SkillsData skillsRecord = new SkillsData(
                        (skillsRecordJSON.isNull(NAME )?"":skillsRecordJSON.getString(NAME )),
                        (skillsRecordJSON.isNull(SCORE )?"0":skillsRecordJSON.getString(SCORE )),
                        (skillsRecordJSON.isNull(COUNTRY )?"":skillsRecordJSON.getString(COUNTRY)),
                        (skillsRecordJSON.isNull(BADGEURL )?"":skillsRecordJSON.getString(BADGEURL ))
                );
                skillsArray.add(skillsRecord);

            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return skillsArray;
    }


}





