package net.frikky.hrherbs.datagen;

import net.frikky.hrherbs.HardRockPlants;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.crop.cropblock.*;
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
        makeCatnipCrop((CropBlock) HRBlocks.CATNIP_CROP.get(), "catnip_stage", "catnip_stage");
        makeCloverCrop((CropBlock) HRBlocks.CLOVER_CROP.get(), "clover_stage", "clover_stage");
        makeChamCrop((CropBlock) HRBlocks.CHAM_CROP.get(), "cham_stage", "cham_stage");
        makeTumericCrop((CropBlock) HRBlocks.TUMERIC_CROP.get(), "tumeric_stage", "tumeric_stage");
        makePeppermintCrop((CropBlock) HRBlocks.PEPPERMINT_CROP.get(), "peppermint_stage", "peppermint_stage");
        makeThymeCrop((CropBlock) HRBlocks.THYME_CROP.get(), "thyme_stage", "thyme_stage");
        makeLemonBalmCrop((CropBlock) HRBlocks.LEMONBALM_CROP.get(), "lemonbalm_stage", "lemonbalm_stage");
        makeStJonsWortCrop((CropBlock) HRBlocks.STJONSWORT_CROP.get(), "stjonswort_stage", "stjonswort_stage");
        makeRosemaryCrop((CropBlock) HRBlocks.ROSEMARY_CROP.get(), "rosemary_stage", "rosemary_stage");
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
    public void makeCatnipCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> catnipStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeCloverCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cloverStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeChamCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> chamStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeTumericCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> tumericStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makePeppermintCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> peppermintStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeThymeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> thymeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeLemonBalmCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lemonBalmStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeStJonsWortCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> stJonsWortStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    public void makeRosemaryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> rosemaryStates(state, block, modelName, textureName);

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
    private ConfiguredModel[] catnipStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CatnipCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((CatnipCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] cloverStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CloverCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((CloverCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] chamStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ChamCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((ChamCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] tumericStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TumericCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((TumericCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] peppermintStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PeppermintCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((PeppermintCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] thymeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ThymeCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((ThymeCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] lemonBalmStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LemonBalmCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((LemonBalmCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] stJonsWortStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StJonsWortCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((StJonsWortCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
    private ConfiguredModel[] rosemaryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RosemaryCropBlock) block).getAgeProperty()),
                new ResourceLocation(HardRockPlants.MOD_ID, "block/" + textureName + state.getValue(((RosemaryCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));
        return models;
    }
}