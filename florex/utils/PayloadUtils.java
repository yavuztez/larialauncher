/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.utils;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.gson.Gson;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import network.sonoyuncu.launcher.json.models.JsonSOGameRequest;
import xyz.florex.FlorexLauncher;
import xyz.florex.utils.SigUtils;

public class PayloadUtils {
    public static final Gson gson = new Gson();

    public static String getPayload() {
        try {
            String sig = PayloadUtils.sig();
            String minecraftCHC = PayloadUtils.getMinecraftCHC();
            String launcherCHC = PayloadUtils.getLauncherCHC();
            String hwid = PayloadUtils.getHWID();
            JsonSOGameRequest soGameRequest = new JsonSOGameRequest(minecraftCHC, launcherCHC, "sl", hwid, sig);
            return "###" + gson.toJson(soGameRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return "QWEQWWQ###WEWEQQEW###QWEWEQ";
        }
    }

    public static String sig() {
        return SigUtils.getSig();
    }

    public static long m(long l) {
        return l + 500L;
    }

    public static String getFileSHA(File file) throws Exception {
        return Files.hash(file, Hashing.sha1()).toString();
    }

    public static String getLauncherSHA(HashFunction hashFunction) throws Exception {
        URL uRL = FlorexLauncher.class.getProtectionDomain().getCodeSource().getLocation();
        File file = new File(uRL.toURI());
        if (file.exists() && !file.isDirectory() && file.canRead()) {
            return Files.hash(file, hashFunction).toString();
        }
        return "err";
    }

    public static String getMinecraftCHC() throws Exception {
        return PayloadUtils.getFileSHA(FlorexLauncher.versionsFile);
    }

    public static String getLauncherCHC() throws Exception {
        return PayloadUtils.getLauncherSHA(Hashing.sha1());
    }

    public static String getHWID() {
        try {
            String[] cmd = new String[]{"wmic", "DISKDRIVE", "get", "SerialNumber"};
            Process process = Runtime.getRuntime().exec(cmd);
            Scanner scanner = new Scanner(process.getInputStream());
            ArrayList<String> arrayList = new ArrayList<String>();
            process.getOutputStream().close();
            while (scanner.hasNext()) {
                arrayList.add(scanner.next());
            }
            process.getInputStream().close();
            scanner.close();
            process.destroy();
            if (((String)arrayList.get(0)).equalsIgnoreCase("serialnumber")) {
                if (arrayList.size() >= 3) {
                    String string3 = ((String)arrayList.get(1)).trim();
                    String string2 = ((String)arrayList.get(2)).trim();
                    return string3 + string2;
                }
                String string3 = ((String)arrayList.get(1)).trim();
                return string3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

