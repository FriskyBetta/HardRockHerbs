package net.frikky.hrherbs.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class HRFoods {

    public static final FoodProperties CATNIP = new FoodProperties.Builder().nutrition(1).fast().alwaysEat()
            .saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20), 1).build();

}
