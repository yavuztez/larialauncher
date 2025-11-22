package network.sonoyuncu.launcher.json.models;

import com.google.gson.annotations.Expose;

public class JsonSOGameRequest {
    @Expose
    private String token;
    @Expose
    private String launcherCHC;
    @Expose
    private String sig;
    @Expose
    private String suid;
    @Expose
    private String minecraftCHC;

    public JsonSOGameRequest(String string, String string2, String string3, String string4, String string5) {
        this.minecraftCHC = string;
        this.launcherCHC = string2;
        this.token = string3;
        this.suid = string4;
        this.sig = string5;
    }
}
 