package com.ducvn.summonercoremod.item;

import com.ducvn.summonercoremod.block.SummonerCoreBlocksRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SummonerCoreItemGroup {
    public static final ItemGroup SUMMONER_CLASS_ITEM_GROUP = new ItemGroup("summonerclass") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SummonerCoreBlocksRegister.ESSENCE_EXTRACTOR.get());
        }
    };
}
