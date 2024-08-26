package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class CatsEyeLeggings extends ArmorItem {
        private static IArmorMaterial iArmorMaterial = new IArmorMaterial() {

    public int getDurability(EquipmentSlotType slotIn) {
        return (Integer) DZConfig.CATS_EYE_LEGGINGS_DURABILITY.get();
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return (Integer) DZConfig.CATS_EYE_LEGGINGS_ARMOR.get();
    }

    @Override
    public int getEnchantability() {
        return (Integer) DZConfig.CATS_EYE_LEGGINGS_ENCHANTABILITY.get();
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(RegistryHandler.CATS_EYE.get());

    }

    @Override
    public String getName() {
        return DangerZone.MOD_ID + ":cats_eye";
    }

    @Override
    public float getToughness() {
        return (Integer) DZConfig.CATS_EYE_LEGGINGS_TOUGHNESS.get();
    }

    @Override
    public float getKnockbackResistance() {
        return (Integer) DZConfig.CATS_EYE_LEGGINGS_KNOCK_BACK_RESISTANCE.get();
    }

};

        public CatsEyeLeggings() {
            super(iArmorMaterial, (EquipmentSlotType.LEGS), (new Properties()).group(DangerZone.ARMOR));
        }

        public void unlockDestroyACH(PlayerEntity entity, World world) {
            if (world instanceof ServerWorld) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
            }
        }


        public boolean HitByEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            stack.damageItem((Integer)DZConfig.CATS_EYE_LEGGINGS_HIT_COST.get(), attacker, (playerEntity) -> {
                if (attacker instanceof MobEntity) {
                    this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
                }

                playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
            return true;
        }

        public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
            tooltip.add(new StringTextComponent("\u00A76" + "Made with real cats eye" + "\u00A76"));
        }
}