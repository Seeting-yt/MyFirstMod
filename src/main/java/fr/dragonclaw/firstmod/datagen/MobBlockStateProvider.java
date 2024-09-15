package fr.dragonclaw.firstmod.datagen;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class MobBlockStateProvider extends BlockStateProvider {
    public MobBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBIS_BLOCK);
        blockWithItem(ModBlocks.RAW_RUBIS_BLOCK);
        blockWithItem(ModBlocks.RUBIS_ORE);

        blockWithItem(ModBlocks.EXPLOSIVE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
