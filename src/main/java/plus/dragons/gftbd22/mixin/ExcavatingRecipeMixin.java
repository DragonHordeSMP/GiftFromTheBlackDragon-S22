package plus.dragons.gftbd22.mixin;

import com.tom.createores.recipe.ExcavatingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExcavatingRecipe.class)
public class ExcavatingRecipeMixin {

    @Inject(method = "getStress", at = @At("RETURN"), remap = false, cancellable = true)
    private void lowerStress(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue((int) Math.max(1,cir.getReturnValue()*0.125));
    }

}
