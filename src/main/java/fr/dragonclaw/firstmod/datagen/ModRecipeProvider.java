package fr.dragonclaw.firstmod.datagen;

import fr.dragonclaw.firstmod.FirstMod;
import fr.dragonclaw.firstmod.blocks.ModBlocks;
import fr.dragonclaw.firstmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBIS_SMELTABLES = List.of(ModItems.RAW_RUBIS.get(),
            ModBlocks.RUBIS_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, RUBIS_SMELTABLES, RecipeCategory.MISC, ModItems.RUBIS.get(), 0.25f,
                200, "rubis");
        oreBlasting(pWriter, RUBIS_SMELTABLES, RecipeCategory.MISC, ModItems.RUBIS.get(), 0.25f, 50,
                 "rubis");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBIS_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBIS.get())
                .unlockedBy(getHasName(ModItems.RUBIS.get()), has(ModItems.RUBIS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBIS.get(), 9)
                .requires(ModBlocks.RUBIS_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBIS_BLOCK.get()), has(ModBlocks.RUBIS_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                                      String pGroup) {

        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                      String pGroup) {

        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup, String pRecipeName) {

        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  FirstMod.MOD_ID + ":" + getItemName(pResult)
                            + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
