/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import xyz.florex.FlorexLauncher;
import xyz.florex.utils.ZipUtils;

public class Main {
    public static List args = new ArrayList();
    public static String version = null;

    public static long getTime() {
        return new Date().getTime();
    }

    public static void main(String[] stringArray) {
        boolean bl = false;
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("file.encoding", "UTF-8");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2].equals(ZipUtils.decryptSONOYUNCU("7C<??;;<>?@BC"))) {
                bl = true;
            }
            if (stringArray[i2].startsWith("-nb:")) {
                version = stringArray[i2].substring(4);
            }
            args.add(stringArray[i2]);
        }
        if (!bl) {
            JOptionPane.showMessageDialog(null, "Launcher'\u0131 ana klas\u00f6rden a\u00e7amazs\u0131n!\nL\u00fctfen \u00f6nce Launcher Ba\u015flat\u0131c\u0131'y\u0131 a\u00e7!", ZipUtils.decryptSONOYUNCU("Pvy|o\u0082WM*7*Vk\u007fxmro|"), 0);
            System.exit(0);
            return;
        }
        FlorexLauncher.INSTANCE.init();
    }
}

