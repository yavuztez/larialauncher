package xyz.laria.utils;

import java.util.Random;
import xyz.laria.LariaLauncher;
import xyz.laria.Main;
import xyz.laria.SecurityM;

public class SigUtils {
    private static final Random random = new Random();
    private static long c = 16L;

    public static String getRandomChar() {
        String[] stringArray = new String[]{"=", "?", "*", "-"};
        return stringArray[random.nextInt(stringArray.length)] + stringArray[random.nextInt(stringArray.length)] + stringArray[random.nextInt(stringArray.length)];
    }

    private static int getSplitter() {
        return Integer.parseInt(LariaLauncher.decryptBABATest("/v8AJwAkACgALQAiACgAKgAoAC4ALQ=="));
    }

    public static String getSig() {
        String string = getRandomChar();
        long l = Main.getTime();
        long l2 = PayloadUtils.m(l);
        String string2 = ZipUtils.randomKey((int)c);
        String string3 = multipler(string) + LariaLauncher.d(l) + multipler(string) + LariaLauncher.d(l2) + multipler(string) + getHashCodes(string);
        return multipler(string) + string2 + multipler(string) + ZipUtils.encrypt(string2, string3);
    }

    private static String getHashCodes(String string) {
        return getSplitter() + string + LariaLauncher.class.hashCode() + string + Main.class.hashCode() + string + SoClassLoader.class.hashCode() + string + SecurityM.class.hashCode() + string + ZipUtils.class.hashCode();
    }

    public static String multipler(String string) {
        return (string + string + string).substring(0, string.length());
    }
}
