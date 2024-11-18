package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.items.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class HitCostEvent {

    // Constructor to register the event handler
    public HitCostEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        // Get the attacker (entity that is attacking another entity)
        Entity attacker = event.getSource().getTrueSource();

        // Ensure the attacker is a LivingEntity (this includes players and mobs)
        if (attacker instanceof LivingEntity) {
            LivingEntity livingAttacker = (LivingEntity) attacker;

            applyPickaxeHitCost(livingAttacker);
            applyAxeHitCost(livingAttacker);
            applySwordHitCost(livingAttacker);
            applyShovelHitCost(livingAttacker);
            applyHoeHitCost(livingAttacker);
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        // Check if the entity taking damage is a LivingEntity (this includes players and mobs)
        if (event.getEntityLiving() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntityLiving();

            // Apply hit cost to armor
            applyArmorHitCost(entity);
        }
    }

    // Listen for Block Break Event (when a block is broken by a player)
    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        PlayerEntity player = event.getPlayer();

        if (player instanceof PlayerEntity) {

            applyPickaxeHitCost(player);
            applyAxeHitCost(player);
            applySwordHitCost(player);
            applyShovelHitCost(player);
            applyHoeHitCost(player);

        }
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event) {
        PlayerEntity player = event.getPlayer();

        if (player instanceof PlayerEntity) {

            applyHoeHitCost(player);

        }
    }
    // Method to apply the hit cost to armor
    private void applyArmorHitCost(LivingEntity entity) {
        // Iterate over the entity's armor inventory
        for (ItemStack armorPiece : entity.getArmorInventoryList()) {
            if (armorPiece.getItem() instanceof Armour) {
                Armour armour = (Armour) armorPiece.getItem();

                // Apply custom durability multiplier
                int damage = (int) (armour.durabilityMultiplier);
                armorPiece.damageItem(damage, entity, (e) -> {
                    e.sendBreakAnimation(armorPiece.getEquipmentSlot());
                });
            }
        }
    }

    // Method to apply the hit cost to swords when attacking
    private void applySwordHitCost(LivingEntity attacker) {
        ItemStack mainHandItem = attacker.getHeldItemMainhand();  // Get the item in the attacker's main hand

        // Check if the item is a custom sword
        if (mainHandItem.getItem() instanceof Sword) {
            Sword sword = (Sword) mainHandItem.getItem();

            // Apply custom durability multiplier
            int damage = (int) (sword.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);  // Break animation if the sword reaches 0 durability
            });
        }
    }
    private void applyPickaxeHitCost(LivingEntity attacker) {
        ItemStack mainHandItem = attacker.getHeldItemMainhand();  // Get the item in the attacker's main hand

        if (mainHandItem.getItem() instanceof Pickaxe) {
            Pickaxe pickaxe = (Pickaxe) mainHandItem.getItem();

            int damage = (int) (pickaxe.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }
    }
    private void applyAxeHitCost(LivingEntity attacker) {
        ItemStack mainHandItem = attacker.getHeldItemMainhand();  // Get the item in the attacker's main hand

        if (mainHandItem.getItem() instanceof Axe) {
            Axe axe = (Axe) mainHandItem.getItem();

            int damage = (int) (axe.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);  // Break animation if the sword reaches 0 durability
            });
        }
    }
    private void applyShovelHitCost(LivingEntity attacker) {
        ItemStack mainHandItem = attacker.getHeldItemMainhand();  // Get the item in the attacker's main hand

        if (mainHandItem.getItem() instanceof Shovel) {
            Shovel shovel = (Shovel) mainHandItem.getItem();

            int damage = (int) (shovel.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);  // Break animation if the sword reaches 0 durability
            });
        }
    }
    private void applyHoeHitCost(LivingEntity attacker) {
        ItemStack mainHandItem = attacker.getHeldItemMainhand();  // Get the item in the attacker's main hand

        if (mainHandItem.getItem() instanceof Hoe) {
            Hoe hoe = (Hoe) mainHandItem.getItem();

            int damage = (int) (hoe.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }
    }
}