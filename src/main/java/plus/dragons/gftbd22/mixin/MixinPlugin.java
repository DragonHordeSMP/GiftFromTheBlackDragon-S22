package plus.dragons.gftbd22.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class MixinPlugin implements IMixinConfigPlugin {

    private static final Map<String, Supplier<Boolean>> CONDITIONAL_LOADING = ImmutableMap.of(
            "plus.dragons.gftbd22.mixin.InWorldProcessingMixin",
            () -> isLoaded("create") && isLoaded("vanillacookbook"),
            "plus.dragons.gftbd22.mixin.ExcavatingRecipeMixin",
            () -> isLoaded("createoreexcavation")
    );
    @Override
    public void onLoad(String mixinPackage) {

    }

    public static boolean isLoaded(String modid) {
        boolean isLoaded = FMLLoader.getLoadingModList().getModFileById(modid) != null;
        return isLoaded;
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return CONDITIONAL_LOADING.getOrDefault(mixinClassName, ()->true).get();
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
