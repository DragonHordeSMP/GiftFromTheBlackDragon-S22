package plus.dragons.gftbd22.mixin;

import com.morallenplay.vanillacookbook.item.CheeseItem;
import com.simibubi.create.content.contraptions.processing.InWorldProcessing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(InWorldProcessing.class)
public class InWorldProcessingMixin {
    @Inject(method = "process", at = @At("RETURN"), cancellable = true, remap = false)
    private static void injected(CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> ret = cir.getReturnValue();
        if(ret!=null)
            if(ret.get(0).getItem() instanceof CheeseItem){
                ret.add(Items.GLASS_BOTTLE.getDefaultInstance());
                cir.setReturnValue(ret);
            }
    }
}
