package com.devmaster.dangerzone.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;


public class Ent extends CreatureEntity {

    public Ent(final EntityType<? extends Ent> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 10;

    }

    @Override
    public void livingTick() {
        super.livingTick();

    }



    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 150)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.ARMOR, 3)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.150)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 10)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 3.5D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 24)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 25);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, StampyLongNose.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, NotBreeBree.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, RedRoseWarrior.class, true));

    }



    public static boolean canEntSpawn(EntityType<? extends Ent> animal, IWorld world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.south()).equals(Blocks.GRASS_BLOCK) && world.canSeeSky(pos);
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    @Override
    protected float getSoundPitch() {
        return 0.7F + rand.nextFloat() * 0.2F;
    }


    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return true;
    }

    @Override
    protected boolean isDespawnPeaceful() {
        return true;
    }




    @Override
    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
    }

    @Override
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
    }
    }