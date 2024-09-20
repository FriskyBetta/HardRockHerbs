package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.datagen.loot.HRBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class HRLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(HRBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
