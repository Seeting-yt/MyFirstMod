package fr.dragonclaw.firstmod.blocks;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.blocks.customs.ExplosiveBlock;
import fr.dragonclaw.firstmod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> RUBIS_BLOCK =
            registerBlock("rubis_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_RUBIS_BLOCK =
            registerBlock("raw_rubis_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RUBIS_ORE =
            registerBlock("rubis_ore", () -> new DropExperienceBlock(BlockBehaviour.
                    Properties.copy(Blocks.STONE).strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 6)));


    public static final RegistryObject<Block> EXPLOSIVE_BLOCK =
            registerBlock("explosive_block", () -> new ExplosiveBlock(BlockBehaviour.Properties.copy(Blocks.TNT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus e) {
        BLOCKS.register(e);
    }

}
