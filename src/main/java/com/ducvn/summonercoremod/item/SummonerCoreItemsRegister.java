package com.ducvn.summonercoremod.item;

import com.ducvn.summonercoremod.SummonerCoreMod;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonerCoreItemsRegister {
    public static final DeferredRegister<Item> SUMMONER_CORE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SummonerCoreMod.MODID);

    public static void init(IEventBus bus){
        SUMMONER_CORE_ITEMS.register(bus);
    }
}
