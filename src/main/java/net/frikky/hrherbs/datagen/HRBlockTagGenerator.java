package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HRBlockTagGenerator extends BlockTagsProvider {
    public HRBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HardRockPlants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(HRBlocks.PLACEHOLDER_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(HRBlocks.PLACEHOLDER_BLOCK.get(),
                        HRBlocks.PLACEHOLDER_BLOCK.get());

    }
}
