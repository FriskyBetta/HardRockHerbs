package net.frikky.hrherbs.items;

import net.frikky.hrherbs.HardRockPlants;
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
                        output.accept(ModItems.ALOE_SEEDS.get());
                        output.accept(ModItems.ALOE_VERA.get());
                        output.accept(ModItems.BERGAMOT.get());
                        output.accept(ModItems.BERGAMOT_SEEDS.get());
                        output.accept(ModItems.CATNIP.get());
                        output.accept(ModItems.CATNIP_SEEDS.get());
                        output.accept(ModItems.CLOVER.get());
                        output.accept(ModItems.CLOVER_SEEDS.get());
                    })
                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
