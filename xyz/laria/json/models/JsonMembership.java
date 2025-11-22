// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.json.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

public class JsonMembership {
    @Expose
    private String username;

    public JsonMembership(String string) {
        this.username = string;
    }

    public JsonMembership() {
        this.username = "";
    }

    public String getUsername() {
        if (this.username == null || this.username.isEmpty()) {
            return "";
        }
        return this.username;
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", this.username);
        return jsonObject;
    }

    public static JsonMembership fromJsonElement(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonMembership jsonAkenoMemberShip = new JsonMembership(null);
        jsonAkenoMemberShip.username = jsonObject.get("username").getAsString();
        return jsonAkenoMemberShip;
    }
}
 