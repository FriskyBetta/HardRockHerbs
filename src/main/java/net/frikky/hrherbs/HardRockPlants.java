package net.frikky.hrherbs;

import com.mojang.logging.LogUtils;
import net.frikky.hrherbs.block.HRBlocks;
import net.frikky.hrherbs.custom.HRCreativeModeTabs;
import net.frikky.hrherbs.item.HRItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HardRockPlants.MOD_ID)
public class HardRockPlants
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hrherbs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public HardRockPlants()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        HRCreativeModeTabs.register(modEventBus);

        HRItems.register(modEventBus);
        HRBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(HRItems.ALOE_SEEDS);
            event.accept(HRItems.ALOE_VERA);
            event.accept(HRItems.BERGAMOT_SEEDS);
            event.accept(HRItems.BERGAMOT);
            event.accept(HRItems.CATNIP_SEEDS);
            event.accept(HRItems.CATNIP);
            event.accept(HRItems.CLOVER_SEEDS);
            event.accept(HRItems.CLOVER);

            event.accept(HRItems.RAW_MAGNESIUM);
            event.accept(HRItems.MAGNESIUM_SULPHATE);


            event.accept(HRBlocks.PLACEHOLDER_BLOCK);
            event.accept(HRBlocks.MAGNESIUM_ORE);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
