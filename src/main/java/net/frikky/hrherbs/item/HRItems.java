package net.frikky.hrherbs.item;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.custom.FertilizerItem;
import net.frikky.hrherbs.custom.HRFoods;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HRItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HardRockPlants.MOD_ID);
//Material Items
    public static final RegistryObject<Item> RAW_MAGNESIUM= ITEMS.register("raw_magnesium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGNESIUM_SULPHATE= ITEMS.register("magnesium_sulphate",
            () -> new FertilizerItem(new Item.Properties()));

//Crop Items
    public static final RegistryObject<Item> ALOE_SEEDS= ITEMS.register("aloe_seeds",
            () -> new ItemNameBlockItem(HRBlocks.ALOE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> ALOE_VERA = ITEMS.register("aloe_vera",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BERGAMOT_SEEDS= ITEMS.register("bergamot_seeds",
            () -> new ItemNameBlockItem(HRBlocks.BERGAMOT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BERGAMOT = ITEMS.register("bergamot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CATNIP_SEEDS= ITEMS.register("catnip_seeds",
            () -> new ItemNameBlockItem(HRBlocks.CATNIP_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CATNIP = ITEMS.register("catnip",
            () -> new Item(new Item.Properties().food(HRFoods.CATNIP)));
    public static final RegistryObject<Item> CLOVER_SEEDS= ITEMS.register("clover_seeds",
            () -> new ItemNameBlockItem(HRBlocks.CLOVER_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CLOVER = ITEMS.register("clover",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAM_SEEDS= ITEMS.register("cham_seeds",
            () -> new ItemNameBlockItem(HRBlocks.CHAM_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHAM = ITEMS.register("cham",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUMERIC_SEEDS= ITEMS.register("tumeric_seeds",
            () -> new ItemNameBlockItem(HRBlocks.TUMERIC_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> TUMERIC = ITEMS.register("tumeric",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEPPERMINT_SEEDS= ITEMS.register("peppermint_seeds",
            () -> new ItemNameBlockItem(HRBlocks.PEPPERMINT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEPPERMINT = ITEMS.register("peppermint",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THYME_SEEDS= ITEMS.register("thyme_seeds",
            () -> new ItemNameBlockItem(HRBlocks.THYME_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEMONBALM_SEEDS= ITEMS.register("lemonbalm_seeds",
            () -> new ItemNameBlockItem(HRBlocks.LEMONBALM_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> STJONSWORT_SEEDS= ITEMS.register("stjonswort_seeds",
            () -> new ItemNameBlockItem(HRBlocks.STJONSWORT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> ROSEMARY_SEEDS= ITEMS.register("rosemary_seeds",
            () -> new ItemNameBlockItem(HRBlocks.ROSEMARY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> THYME = ITEMS.register("thyme",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEMONBALM = ITEMS.register("lemonbalm",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STJONSWORT = ITEMS.register("stjonswort",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSEMARY = ITEMS.register("rosemary",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
