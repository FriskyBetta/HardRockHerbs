package net.frikky.hrherbs.datagen.loot;

import net.frikky.hrherbs.block.HRBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class HRBlockLootTables extends BlockLootSubProvider {

    public HRBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(HRBlocks.PLACEHOLDER_BLOCK.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HRBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
