package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.repository.Pack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = HardRockPlants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HRDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new HRRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), HRLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new HRBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new HRItemModelProvider(packOutput, existingFileHelper));

        HRBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
            new HRBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new HRItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
