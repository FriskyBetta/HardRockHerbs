package net.frikky.hrherbs.datagen.loot;

import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.crop.cropblock.AloeCropBlock;
import net.frikky.hrherbs.crop.cropblock.BergamotCropBlock;
import net.frikky.hrherbs.crop.cropblock.CloverCropBlock;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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
        this.dropSelf(HRBlocks.MAGNESIUM_ORE.get());


        this.add(HRBlocks.MAGNESIUM_ORE.get(),
                block -> createCopperLikeOreDrops(HRBlocks.MAGNESIUM_ORE.get(), HRItems.RAW_MAGNESIUM.get()));


        LootItemCondition.Builder aloeBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HRBlocks.ALOE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AloeCropBlock.AGE, 5));
        this.add(HRBlocks.ALOE_CROP.get(), createCropDrops(HRBlocks.ALOE_CROP.get(), HRItems.ALOE_VERA.get(),
                HRItems.ALOE_SEEDS.get(), aloeBuilder));

        LootItemCondition.Builder bergamotBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HRBlocks.BERGAMOT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BergamotCropBlock.AGE, 5));
        this.add(HRBlocks.BERGAMOT_CROP.get(), createCropDrops(HRBlocks.BERGAMOT_CROP.get(), HRItems.BERGAMOT.get(),
                HRItems.BERGAMOT_SEEDS.get(), bergamotBuilder));

        LootItemCondition.Builder catnipBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HRBlocks.CATNIP_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BergamotCropBlock.AGE, 5));
        this.add(HRBlocks.CATNIP_CROP.get(), createCropDrops(HRBlocks.CATNIP_CROP.get(), HRItems.CATNIP.get(),
                HRItems.CATNIP_SEEDS.get(), catnipBuilder));

        LootItemCondition.Builder cloverBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HRBlocks.CLOVER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CloverCropBlock.AGE, 5));
        this.add(HRBlocks.CLOVER_CROP.get(), createCropDrops(HRBlocks.CLOVER_CROP.get(), HRItems.CLOVER.get(),
                HRItems.CLOVER_SEEDS.get(), cloverBuilder));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
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