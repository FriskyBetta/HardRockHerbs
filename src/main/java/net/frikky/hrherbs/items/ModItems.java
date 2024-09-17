package net.frikky.hrherbs.items;

import net.frikky.hrherbs.HardRockPlantsMain;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HardRockPlantsMain.MOD_ID);

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
