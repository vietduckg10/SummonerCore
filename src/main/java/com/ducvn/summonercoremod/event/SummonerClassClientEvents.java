package com.ducvn.summonercoremod.event;

import com.ducvn.summonercoremod.SummonerCoreMod;
import com.ducvn.summonercoremod.tileentity.SummonerCoreTileEntitiesRegister;
import com.ducvn.summonercoremod.tileentity.renderer.EssenceExtractorTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SummonerCoreMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SummonerClassClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ClientRegistry.bindTileEntityRenderer(SummonerCoreTileEntitiesRegister.ESSENCE_EXTRACTOR_TILE.get(), EssenceExtractorTileEntityRenderer::new);
    }
}
