package plus.misterplus.dms.sql.utils;

import com.google.gson.GsonBuilder;

public class GsonHelper {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create().toJson(object);
    }
}
