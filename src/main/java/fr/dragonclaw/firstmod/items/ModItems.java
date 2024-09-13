package fr.dragonclaw.firstmod.items;

import fr.dragonclaw.firstmod.FirstMod;
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

    public static void register(IEventBus e){
        ITEMS.register(e);
    }
}
