package fr.dragonclaw.firstmod.items;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.items.customs.FluelItem;
import fr.dragonclaw.firstmod.items.customs.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            FirstMod.MOD_ID);

    public static final RegistryObject<Item> RUBIS = ITEMS.register("rubis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_RUBIS = ITEMS.register("raw_rubis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            ()-> new FluelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFood.STRAWBERRY)));

    public static void register(IEventBus e){
        ITEMS.register(e);
    }
}
