/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex;

import java.io.File;
import java.util.UUID;
import xyz.florex.FlorexLauncher;

public class MinecraftThread
extends Thread {
    private final String username;

    public MinecraftThread(ClassLoader classLoader, String username) {
        this.username = username;
        this.setContextClassLoader(classLoader);
    }

    @Override
    public void run() {
        try {
            Object[] mArgs = new Object[]{this.getArguments(this.username)};
            this.getContextClassLoader().loadClass("net.minecraft.client.main.Main").getMethod("main", String[].class).invoke(null, mArgs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String[] getArguments(String playerName) {
        String[] stringArray = "--username ${auth_player_name} --version ${version_name} --gameDir ${game_directory} --assetsDir ${assets_root} --assetIndex ${assets_index_name} --uuid ${auth_uuid} --accessToken ${auth_access_token} --userProperties ${user_properties} --userType ${user_type}".split(" ");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = stringArray[i2];
            if (string2.startsWith("--")) continue;
            if (string2.equalsIgnoreCase("${auth_player_name}")) {
                stringArray[i2] = playerName;
            }
            if (string2.equalsIgnoreCase("${version_name}")) {
                stringArray[i2] = "1.8.9-Optifine-Ultra_";
            }
            if (string2.equalsIgnoreCase("${game_directory}")) {
                stringArray[i2] = new File(FlorexLauncher.minecraftFolder, "game-directories/public").getAbsolutePath();
            }
            if (string2.equalsIgnoreCase("${game_assets}")) {
                stringArray[i2] = new File(FlorexLauncher.minecraftFolder, "assets/virtual").getAbsolutePath();
            }
            if (string2.equalsIgnoreCase("${assets_root}")) {
                stringArray[i2] = new File(FlorexLauncher.minecraftFolder, "assets").getAbsolutePath();
            }
            if (string2.equalsIgnoreCase("${assets_index_name}")) {
                stringArray[i2] = "1.8";
            }
            if (string2.equalsIgnoreCase("${auth_uuid}")) {
                stringArray[i2] = UUID.nameUUIDFromBytes(("OfflinePlayer:" + playerName).getBytes()).toString();
            }
            if (string2.equalsIgnoreCase("${auth_access_token}")) {
                stringArray[i2] = "00000000000000000000000000000000";
            }
            if (string2.equalsIgnoreCase("${user_properties}")) {
                stringArray[i2] = "{}";
            }
            if (string2.equalsIgnoreCase("${user_type}")) {
                stringArray[i2] = "mojang";
            }
            if (!string2.equalsIgnoreCase("${version_type}")) continue;
            stringArray[i2] = "release";
        }
        return stringArray;
    }
}

