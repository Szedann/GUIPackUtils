package dev.szedann.guipackutils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;

import java.io.IOException;
import java.util.Optional;


public class Colors {
    public static void reload() throws IOException {
        ResourceLocation resourceLocation = new ResourceLocation(Constants.MOD_ID, "colors/gui.json");
        Constants.LOG.info(resourceLocation.toString());
        Optional<Resource> resource = Minecraft.getInstance().getResourceManager().getResource(resourceLocation);
        if (resource.isEmpty()) {
            GUITitleColor = Optional.empty();
            return;
        }
        JsonElement json = JsonParser.parseReader(resource.get().openAsReader());
        if (!json.isJsonObject()) {
            GUITitleColor = Optional.empty();
            return;
        }
        JsonObject jsonObject = json.getAsJsonObject();
        GUITitleColor = getColor(jsonObject, "titleColor");
    }
    private static Optional<Integer> getColor(JsonObject jsonObject, String name) {
        if (!jsonObject.has(name)) {
            GUITitleColor = Optional.empty();
            return Optional.empty();
        }
        return Optional.of(jsonObject.get(name).getAsInt());
    }
    public static Optional<Integer> GUITitleColor = Optional.empty();
}
