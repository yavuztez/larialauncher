package xyz.laria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import xyz.laria.utils.ZipUtils;

public class Main {
    public static List args = new ArrayList();
    public static String version = null;

    public static long getTime() {
        return new Date().getTime();
    }

    public static void main(String[] stringArray) {
        boolean bl = true;
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
            JOptionPane.showMessageDialog(null, "Launcher'ı ana klasörden açamazsın!\nLütfen önce Launcher Başlatıcı'yı aç!", ZipUtils.decryptSONOYUNCU("VoXo~y|u*7*Vk⌂xmro|"), 0);
            System.exit(0);
            return;
        }
        LariaLauncher.INSTANCE.init();
    }
}
 