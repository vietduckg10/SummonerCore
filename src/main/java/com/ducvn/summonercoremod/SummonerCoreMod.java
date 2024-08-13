package com.ducvn.summonercoremod;

import com.ducvn.summonercoremod.block.SummonerCoreBlocksRegister;
import com.ducvn.summonercoremod.config.SummonerCoreConfig;
import com.ducvn.summonercoremod.container.SummonerCoreContainersRegister;
import com.ducvn.summonercoremod.data.recipe.SummonerCoreRecipeTypesRegister;
import com.ducvn.summonercoremod.enchantment.SummonerCoreEnchantmentsRegister;
import com.ducvn.summonercoremod.item.SummonerCoreItemsRegister;
import com.ducvn.summonercoremod.potion.SummonerCorePotionsRegister;
import com.ducvn.summonercoremod.screen.EssenceExtractorScreen;
import com.ducvn.summonercoremod.tileentity.SummonerCoreTileEntitiesRegister;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.UUID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SummonerCoreMod.MODID)
public class SummonerCoreMod
{
    public static final String MODID = "summonercore";
    public static final UUID Summoner_Class_UUID = UUID.fromString("c68688e7-dcf9-4707-af8f-d7b38b902003");

    public SummonerCoreMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register mod stuff :3
        SummonerCoreItemsRegister.init(eventBus);
        SummonerCoreBlocksRegister.init(eventBus);
        SummonerCoreTileEntitiesRegister.init(eventBus);
        SummonerCoreContainersRegister.init(eventBus);
        SummonerCoreRecipeTypesRegister.init(eventBus);
        SummonerCorePotionsRegister.init(eventBus);
        SummonerCoreEnchantmentsRegister.init(eventBus);

        // Register ourselves for server and other game events we are interested in
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SummonerCoreConfig.SPEC, "SummonerClass-common.toml");
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ScreenManager.register(SummonerCoreContainersRegister.ESSENCE_EXTRACTOR_CONTAINER.get(),
                    EssenceExtractorScreen::new);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}
