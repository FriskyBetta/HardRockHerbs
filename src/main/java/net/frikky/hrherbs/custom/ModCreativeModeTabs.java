package net.frikky.hrherbs.custom;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.blocks.ModBlocks;
import net.frikky.hrherbs.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HardRockPlants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HARDROCK_TAB = CREATIVE_MODE_TABS.register("hardrock_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALOE_VERA.get()))
                    .title(Component.translatable("creativetab.hardrock_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Items
                        output.accept(ModItems.ALOE_SEEDS.get());
                        output.accept(ModItems.ALOE_VERA.get());
                        output.accept(ModItems.BERGAMOT.get());
                        output.accept(ModItems.BERGAMOT_SEEDS.get());
                        output.accept(ModItems.CATNIP.get());
                        output.accept(ModItems.CATNIP_SEEDS.get());
                        output.accept(ModItems.CLOVER.get());
                        output.accept(ModItems.CLOVER_SEEDS.get());

                        //Blocks
                        output.accept(ModBlocks.PLACEHOLDER_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}