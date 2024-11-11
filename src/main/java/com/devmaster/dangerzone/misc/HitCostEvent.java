package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.items.Armour;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class HitCostEvent {

    // Constructor to register the event handler
    public HitCostEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Listen for LivingHurtEvent
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            // Check the player's armor
            for (ItemStack armorPiece : player.getArmorInventoryList()) {
                if (armorPiece.getItem() instanceof Armour) {
                    Armour armour = (Armour) armorPiece.getItem();

                    // Apply custom durability multiplier
                    int damage = (int) (armour.durabilityMultiplier);
                    armorPiece.damageItem(damage, player, (e) -> {
                        e.sendBreakAnimation(armorPiece.getEquipmentSlot());
                    });
                }
            }
        }
    }
}
