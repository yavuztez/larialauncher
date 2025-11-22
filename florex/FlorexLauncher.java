/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import xyz.florex.MinecraftThread;
import xyz.florex.SecurityM;
import xyz.florex.json.models.LauncherJSON;
import xyz.florex.ui.MainScreen;
import xyz.florex.utils.ConsoleFilter;
import xyz.florex.utils.FontLoader;
import xyz.florex.utils.JSONUtils;
import xyz.florex.utils.SoClassLoader;

public enum FlorexLauncher {
    INSTANCE;

    public static final File minecraftFolder;
    public static final File versionsFile;
    public static final File javaFolder;
    static final File launcherFile;
    static final File assetsFile;
    static final File librariesFile;
    static final File librariesNativesFile;
    static File gameDirectory;
    static File gameDirectoryPublic;
    public static File memberShipFile;
    private static final Gson gson;
    public static final JsonParser parser;
    public LauncherJSON launcherJSON;
    private MainScreen ui;
    private FontLoader fontLoader;
    private ConsoleFilter b;
    private String javaVersion;
    private String bit;

    public static void setupFiles() {
        gameDirectory = new File(minecraftFolder, "game-directories");
        gameDirectoryPublic = new File(gameDirectory, "public");
        memberShipFile = new File(minecraftFolder, "membership.json");
        if (!memberShipFile.exists()) {
            try {
                memberShipFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startClient(String username) throws Exception {
        this.log("Starting client...");
        String string = librariesNativesFile.getAbsolutePath();
        System.setProperty("org.lwjgl.librarypath", string);
        System.setProperty("net.java.games.input.librarypath", string);
        System.setProperty("java.library.path", string);
        URL[] urls = new URL[]{versionsFile.toURI().toURL()};
        SoClassLoader classLoader = new SoClassLoader(urls, ClassLoader.getSystemClassLoader());
        URLClassLoader systemClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        Class<URLClassLoader> systemClassLoaderClass = URLClassLoader.class;
        Method method = systemClassLoaderClass.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(systemClassLoader, urls[0]);
        Thread.currentThread().setContextClassLoader(classLoader);
        MinecraftThread mcThread = new MinecraftThread(classLoader, username);
        mcThread.setName("Minecraft Thread");
        mcThread.start();
    }

    public void init() {
        try {
            this.launcherJSON = (LauncherJSON)JSONUtils.getJSONfromURL(new URL(FlorexLauncher.decryptBABATest("//5+AGMAbABpAGkAIQAzADIAbAB+AFcADwBFAEoAUABNAFMARQBdAFoATwBZAE8AQgBAAFsAVQBfAEYAHQBXAFoAWwAYAEEAWABMAE4ARgBJAFsARQBvAC0AIwAxAC0AJAAqACYAPQAnACkAIwBjAD8AKwApACMAfgA6ADYANQAxACUAeAA1ADgAMwA1AHMAMQA/ACoADgACAAoABgAWAEsADAAUAAcABwA=")), LauncherJSON.class, gson);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.setSecurityManager(new SecurityM());
        this.log("--- FlorexMC Minecraft Launcher ---");
        try {
            this.javaVersion = System.getProperty("java.version");
        } catch (Exception e) {
            // empty catch block
        }
        try {
            this.bit = System.getProperty("sun.arch.data.model");
        } catch (Exception e) {
            // empty catch block
        }
        if (this.javaVersion != null && !this.javaVersion.isEmpty()) {
            this.log("Java Version: " + this.javaVersion + (this.bit != null && !this.bit.isEmpty() ? " x" + this.bit : ""));
        }
        this.log("Konsol mesajlar\u0131n\u0131 kullanmak i\u00e7in filtre ekleniyor...");
        this.b = new ConsoleFilter();
        LoggerContext loggerContext = (LoggerContext)LogManager.getContext(false);
        loggerContext.addFilter(this.b);
        this.log("Konsol mesajlar\u0131n\u0131 kullanmak i\u00e7in filtre eklendi.");
        this.log("Kullan\u0131c\u0131 aray\u00fcz\u00fc menajerleri ayarlan\u0131yor ve y\u00fckleniyor...");
        this.fontLoader = new FontLoader();
        this.fontLoader.x("/assets/fonts/AmsiPro-Bold.ttf");
        this.fontLoader.x("/assets/fonts/AmsiPro-Italic.ttf");
        this.fontLoader.x("/assets/fonts/AmsiPro-Light.ttf");
        this.fontLoader.x("/assets/fonts/AmsiPro-LightItalic.ttf");
        this.fontLoader.x("/assets/fonts/AmsiPro-SemiBold.ttf");
        this.fontLoader.x("/assets/fonts/AmsiPro-Ultra.ttf");
        this.log("Kullan\u0131c\u0131 aray\u00fcz\u00fc menajerleri ayarland\u0131 ve y\u00fcklendi.");
        this.log("Launcher ba\u015far\u0131yla \u00e7al\u0131\u015ft\u0131r\u0131ld\u0131.");
        this.ui = new MainScreen(this.fontLoader);
        this.ui.readLogin();
        this.ui.setVisible(true);
    }

    public static long d(long l) {
        return l + 800L - 800L;
    }

    public static String decryptBABATest(String xd) {
        byte[] dd = Base64.getDecoder().decode(xd);
        String dLayer1 = new String(dd, StandardCharsets.UTF_16);
        StringBuilder enc = new StringBuilder();
        char[] chars = dLayer1.toCharArray();
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c = (char)(chars[i2] ^ i2 + 22);
            enc.append(c);
        }
        return enc.toString();
    }

    public void log(String string) {
        LogManager.getRootLogger().info(string);
    }

    public Path downloadFile(String FILE_URL, String FILE_NAME) {
        try {
            InputStream in = new URL(FILE_URL).openStream();
            Path path = Paths.get(FILE_NAME, new String[0]);
            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFileSHA1(File file) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        InputStream fis = Files.newInputStream(file.toPath(), new OpenOption[0]);
        int n = 0;
        byte[] buffer = new byte[8192];
        while (n != -1) {
            n = fis.read(buffer);
            if (n <= 0) continue;
            sha1.update(buffer, 0, n);
        }
        return FlorexLauncher.byteArrayToHexString(sha1.digest());
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (byte value : b) {
            result.append(Integer.toString((value & 0xFF) + 256, 16).substring(1));
        }
        return result.toString();
    }

    static {
        gson = new GsonBuilder().create();
        parser = new JsonParser();
        minecraftFolder = new File(System.getenv("APPDATA"), ".florex/");
        if (!minecraftFolder.exists()) {
            minecraftFolder.mkdir();
        }
        versionsFile = new File(minecraftFolder, "vers/1.8.9-Optifine-Ultra_.jar");
        javaFolder = new File(minecraftFolder, "java");
        launcherFile = new File(minecraftFolder, "launcher.jar");
        assetsFile = new File(minecraftFolder, "assets");
        librariesFile = new File(minecraftFolder, "libraries");
        librariesNativesFile = new File(librariesFile, "natives");
        FlorexLauncher.setupFiles();
    }
}

