/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.utils;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageUtils {
    public static List getIconList() {
        ArrayList<BufferedImage> arrayList = new ArrayList<BufferedImage>();
        arrayList.add(ImageUtils.getImage("icons/logo/16x16.png"));
        arrayList.add(ImageUtils.getImage("icons/logo/32x32.png"));
        arrayList.add(ImageUtils.getImage("icons/logo/64x64.png"));
        arrayList.add(ImageUtils.getImage("icons/logo/128x128.png"));
        arrayList.add(ImageUtils.getImage("icons/logo/256x256.png"));
        return arrayList;
    }

    public static Dimension v() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double d = dimension.getWidth() / 1.25;
        double d2 = dimension.getHeight() / 1.25;
        if (d > 1920.0) {
            d = 1920.0;
        }
        if (d2 > 1080.0) {
            d2 = 1080.0;
        }
        return new Dimension((int)d, (int)d2);
    }

    public static Dimension x(GraphicsConfiguration graphicsConfiguration) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsConfiguration);
        return new Dimension(dimension.width, dimension.height - insets.bottom);
    }

    public static BufferedImage getImage(String string) {
        try {
            InputStream inputStream = ImageUtils.class.getResourceAsStream("/assets/" + string);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception exception) {
                    // empty catch block
                }
            }
            return bufferedImage;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

