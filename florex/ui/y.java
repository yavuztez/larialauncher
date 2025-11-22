/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.io.File;
import xyz.florex.FlorexLauncher;
import xyz.florex.ui.ButtonActionListener;
import xyz.florex.ui.MainScreen;
import xyz.florex.ui.fu;

public class y
extends ButtonActionListener {
    public final MainScreen ch;
    private static String gecerli = "[a-zA-Z0-9_]{3,16}";

    public y(MainScreen ch) {
        this.ch = ch;
    }

    @Override
    public void x() {
        try {
            String username = this.ch.username.getText();
            if (!username.matches(gecerli)) {
                fu.x(this.ch, "Yanl\u0131\u015f Bir \u015eeyler Var", "Yazd\u0131\u011f\u0131n kullan\u0131c\u0131 ad\u0131 ge\u00e7ersiz! \nKullan\u0131c\u0131 ad\u0131nda T\u00fcrk\u00e7e karakter, bo\u015fluk ve \u00f6zel karakter olmamas\u0131na dikkat et!");
            } else {
                if (!FlorexLauncher.versionsFile.exists()) {
                    FlorexLauncher.INSTANCE.downloadFile((String)FlorexLauncher.INSTANCE.launcherJSON.getClient().get("url"), FlorexLauncher.versionsFile.getAbsolutePath());
                }
                if (!FlorexLauncher.INSTANCE.getFileSHA1(FlorexLauncher.versionsFile).equals(FlorexLauncher.INSTANCE.launcherJSON.getClient().get("sha1"))) {
                    FlorexLauncher.INSTANCE.log("version sha");
                    FlorexLauncher.versionsFile.delete();
                    System.exit(-1);
                    return;
                }
                if (!FlorexLauncher.INSTANCE.getFileSHA1(new File(FlorexLauncher.javaFolder, "lib/rt.jar")).equals(FlorexLauncher.INSTANCE.launcherJSON.getJavaIntegrity().get("rt-x64"))) {
                    FlorexLauncher.INSTANCE.log("java sha");
                    System.exit(-1);
                    return;
                }
                FlorexLauncher.INSTANCE.startClient(username);
                this.ch.setVisible(false);
                this.ch.setLogin(username, this.ch.qr.v());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

