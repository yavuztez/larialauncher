/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.utils;

import java.util.Random;
import xyz.florex.FlorexLauncher;
import xyz.florex.Main;
import xyz.florex.SecurityM;
import xyz.florex.utils.PayloadUtils;
import xyz.florex.utils.SoClassLoader;
import xyz.florex.utils.ZipUtils;

public class SigUtils {
    private static final Random random = new Random();
    private static long c = 16L;

    public static String getRandomChar() {
        String[] stringArray = new String[]{"=", "?", "*", "-"};
        return stringArray[random.nextInt(stringArray.length)] + stringArray[random.nextInt(stringArray.length)] + stringArray[random.nextInt(stringArray.length)];
    }

    private static int getSplitter() {
        return Integer.parseInt(FlorexLauncher.decryptBABATest("/v8AJwAkACgALQAiACgAKgAoAC4ALQ=="));
    }

    public static String getSig() {
        String string = SigUtils.getRandomChar();
        long l = Main.getTime();
        long l2 = PayloadUtils.m(l);
        String string2 = ZipUtils.randomKey((int)c);
        String string3 = SigUtils.multipler(string) + FlorexLauncher.d(l) + SigUtils.multipler(string) + FlorexLauncher.d(l2) + SigUtils.multipler(string) + SigUtils.getHashCodes(string);
        return SigUtils.multipler(string) + string2 + SigUtils.multipler(string) + ZipUtils.encrypt(string2, string3);
    }

    private static String getHashCodes(String string) {
        return SigUtils.getSplitter() + string + FlorexLauncher.class.hashCode() + string + Main.class.hashCode() + string + SoClassLoader.class.hashCode() + string + SecurityM.class.hashCode() + string + ZipUtils.class.hashCode();
    }

    public static String multipler(String string) {
        return (string + string + string).substring(0, string.length());
    }
}

