package betterworldgen.mixin;

import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouterData;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import betterworldgen.BetterWorldgen;

@Mixin(NoiseRouterData.class)
public class NoiseRouterDataOverride {

    @Invoker("slide")
    static DensityFunction getSlide(DensityFunction $$0, int $$1, int $$2, int $$3, int $$4, double $$5, int $$6, int $$7, double $$8) {
        throw new IllegalStateException(BetterWorldgen.MODID + ": conflict in slideOverworld MIXIN!!");
    }

    @Inject(at = @At(value = "RETURN"), method = "slideOverworld", cancellable = true)
    private static void reslideOverworld(boolean $$0, DensityFunction $$1, CallbackInfoReturnable<DensityFunction> cir) {
        //Vanilla slide($$1, -64, 384, 80, 64, 0, -0.078125D, 0, 24, 0.1171875D)
        cir.setReturnValue(getSlide($$1, -64, 384, 16, 0, -0.078125D, 0, 24, 0.234375D));
    }

}