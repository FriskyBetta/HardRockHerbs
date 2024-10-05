package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HRItemTagGenerator extends ItemTagsProvider {
    public HRItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, HardRockPlants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        //Crops
        this.tag(Tags.Items.CROPS)
                .add(HRItems.ALOE_VERA.get())
                .add(HRItems.BERGAMOT.get())
                .add(HRItems.CATNIP.get())
                .add(HRItems.CLOVER.get());
    }
}
