package dev.szedann.guipackutils.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.szedann.guipackutils.Colors;
import dev.szedann.guipackutils.Constants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.io.IOException;
import java.util.Optional;


@Mixin({AbstractContainerScreen.class, InventoryScreen.class, MerchantScreen.class, CreativeModeInventoryScreen.class})
public class MixinAbstractContainerScreen {
    @ModifyArgs(method = "renderLabels", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)I"))
    private void modifyTitle(Args args) throws IOException {
        Component comp = args.get(1);
        Colors.GUITitleColor.ifPresent(integer -> args.set(1, comp.copy().withStyle(comp.getStyle().withColor(TextColor.fromRgb(integer)))));
    }
}
