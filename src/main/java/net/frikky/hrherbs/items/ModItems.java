package net.frikky.hrherbs.items;

import net.frikky.hrherbs.HardRockPlants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HardRockPlants.MOD_ID);

    public static final RegistryObject<Item> ALOESEEDS= ITEMS.register("aloe_seeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALOEVERA = ITEMS.register("aloe_vera",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
