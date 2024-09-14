package fr.dragonclaw.firstmod.items;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRSTMOD_TAB = CREATIVE_MOD_TABS.register("firstmod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBIS.get()))
                    .title(Component.translatable("creativetab.firstmod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_RUBIS.get());
                        pOutput.accept(ModItems.RUBIS.get());
                        pOutput.accept(ModBlocks.RUBIS_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_RUBIS_BLOCK.get());
                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    public static void register(IEventBus e) {

        CREATIVE_MOD_TABS.register(e);

    }
}
