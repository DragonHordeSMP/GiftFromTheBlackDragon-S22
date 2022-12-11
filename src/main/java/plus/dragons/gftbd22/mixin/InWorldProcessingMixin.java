package plus.dragons.gftbd22.mixin;

import com.morallenplay.vanillacookbook.item.CheeseItem;
import com.simibubi.create.content.contraptions.processing.InWorldProcessing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Pseudo
@Mixin(InWorldProcessing.class)
public class InWorldProcessingMixin {
    @Inject(method = "process", at = @At("RETURN"), cancellable = true, remap = false)
    private static void keepGlassBottle(CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> ret = cir.getReturnValue();
        if(ret!=null && !ret.isEmpty())
            if(ret.get(0).getItem() instanceof CheeseItem){
                var bottle = Items.GLASS_BOTTLE.getDefaultInstance();
                bottle.setCount(ret.get(0).getCount());
                ret.add(bottle);
                cir.setReturnValue(ret);
            }
    }
}
