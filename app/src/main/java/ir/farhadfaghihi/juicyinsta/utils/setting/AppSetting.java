package ir.farhadfaghihi.juicyinsta.utils.setting;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.HashMap;

public class AppSetting
{
    private static HashMap<String, Float> floatValues;
    private static HashMap<String, Boolean> booleanValues;
    public static HashMap<String, Long> longValues;
    public static HashMap<String, String> stringValues;
    public static HashMap<String, Integer> intValues;

    private static Context context ;
    private static AppSetting instance ;

    private AppSetting(Context context)
    {
        this.context = context ;
    }

    public static void init(Context ctx)
    {
        context = ctx ;
    }

    public static AppSetting getInstance()
    {
        if(instance == null)
            instance = new AppSetting(context);
        return instance ;
    }


    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key,Boolean defaultValue) {
        if (booleanValues == null)
            booleanValues = new HashMap<String, Boolean>();

        if (!booleanValues.containsKey(key))
            booleanValues.put(key,
                    PreferenceManager.getDefaultSharedPreferences(context)
                            .getBoolean(key, defaultValue));

        return booleanValues.get(key);
    }

    public void setValue(String key, Boolean value)
    {
        if (booleanValues == null)
            booleanValues = new HashMap<String, Boolean>();

        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.commit();

        booleanValues.put(key, value);
    }

    public Float getFloat( String key) {
        return getFloat(key, null);
    }

    public Float getFloat(String key, Float defaultValue) {
        if (floatValues == null)
            floatValues = new HashMap<String, Float>();

        if (!floatValues.containsKey(key))
            floatValues.put(key,
                    PreferenceManager.getDefaultSharedPreferences(context)
                            .getFloat(key, defaultValue));

        return floatValues.get(key);
    }

    public void setValue(String key, Float value) {

        if (floatValues == null)
            floatValues = new HashMap<String, Float>();

        Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putFloat(key, value);
        editor.commit();

        floatValues.put(key, value);
    }


    public Long getLong(String key) {
        return getLong( key, null);
    }

    public Long getLong(String key, Long defaultValue) {
        if (longValues == null)
            longValues = new HashMap<String, Long>();

        if (!longValues.containsKey(key))
            longValues.put(key,
                    PreferenceManager.getDefaultSharedPreferences(context)
                            .getLong(key, defaultValue));

        return longValues.get(key);
    }

    public void setValue( String key, Long value) {

        if (longValues == null)
            longValues = new HashMap<String, Long>();

        Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putLong(key, value);
        editor.commit();

        longValues.put(key, value);
    }


    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        if (stringValues == null)
            stringValues = new HashMap<String, String>();

        if (!stringValues.containsKey(key))
            stringValues.put(key,
                    PreferenceManager.getDefaultSharedPreferences(context)
                            .getString(key, defaultValue));

        return stringValues.get(key);
    }

    public void setValue(String key, String value) {

        if (stringValues == null)
            stringValues = new HashMap<String, String>();

        Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putString(key, value);
        editor.commit();

        stringValues.put(key, value);
    }


    public Integer getInt( String key) {
        return getInt( key, null);
    }

    public Integer getInt(String key,Integer defaultValue) {
        if (intValues == null)
            intValues = new HashMap<String, Integer>();

        if (!intValues.containsKey(key))
            intValues.put(key,
                    PreferenceManager.getDefaultSharedPreferences(context)
                            .getInt(key, defaultValue));

        return intValues.get(key);
    }

    public void setValue(String key, Integer value) {

        if (intValues == null)
            intValues = new HashMap<String, Integer>();

        Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putInt(key, value);
        editor.commit();

        intValues.put(key, value);
    }

}
