package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.crop.cropblock.AloeCropBlock;
import net.frikky.hrherbs.crop.cropblock.BergamotCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class HRBlockStateProvider extends BlockStateProvider {

    public HRBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HardRockPlants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(HRBlocks.PLACEHOLDER_BLOCK);
        blockWithItem(HRBlocks.MAGNESIUM_ORE);

        makeAloeCrop((CropBlock) HRBlocks.ALOE_CROP.get(), "aloevera_stage", "aloevera_stage");
        makeBergamotCrop((CropBlock) HRBlocks.BERGAMOT_CROP.get(), "bergamot_stage", "bergamot_stage");
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void makeAloeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> aloeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makeBergamotCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> bergamotStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] aloeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((AloeCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((AloeCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] bergamotStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BergamotCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((BergamotCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
}