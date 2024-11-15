package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.ModdedTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeMod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Sword extends SwordItem
{
	public int durabilityMultiplier;
	protected static final UUID MOVESPEED = UUID.fromString("35f5b798-7778-4017-98f9-ff557dc28f03");
	protected static final UUID REACH = UUID.fromString("168fad76-3979-4638-91c9-a366c0933551");
	protected String name;
	private String[] info = new String[0];
	protected float reach = 0, movespeed = 0, attackspeed = 0;
	protected Multimap<Attribute, AttributeModifier> modifiers;
	protected ItemStack repairitem;
	protected Map<Enchantment, Integer> defaultEnchantments = new HashMap<>();
	// NBT keys to track if the item has received enchantments
	private static final String HAS_ENCHANTS_TAG = "hasEnchants";

	public Sword(ModdedTier tier, int durabilityMultiplier)
	{
		super(tier, -1, -2.4f, new Properties().group(DangerZone.WEAPONS));
		this.repairitem = tier.getRepairItem();
		this.durabilityMultiplier = durabilityMultiplier;  // Set multiplier when registering
	}

	public Sword build(float reach, float movespeed)
	{
		this.reach = reach;
		this.movespeed = movespeed;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Sword modifier", (double) getAttackDamage(), Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Sword modifier", (double) (-2.4f), Operation.ADDITION));
		modifiers = builder.build();
		return this;
	}

	public Sword rebuild()
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		if (movespeed != 0)
		{
			builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVESPEED, "Sword modifier", (double) movespeed, Operation.MULTIPLY_TOTAL));
		}
		if (reach != 0)
		{
			builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(REACH, "Sword modifier", (double) reach, Operation.MULTIPLY_TOTAL));
		}
		modifiers = builder.build();

		return this;
	}

	// Method to add default enchantments when registering the sword
	public Sword addDefaultEnchantment(Enchantment enchantment, int level) {
		this.defaultEnchantments.put(enchantment, level);
		return this;
	}

	// Apply default enchantments when the sword is created or retrieved from the inventory
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		super.onCreated(stack, worldIn, playerIn);
		applyDefaultEnchantments(stack);
	}

	// Adjust inventoryTick to work for any LivingEntity (players, zombies, etc.)
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

		// Apply enchantments if the entity is a LivingEntity (includes players, zombies, etc.)
		if (entityIn instanceof LivingEntity) {
			applyDefaultEnchantments(stack);
		}
	}

	// Apply the default enchantments to the item stack if they are not already present
	private void applyDefaultEnchantments(ItemStack stack) {
		// Check if the enchantments have already been applied by checking the custom NBT tag
		if (stack.hasTag() && stack.getTag().getBoolean(HAS_ENCHANTS_TAG)) {
			return;  // Enchantments already applied, so skip
		}

		// Apply default enchantments
		for (Map.Entry<Enchantment, Integer> entry : defaultEnchantments.entrySet()) {
			Enchantment enchantment = entry.getKey();
			int level = entry.getValue();

			// Add the enchantment to the item
			stack.addEnchantment(enchantment, level);
		}

		// Mark the item with the custom NBT tag to indicate that enchantments have been applied
		stack.getOrCreateTag().putBoolean(HAS_ENCHANTS_TAG, true);
	}

	public Sword rebuildWith(Attribute attribute, UUID id, String modifiername, double value, Operation valuetype)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		builder.put(attribute, new AttributeModifier(id, modifiername, value, valuetype));
		modifiers = builder.build();
		return this;
	}

	public Sword addInfo(String... newInfo) {
		if (newInfo != null && newInfo.length > 0) {
			String[] combinedInfo = new String[this.info.length + newInfo.length];
			System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
			System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
			this.info = combinedInfo;
		}
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> list, ITooltipFlag flagIn){
		for (String s : info) {
			list.add(new StringTextComponent(s));
		}
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot)
	{
		if (slot == EquipmentSlotType.MAINHAND)
		{
			return modifiers;
		}
		return super.getAttributeModifiers(slot);
	}
}