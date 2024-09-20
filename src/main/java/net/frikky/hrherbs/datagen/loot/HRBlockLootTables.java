package net.frikky.hrherbs.datagen.loot;

import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class HRBlockLootTables extends BlockLootSubProvider {

    public HRBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(HRBlocks.PLACEHOLDER_BLOCK.get());

        this.add(HRBlocks.MAGNESIUM_ORE.get(),
                block -> createMagnesiumOreDrops(HRBlocks.MAGNESIUM_ORE.get(), HRItems.RAW_MAGNESIUM.get()));



    }

    protected LootTable.Builder createMagnesiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HRBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
