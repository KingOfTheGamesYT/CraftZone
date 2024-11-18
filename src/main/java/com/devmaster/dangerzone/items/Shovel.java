package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.ModdedTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.UUID;

public class Shovel extends ShovelItem
{
	protected static final UUID MOVESPEED = UUID.fromString("35f5b798-7778-4017-98f9-ff557dc28f03");
	protected static final UUID REACH = UUID.fromString("168fad76-3979-4638-91c9-a366c0933551");
	protected String name;
	private String[] info = new String[0];
	protected float reach = 0, movespeed = 0, attackspeed = 0;
	protected Multimap<Attribute, AttributeModifier> modifiers;
	protected ItemStack repairitem;
	public int durabilityMultiplier;

	public Shovel(ModdedTier tier, int durabilityMultiplier)
	{
		super(tier, -1, -2.4F, new Properties().group(DangerZone.TOOLS));
		this.repairitem = tier.getRepairItem();
		this.durabilityMultiplier = durabilityMultiplier;  // Set multiplier when registering
	}

	public Shovel build(float reach, float movespeed)
	{
		this.reach = reach;
		this.movespeed = movespeed;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Shovel modifier", (double) getAttackDamage(), Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Shovel modifier", (double) (-2.4f), Operation.ADDITION));
		modifiers = builder.build();
		return this;
	}

	public Shovel rebuild()
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		if (movespeed != 0)
		{
			builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVESPEED, "Shovel modifier", (double) movespeed, Operation.MULTIPLY_TOTAL));
		}
		if (reach != 0)
		{
			builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(REACH, "Shovel modifier", (double) reach, Operation.MULTIPLY_TOTAL));
		}
		modifiers = builder.build();

		return this;
	}

	public Shovel rebuildWith(Attribute attribute, UUID id, String modifiername, double value, Operation valuetype)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		builder.put(attribute, new AttributeModifier(id, modifiername, value, valuetype));
		modifiers = builder.build();
		return this;
	}

	public Shovel addInfo(String... newInfo) {
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