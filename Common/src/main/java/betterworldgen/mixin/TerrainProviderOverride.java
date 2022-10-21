package betterworldgen.mixin;

import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import betterworldgen.BetterWorldgen;

@Mixin(TerrainProvider.class)
public abstract class TerrainProviderOverride {

    @Shadow
    public static <C, I extends ToFloatFunction<C>> CubicSpline<C, I> buildErosionOffsetSpline(I $$0, I $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7, boolean $$8, boolean $$9, ToFloatFunction<Float> $$10) {
        throw new IllegalStateException(BetterWorldgen.MODID + ": conflict in overworldOffset MIXIN!!");
    }

    @Inject(method = "overworldOffset", at = @At(value = "RETURN"), cancellable = true)
    private static <C, I extends ToFloatFunction<C>> void overrideOffset(I dsCoordOne, I dsCoordTwo, I dsCoordThree, boolean amplified, CallbackInfoReturnable<CubicSpline<C, I>> cir) {
        ToFloatFunction<Float> toFloatFunction = ToFloatFunction.createUnlimited((val) -> val < 0.0F ? val : val * 1.5F);
        CubicSpline<C, I> cubicSplineOne = buildErosionOffsetSpline(
                dsCoordTwo, dsCoordThree, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, toFloatFunction);
        CubicSpline<C, I> cubicSplineTwo = buildErosionOffsetSpline(
                dsCoordTwo, dsCoordThree, -0.1F, 0.03F, 0.1F, 0.1F, 0.01F, -0.03F, false, false, toFloatFunction);
        CubicSpline<C, I> cubicSplineThree = buildErosionOffsetSpline(
                dsCoordTwo, dsCoordThree, -0.1F, 0.03F, 0.1F, 0.7F, 0.01F, -0.03F, true, true, toFloatFunction);
        CubicSpline<C, I> cubicSplineFour = buildErosionOffsetSpline(
                dsCoordTwo, dsCoordThree, -0.05F, 0.03F, 0.1F, 1.0F, 0.01F, 0.01F, true, true, toFloatFunction);

        cir.setReturnValue(
                CubicSpline.builder(dsCoordOne, toFloatFunction)
                        .addPoint(-1.1F, 0.044F).addPoint(-1.02F, -0.2222F)
                        .addPoint(-0.51F, -0.2222F).addPoint(-0.44F, -0.12F)
                        .addPoint(-0.18F, -0.12F).addPoint(-0.16F, cubicSplineOne)
                        .addPoint(-0.15F, cubicSplineOne).addPoint(-0.1F, cubicSplineTwo)
                        .addPoint(0.25F, cubicSplineThree).addPoint(1.0F, cubicSplineFour).build());
    }

}