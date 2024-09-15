package fr.dragonclaw.firstmod.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .fast()
            .saturationMod(2.0f)
            .nutrition(4)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 99,
                    true, false), 1.0f)
            .build();

}
