/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.utils;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;

public class JSONUtils {
    public static Object getJSONfromURL(URL uRL, Class<?> clazz, Gson gson) {
        try {
            HttpsURLConnection httpURLConnection = (HttpsURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty("User-Agent", "Java");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            Object object2 = gson.fromJson((Reader)inputStreamReader, clazz);
            ((Reader)inputStreamReader).close();
            inputStream.close();
            httpURLConnection.disconnect();
            return object2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

