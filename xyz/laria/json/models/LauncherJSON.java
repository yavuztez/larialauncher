// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.json.models;

import com.google.gson.annotations.Expose;
import java.util.Map;

public class LauncherJSON {
    private String java_preferred_type;
    private String version;
    @Expose
    private String bootVersion;
    @Expose
    private Map java;
    @Expose
    Map versionControl;
    @Expose
    Map javaIntegrity;
    @Expose
    Map downloads;
    private String natives_url;
    private String assets_url;
    private String launcher_jar_url;
    private String launcher_jar_checksum;
    private String launcher_path;
    private String launcher_args;

    public String getJava_preferred_type() {
        return this.java_preferred_type;
    }

    public String getBootVersion() {
        return this.bootVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public Map getJava() {
        return this.java;
    }

    public String getJavaVariable(String string) {
        return (String)this.java.get(string);
    }

    public Map getVersionControl() {
        return this.versionControl;
    }

    public String getVersionControlVariable(String key) {
        return (String)((Map)this.getVersionControl().get("windows")).get(key);
    }

    public String getLauncher_jar_url() {
        return this.launcher_jar_url;
    }

    public String getNatives_url() {
        return this.natives_url;
    }

    public String getAssets_url() {
        return this.assets_url;
    }

    public String getLauncher_jar_checksum() {
        return this.launcher_jar_checksum;
    }

    public String getLauncher_path() {
        return this.launcher_path;
    }

    public String getLauncher_args() {
        return this.launcher_args;
    }

    public Map getJavaIntegrity() {
        return this.javaIntegrity;
    }

    public Map getClient() {
        return (Map)this.downloads.get("client");
    }
}
 