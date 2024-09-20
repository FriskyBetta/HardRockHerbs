package net.frikky.hrherbs.item;

import net.frikky.hrherbs.HardRockPlants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HRItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HardRockPlants.MOD_ID);

    public static final RegistryObject<Item> RAW_MAGNESIUM= ITEMS.register("raw_magnesium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGNESIUM_SULPHATE= ITEMS.register("magnesium_sulphate",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> ALOE_SEEDS= ITEMS.register("aloe_seeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALOE_VERA = ITEMS.register("aloe_vera",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BERGAMOT = ITEMS.register("bergamot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CATNIP = ITEMS.register("catnip",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLOVER = ITEMS.register("clover",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BERGAMOT_SEEDS = ITEMS.register("bergamot_seeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CATNIP_SEEDS = ITEMS.register("catnip_seeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLOVER_SEEDS = ITEMS.register("clover_seeds",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
