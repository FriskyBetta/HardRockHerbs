package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class HRItemModelProvider extends ItemModelProvider {
    public HRItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HardRockPlants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        hrItem(HRItems.ALOE_SEEDS);
        hrItem(HRItems.ALOE_VERA);
        hrItem(HRItems.BERGAMOT_SEEDS);
        hrItem(HRItems.BERGAMOT);
        hrItem(HRItems.CATNIP_SEEDS);
        hrItem(HRItems.CATNIP);


        hrItem(HRItems.RAW_MAGNESIUM);
        hrItem(HRItems.MAGNESIUM_SULPHATE);


    }

    private ItemModelBuilder hrItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(HardRockPlants.MOD_ID, "item/" + item.getId().getPath()));
    }
}
