package xyz.laria.ui;

import java.io.File;

import xyz.laria.LariaLauncher;

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
                FU.x(this.ch, "Yanlış Bir Şeyler Var", "Yazdığın kullanıcı adı geçersiz! \nKullanıcı adında Türkçe karakter, boşluk ve özel karakter olmamasına dikkat et!");
            } else {
                if (!LariaLauncher.versionsFile.exists()) {
                    LariaLauncher.INSTANCE.downloadFile((String) LariaLauncher.INSTANCE.launcherJSON.getClient().get("url"), LariaLauncher.versionsFile.getAbsolutePath());
                }
                if (!LariaLauncher.INSTANCE.getFileSHA1(LariaLauncher.versionsFile).equals(LariaLauncher.INSTANCE.launcherJSON.getClient().get("sha1"))) {
                    LariaLauncher.INSTANCE.log("version sha");
                    LariaLauncher.versionsFile.delete();
                    System.exit(-1);
                    return;
                }
                if (!LariaLauncher.INSTANCE.getFileSHA1(new File(LariaLauncher.javaFolder, "lib/rt.jar")).equals(LariaLauncher.INSTANCE.launcherJSON.getJavaIntegrity().get("rt-x64"))) {
                    LariaLauncher.INSTANCE.log("java sha");
                    System.exit(-1);
                    return;
                }

                // Başarılı girişten sonra kullanıcı bilgisini kaydet
                this.ch.setLogin(username, this.ch.qr.v());

                // Sivas ana menü ekranını başlat
                Sivas sivasScreen = new Sivas(this.ch, username);
                sivasScreen.setVisible(true);

                // Giriş ekranını gizle
                this.ch.setVisible(false);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}