/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.json.models;

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

