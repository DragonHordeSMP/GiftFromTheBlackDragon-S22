package plus.dragons.gftbd22.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GameModeCommand.class)
public class Silencer {
    @Inject(method = "logGamemodeChange", at = @At("HEAD"), cancellable = true)
    private static void injected(CommandSourceStack p_137738_, ServerPlayer p_137739_, GameType p_137740_, CallbackInfo ci) {
        ci.cancel();
    }
}
