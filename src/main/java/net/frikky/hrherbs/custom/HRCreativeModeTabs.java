package net.frikky.hrherbs.custom;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class HRCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HardRockPlants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HARDROCK_TAB = CREATIVE_MODE_TABS.register("hardrock_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HRItems.ALOE_VERA.get()))
                    .title(Component.translatable("creativetab.hardrock_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Items
                        output.accept(HRItems.RAW_MAGNESIUM.get());
                        output.accept(HRItems.MAGNESIUM_SULPHATE.get());

                        output.accept(HRItems.ALOE_SEEDS.get());
                        output.accept(HRItems.ALOE_VERA.get());
                        output.accept(HRItems.BERGAMOT_SEEDS.get());
                        output.accept(HRItems.BERGAMOT.get());
                        output.accept(HRItems.CATNIP_SEEDS.get());
                        output.accept(HRItems.CATNIP.get());
                        output.accept(HRItems.CLOVER_SEEDS.get());
                        output.accept(HRItems.CLOVER.get());


                        //Blocks
                        output.accept(HRBlocks.PLACEHOLDER_BLOCK.get());
                        output.accept(HRBlocks.MAGNESIUM_ORE.get());

                    })
                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
