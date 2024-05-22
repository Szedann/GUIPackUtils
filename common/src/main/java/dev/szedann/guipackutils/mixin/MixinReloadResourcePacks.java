package dev.szedann.guipackutils.mixin;

import dev.szedann.guipackutils.Colors;
import dev.szedann.guipackutils.Constants;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(ReloadableResourceManager.class)
public class MixinReloadResourcePacks {
    @Inject(method = "createReload", at = @At("RETURN"))
    private void createReload(Executor $$0, Executor $$1, CompletableFuture<Unit> $$2, List<PackResources> $$3, CallbackInfoReturnable<ReloadInstance> cir) throws IOException {
        Colors.reload();
    }
}
