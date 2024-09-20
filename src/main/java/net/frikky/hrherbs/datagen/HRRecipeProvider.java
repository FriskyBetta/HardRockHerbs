package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class HRRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> HARDROCKPLANTS_SMELTABLES = List.of(HRItems.RAW_MAGNESIUM.get(),
            HRBlocks.MAGNESIUM_ORE.get());

    public HRRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, HARDROCKPLANTS_SMELTABLES, RecipeCategory.MISC, HRItems.MAGNESIUM_SULPHATE.get(), 0.25f, 200, "magnesium_sulfate");
        oreBlasting(pWriter, HARDROCKPLANTS_SMELTABLES, RecipeCategory.MISC, HRItems.MAGNESIUM_SULPHATE.get(), 0.25f, 100, "magnesium_sulfate");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HRBlocks.PLACEHOLDER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HRItems.ALOE_VERA.get())
                .unlockedBy(getHasName(HRItems.ALOE_VERA.get()), has(HRItems.ALOE_VERA.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HRItems.ALOE_VERA.get(), 9)
                .requires(HRBlocks.PLACEHOLDER_BLOCK.get())
                .unlockedBy(getHasName(HRBlocks.PLACEHOLDER_BLOCK.get()), has(HRBlocks.PLACEHOLDER_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  HardRockPlants.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}