package com.ducvn.summonercoremod.utils;

import com.ducvn.summonercoremod.entity.summonedmob.ISummonedEntity;

import java.util.UUID;

public class SummonerClassUtils {
    public static boolean isTheSameMaster(ISummonedEntity targetMob, UUID master){
        return targetMob.getMaster() == master;
    }
}
