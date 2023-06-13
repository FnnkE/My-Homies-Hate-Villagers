package com.villagerhate.mixin;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.village.VillagerType;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public class VillagerHateMixin {
	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V")
	private void firstInit(EntityType<? extends VillagerEntity> entityType, World world, CallbackInfo ci) {
		VillagerEntity villager = (VillagerEntity) (Object) this;
		villager.remove(Entity.RemovalReason.DISCARDED);
	}
	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;Lnet/minecraft/village/VillagerType;)V")
	private void secondInit(EntityType<? extends VillagerEntity> entityType, World world, VillagerType type, CallbackInfo ci) {
		VillagerEntity villager = (VillagerEntity) (Object) this;
		villager.remove(Entity.RemovalReason.DISCARDED);
	}
}

