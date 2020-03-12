package com.irfandi.surveypileg.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import java.util.HashMap;

/**
 * Created by radinaldn on 03/07/18.
 */

public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context _context;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_SURVEYOR = "id_surveyor";
    public static final String NAMA_PETUGAS = "nama_petugas";
    public static final String USERNAME = "username";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String NO_HP = "no_hp";
    public static final String ALAMAT = "alamat";
    public static final String STATUS = "status";

    public static final String SHARE_LOC_IS_ON = "shareLocIsOn";

    public Context get_context(){
        return _context;
    }

    // constructor
    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String id_surveyor, String nama_petugas, String username,String jenis_kelamin, String no_hp, String alamat, String status){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_SURVEYOR, id_surveyor);
        editor.putString(NAMA_PETUGAS, nama_petugas);
        editor.putString(USERNAME, username);
        editor.putString(JENIS_KELAMIN, jenis_kelamin);
        editor.putString(NO_HP, no_hp);
        editor.putString(ALAMAT, alamat);
        editor.putString(STATUS, status);
        editor.commit();
    }

    public HashMap<String, String> getSurveyorDetail(){
        HashMap<String,String> pelapor = new HashMap<>();
        pelapor.put(ID_SURVEYOR, sharedPreferences.getString(ID_SURVEYOR,null));
        pelapor.put(NAMA_PETUGAS, sharedPreferences.getString(NAMA_PETUGAS,null));
        pelapor.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        pelapor.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN,null));
        pelapor.put(NO_HP, sharedPreferences.getString(NO_HP,null));
        pelapor.put(ALAMAT, sharedPreferences.getString(ALAMAT,null));
        pelapor.put(STATUS, sharedPreferences.getString(STATUS,null));

        return pelapor;
    }

    public void logoutSurveyor(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
