package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.items.Armour;

import com.devmaster.dangerzone.items.Pickaxe;
import com.devmaster.dangerzone.items.Sword;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class HitCostEvent {

    // Constructor to register the event handler
    public HitCostEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Listen for LivingAttackEvent (when an entity is hit by another entity)
    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        // Get the attacker (entity that is attacking another entity)
        Entity attacker = event.getSource().getTrueSource();

        // Ensure the attacker is a LivingEntity (this includes players and mobs)
        if (attacker instanceof LivingEntity) {
            LivingEntity livingAttacker = (LivingEntity) attacker;

            applyPickaxeHitCost(livingAttacker);
            // Apply hit cost to the sword
            applySwordHitCost(livingAttacker);
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

        // Check if the item is a custom sword
        if (mainHandItem.getItem() instanceof Pickaxe) {
            Pickaxe pickaxe = (Pickaxe) mainHandItem.getItem();

            // Apply custom durability multiplier (use sword.durabilityMultiplier or your custom logic)
            int damage = (int) (pickaxe.durabilityMultiplier);
            mainHandItem.damageItem(damage, attacker, (e) -> {
                e.sendBreakAnimation(EquipmentSlotType.MAINHAND);  // Break animation if the sword reaches 0 durability
            });
        }
    }
}