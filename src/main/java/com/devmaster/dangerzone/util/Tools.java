package com.devmaster.dangerzone.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;

import java.util.Random;

public class Tools
{
	public static Random r = new Random();

	public static void knockback(Entity entity, BlockPos sourcepoint, float amount)
	{
		double ratiox = sourcepoint.getX() - entity.getPosX();
		double ratioz = sourcepoint.getZ() - entity.getPosZ();
		float strength = amount;

		if (entity instanceof LivingEntity)
		{
			LivingKnockBackEvent event = ForgeHooks.onLivingKnockBack((LivingEntity) entity, amount, ratiox, ratioz);
			if (!event.isCanceled())
			{
				strength = event.getStrength();
				ratiox = event.getRatioX();
				ratioz = event.getRatioZ();
			}
			strength = (float) ((double) strength * (1.0D - ((LivingEntity) entity).getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)));
		}
		if (!(strength <= 0.0F))
		{
			entity.isAirBorne = true;
			Vector3d vector3d = entity.getMotion();
			Vector3d vector3d1 = (new Vector3d(ratiox, 0.0D, ratioz)).normalize().scale((double) strength);
			entity.setMotion(vector3d.x / 2.0D - vector3d1.x, entity.isOnGround() ? Math.min(0.4D, vector3d.y / 2.0D + (double) strength) : vector3d.y, vector3d.z / 2.0D - vector3d1.z);
		}
	}

	public static int countItem(PlayerEntity player, Item item)
	{
		int i = 0;
		for (ItemStack stack : player.inventory.mainInventory)
		{
			if (stack.getItem() == item)
			{
				i += stack.getCount();
			}
		}
		return i;
	}

	public static boolean isHolding(PlayerEntity player, Item item)
	{
		return player.getHeldItemMainhand().getItem() == item || player.getHeldItemOffhand().getItem() == item;
	}

	public static boolean hasItem(PlayerEntity player, Item item, int amount)
	{
		int i = 0;
		for (ItemStack stack : player.inventory.mainInventory)
		{
			if (stack.getItem() == item)
			{
				i += stack.getCount();
				if (i >= amount)
				{
					return true;
				}
			}
		}
		return i >= amount;
	}

	public static ItemStack getItemIfPresent(PlayerEntity player, Item item)
	{
		for (ItemStack stack : player.inventory.mainInventory)
		{
			if (stack.getItem() == item)
			{
				return stack;
			}
		}
		return ItemStack.EMPTY;
	}

	public static boolean handNotEmpty(PlayerEntity player, Hand hand)
	{
		return player.getHeldItem(hand) != null && !player.getHeldItem(hand).isEmpty();
	}

	public static boolean hasEquipped(PlayerEntity player, Item armour)
	{
		for (ItemStack stack : player.getArmorInventoryList())
		{
			if (stack.getItem() == armour)
			{
				return true;
			}
		}
		return false;
	}

	public static ItemStack getIfHolding(PlayerEntity player, Item item)
	{
		if (player.getHeldItemMainhand().getItem() == item)
		{
			return player.getHeldItemMainhand();
		}
		if (player.getHeldItemOffhand().getItem() == item)
		{
			return player.getHeldItemOffhand();
		}
		return ItemStack.EMPTY;
	}

	public static void message(PlayerEntity player, String message)
	{
		if (player.world.isRemote)
		{
			player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		}
	}

	public static void addEffect(LivingEntity entity, Effect effect, int amp, int seconds, boolean showparticles)
	{
		entity.addPotionEffect(new EffectInstance(effect, seconds * 20, amp, !showparticles, showparticles));
	}

	public static void addPlayerModifier(PlayerEntity player, Attribute attribute, AttributeModifier modifier)
	{
		if (!player.getAttribute(attribute).hasModifier(modifier))
		{
			player.getAttribute(attribute).applyPersistentModifier(modifier);
		}
	}

	public static void removePlayerModifier(PlayerEntity player, Attribute attribute, AttributeModifier modifier)
	{
		if (player.getAttribute(attribute).hasModifier(modifier))
		{
			player.getAttribute(attribute).removeModifier(modifier);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void spawnParticles(World world, Random r, double x, double y, double z, IParticleData particle, int amount, double velocity)
	{
		for (int i = 0; i < amount; ++i)
		{
			world.addOptionalParticle(particle, x + r.nextFloat(), y + +r.nextFloat(), z + +r.nextFloat(), (-0.5 + r.nextDouble()) * velocity, (-0.5 + r.nextDouble()) * velocity, (-0.5 + r.nextDouble()) * velocity);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void spawnParticles(Entity target, IParticleData particle, int amount, double velocity)
	{
		spawnParticles(target.world, r, target.getPosX(), target.getPosY(), target.getPosZ(), particle, amount, velocity);
	}

	@OnlyIn(Dist.CLIENT)
	public static void spawnParticles(Entity target, IParticleData particle, int amount)
	{
		spawnParticles(target.world, r, target.getPosX(), target.getPosY(), target.getPosZ(), particle, amount, 1);
	}
}