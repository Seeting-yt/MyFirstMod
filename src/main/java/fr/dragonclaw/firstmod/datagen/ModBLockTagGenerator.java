package fr.dragonclaw.firstmod.datagen;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.blocks.ModBlocks;
import fr.dragonclaw.firstmod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBLockTagGenerator extends BlockTagsProvider {
    public ModBLockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_ORES)
                .add(ModBlocks.RUBIS_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBIS_BLOCK.get(),
                        ModBlocks.RAW_RUBIS_BLOCK.get(),
                        ModBlocks.RUBIS_ORE.get(),
                        ModBlocks.EXPLOSIVE_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBIS_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_RUBIS_BLOCK.get());
    }
}
