package xyz.laria.utils;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.font.TextAttribute;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class FontLoader {
    private static final Pattern rrr = Pattern.compile("(?<FontName>[\\w\\d\\-\\.]+)\\.ttf");

    public Font x(String string, int n, int n2) {
        return new Font(string, n, n2);
    }

    public Font x(String string, int n, int n2, double d) {
        Font font = this.x(string, n, n2);
        HashMap hashMap = new HashMap();
        hashMap.put(TextAttribute.TRACKING, d);
        return font.deriveFont(hashMap);
    }

    public Font x(String string) {
        String string2 = this.h(string);
        Font font = v(string);
        return this.x(string2, font);
    }

    public Font x(String string, Font font) {
        LogManager.getRootLogger().info(string + " isimli font yüklendi.");
        return font;
    }

    private String h(String string) {
        Matcher matcher = rrr.matcher(string);
        return matcher.find() ? matcher.group("FontName") : string;
    }

    private static Font v(String string) {
        try {
            InputStream inputStream = FontLoader.class.getResourceAsStream(string);
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font font = Font.createFont(0, inputStream);

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            graphicsEnvironment.registerFont(font);
            return font;
        } catch (Exception var6) {
            LogManager.getRootLogger().log(Level.WARN, "Bir hata oluştu!", var6);
            return null;
        }
    }
}
