package com.villagerhate.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerType;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieVillagerEntity.class)
public class ZombieVillagerHateMixin {
	@Inject(at = @At("RETURN"), method = "<init>")
	private void initialize(EntityType<? extends ZombieVillagerEntity> entityType, World world, CallbackInfo ci) {
		ZombieVillagerEntity zVillager = (ZombieVillagerEntity) (Object) this;
		zVillager.remove(Entity.RemovalReason.DISCARDED);
	}
}

