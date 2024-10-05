package net.frikky.hrherbs.compat.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.frikky.hrherbs.datagen.HRRecipeProvider;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class HRCraftingCategory implements IRecipeCategory<HRRecipeProvider> {
    @Override
    public RecipeType<HRRecipeProvider> getRecipeType() {
        return null;
    }

    @Override
    public Component getTitle() {
        return null;
    }

    @Override
    public IDrawable getBackground() {
        return null;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return null;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, HRRecipeProvider hrRecipeProvider, IFocusGroup iFocusGroup) {

    }
}
