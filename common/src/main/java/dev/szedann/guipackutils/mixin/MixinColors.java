package dev.szedann.guipackutils.mixin;

import dev.szedann.guipackutils.Constants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;


@Mixin(ChatFormatting.class)
public class MixinColors {
//    @Shadow @Final private String name;

//    @Inject(method = "getColor", at = @At("RETURN"))
//    private void modifyBlackEnum(CallbackInfoReturnable<Integer> cir) {
//        Constants.LOG.info(this.name);
//    }
}
