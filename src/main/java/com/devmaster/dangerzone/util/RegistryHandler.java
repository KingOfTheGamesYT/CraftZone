package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.items.EmeraldPickaxe;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Supplier;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DangerZone.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DangerZone.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerZone.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DangerZone.MOD_ID);
    protected static Random RANDOM = new Random();

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Armor
    public static final RegistryObject<CatsEyeBoots> CATS_EYE_BOOTS = ITEMS.register("cats_eye_boots", CatsEyeBoots::new);
    public static final RegistryObject<CatsEyeChestplate> CATS_EYE_CHESTPLATE = ITEMS.register("cats_eye_chestplate", CatsEyeChestplate::new);
    public static final RegistryObject<CatsEyeHelmet> CATS_EYE_HELMET = ITEMS.register("cats_eye_helmet", CatsEyeHelmet::new);
    public static final RegistryObject<CatsEyeLeggings> CATS_EYE_LEGGINGS = ITEMS.register("cats_eye_leggings", CatsEyeLeggings::new);
    public static final RegistryObject<CoarseAmethystBoots> COARSE_AMETHYST_BOOTS = ITEMS.register("coarse_amethyst_boots", CoarseAmethystBoots::new);
    public static final RegistryObject<CoarseAmethystChestplate> COARSE_AMETHYST_CHESTPLATE = ITEMS.register("coarse_amethyst_chestplate", CoarseAmethystChestplate::new);
    public static final RegistryObject<CoarseAmethystHelmet> COARSE_AMETHYST_HELMET = ITEMS.register("coarse_amethyst_helmet", CoarseAmethystHelmet::new);
    public static final RegistryObject<CoarseAmethystLeggings> COARSE_AMETHYST_LEGGINGS = ITEMS.register("coarse_amethyst_leggings", CoarseAmethystLeggings::new);
    public static final RegistryObject<CopperBoots> COPPER_BOOTS = ITEMS.register("copper_boots", CopperBoots::new);
    public static final RegistryObject<CopperChestplate> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", CopperChestplate::new);
    public static final RegistryObject<CopperHelmet> COPPER_HELMET = ITEMS.register("copper_helmet", CopperHelmet::new);
    public static final RegistryObject<CopperLeggings> COPPER_LEGGINGS = ITEMS.register("copper_leggings", CopperLeggings::new);
    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", EmeraldBoots::new);
    public static final RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", EmeraldChestplate::new);
    public static final RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", EmeraldHelmet::new);
    public static final RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", EmeraldLeggings::new);
    public static final RegistryObject<ExperienceScythe> EXPERIENCE_SCYTHE = ITEMS.register("experience_scythe", ExperienceScythe::new);
    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", LapisBoots::new);
    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", LapisChestplate::new);
    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", LapisHelmet::new);
    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",  LapisLeggings::new);
    public static final RegistryObject<QueenGhidorahScaleBoots> QUEEN_GHIDORAH_SCALE_BOOTS = ITEMS.register("queen_ghidorah_scale_boots", QueenGhidorahScaleBoots::new);
    public static final RegistryObject<QueenGhidorahScaleChestplate> QUEEN_GHIDORAH_SCALE_CHESTPLATE = ITEMS.register("queen_ghidorah_scale_chestplate", QueenGhidorahScaleChestplate::new);
    public static final RegistryObject<QueenGhidorahScaleHelmet> QUEEN_GHIDORAH_SCALE_HELMET = ITEMS.register("queen_ghidorah_scale_helmet", QueenGhidorahScaleHelmet::new);
    public static final RegistryObject<QueenGhidorahScaleLeggings> QUEEN_GHIDORAH_SCALE_LEGGINGS = ITEMS.register("queen_ghidorah_scale_leggings", QueenGhidorahScaleLeggings::new);
    public static final RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", SapphireBoots::new);
    public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", SapphireChestplate::new);
    public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", SapphireHelmet::new);
    public static final RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", SapphireLeggings::new);
    public static final RegistryObject<TitaniumBoots> TITANIUM_BOOTS = ITEMS.register("titanium_boots", TitaniumBoots::new);
    public static final RegistryObject<TitaniumChestplate> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", TitaniumChestplate::new);
    public static final RegistryObject<TitaniumHelmet> TITANIUM_HELMET = ITEMS.register("titanium_helmet", TitaniumHelmet::new);
    public static final RegistryObject<TitaniumLeggings> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", TitaniumLeggings::new);

    //Blocks
    public static final RegistryObject<Block> ABYSSAL_ORE_BLOCK = registerNormalBlock("abyssal_ore_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,10F).harvestLevel(0).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE), 0).addInfo("\u00A75" + "This is everywhere" + "\u00A75"));
    public static final RegistryObject<Block> ABYSSAL_ORE_VERTICAL_SLAB = conditionallyRegisterBlock("abyssal_ore_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.from(Blocks.STONE_SLAB)), () -> isLoaded("quark"));
    public static final RegistryObject<Block> ADAMANTINE_BLOCK = registerNormalBlock("adamantine_block", () -> new ABlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance( 5F,10F).harvestLevel(4).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 0).addInfo("\u00A74" + "Wolverine " + "\u00A74"));
    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registerNormalBlock("aluminium_block", () -> new ABlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance( 4F,3F).setLightLevel(state -> 6).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 0).addInfo("\u00A7f" + "Aluminium blocks are pretty lightweight!" + "\u00A7f"));
    public static final RegistryObject<Block> ALUMINIUM_ORE_BLOCK = registerWIPBlock("aluminium_ore_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 500F,20F).harvestLevel(35).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE), 0).addInfo("\u00A7f" + "Worse than Iron but does the trick!" + "\u00A7f"));
    public static final RegistryObject<Block> APPLE_BLOCK =registerNormalBlock("apple_block", () -> new ABlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance( 1F,1F).harvestLevel(1).sound(SoundType.PLANT), 0).addInfo("\u00A7c" + "so red, so wonderful" + "\u00A7c"));
    public static final RegistryObject<Block> APPLE_LEAVES = registerWIPBlock("apple_leaves", AppleLeaves::new);
    public static final RegistryObject<Block> APPLE_LOG = registerWIPBlock("apple_log", () -> new ABlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance( 2F,2F).harvestLevel(0).harvestTool(ToolType.AXE).sound(SoundType.WOOD), 0).addInfo("\u00A76" + "The log doesn't give apples you fool" + "\u00A76"));
    public static final RegistryObject<Block> BLOODSTONE_BLOCK = registerWIPBlock("bloodstone_block", () -> new ABlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance( 4F,3F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.METAL), 0).addInfo("\u00A74" + "for when you have to much bloodstone" + "\u00A74"));
    public static final RegistryObject<Block> BROWN_BLOCK =registerNormalBlock("brown_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 1F,1F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE), 0).addInfo("\u00A76" + "A brown solid to build with" + "\u00A76"));
    public static final RegistryObject<Block> CATS_EYE_BLOCK = registerNormalBlock("cats_eye_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 8.5F,12F).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.METAL).setLightLevel(state -> 5), 0).addInfo("\u00A76" + "A block of eyes" + "\u00A76"));
    public static final RegistryObject<Block> CATS_EYE_ORE = registerNormalBlock("cats_eye_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 4.0F,3.25F).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE), 2 + RANDOM.nextInt(8)).addInfo("\u00A76" + "It meows" + "\u00A76"));
    public static final RegistryObject<Block> COARSE_AMETHYST_BLOCK = registerNormalBlock("coarse_amethyst_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 4.0F,12.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().setLightLevel(state -> 4).sound(SoundType.METAL), 0).addInfo("\u00A75" + "Coarse Amethyst blocks are seriously purple!" + "\u00A75"));
    public static final RegistryObject<Block> COARSE_AMETHYST_ORE_BLOCK = registerNormalBlock("coarse_amethyst_ore_block", CoarseAmethystOreBlock::new);
    public static final RegistryObject<Block> COMPRESSED_POPPY_BLOCK = registerNormalBlock("compressed_poppy_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 0.5F,1.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.GROUND), 0).addInfo("\u00A74" + "A wonderful way to store all those poppies" + "\u00A74"));
    public static final RegistryObject<Block> CRYSTAL_GRASS = registerNormalBlock("crystal_grass", CrystalGrass::new);
    public static final RegistryObject<Block> DARK_BROWN_BLOCK = registerNormalBlock("dark_brown_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 1.0F,1.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE), 0).addInfo("\u00A76" + "Look like poop, doesn't smell like it or taste like it though" + "\u00A76"));
    public static final RegistryObject<Block> DARK_ORANGE_BLOCK = registerNormalBlock("dark_orange_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 1.0F,1.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE), 0).addInfo("\u00A76" + "Not annoying" + "\u00A7"));
    public static final RegistryObject<Block> DARK_RED_BLOCK = registerNormalBlock("dark_red_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 1.0F,1.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE), 0).addInfo("\u00A74" + "We are built with this" + "\u00A74"));
    public static final RegistryObject<Block> HEART_BLOCK = registerWIPBlock("heart_block", () -> new ABlock(AbstractBlock.Properties.create(Material.SAND).hardnessAndResistance( 0.6F).sound(SoundType.GROUND), 0).addInfo("\u00A7f" + "This block loves you" + "\u00A7f"));
    public static final RegistryObject<Block> KYANITE = registerNormalBlock("kyanite", Kyanite::new);
    public static final RegistryObject<Block> LEATHER_BLOCK = registerNormalBlock("leather_block", () -> new ABlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(1.0F, 1.0F).sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_BREAK.get().getRegistryName()), () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_STEP.get().getRegistryName()), () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_PLACE.get().getRegistryName()), () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_HIT.get().getRegistryName()), () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_PLACE.get().getRegistryName()))).harvestLevel(1), 0).addInfo("\u00A76" + "What a great place to store all that leather" + "\u00A76"));
    public static final RegistryObject<Block> ORANGE_BLOCK = registerNormalBlock("orange_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0).addInfo("\u00A76" + "Not a trumpet" + "\u00A76"));
    public static final RegistryObject<Block> PLAY_BUTTON_ORE_BLOCK = registerNormalBlock("play_button_ore_block", PlayButtonOreBlock::new);
    public static final RegistryObject<Block> RED_BLOCK = registerNormalBlock("red_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0).addInfo("\u00A7c" + "Best color" + "\u00A7c"));
    public static final RegistryObject<Block> RANDOM_STRUCTURE_BLOCK = registerNormalBlock("random_structure_spawner", RandomStructureBlock::new);
    public static final RegistryObject<Block> SALT_ORE_BLOCK = registerNormalBlock("salt_ore_block", SaltOreBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerNormalBlock("sapphire_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0).addInfo("\u00A79" + "Sapphire blocks are seriously blue!" + "\u00A79"));
    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = registerNormalBlock("sapphire_ore_block", SapphireOreBlock::new);
    public static final RegistryObject<Block> STICKY_BLOCK = registerNormalBlock("sticky_block", StickyBlock::new);
    public static final RegistryObject<Block> TERMITE_TROLL_ORE = registerNormalBlock("termite_troll_ore_block", TermiteTrollOre::new);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerNormalBlock("titanium_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().setLightLevel(state -> 5), 0).addInfo("\u00A7b" +  "For the person who just has too much Titanium" + "\u00A7b"));
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = registerNormalBlock("titanium_ore_block", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(15.0F, 5.0F).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0).addInfo("\u00A7b" + "Oh yeah! Get excited! You're on your way to crafting something Ultimate! This is what you've been looking for! Smelt these to get Titanium Nuggets." + "\u00A7b"));
    public static final RegistryObject<Block> URANIUM_BLOCK = registerWIPBlock("uranium_block",() -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().setLightLevel(state -> 2), 0).addInfo("\u00A7e" + "Make a nice yellow block!" + "\u00A7e"));

    //Block Items
    private static <T extends Block> RegistryObject<T> registerNormalBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerNormalBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerNormalBlockItem(String name, RegistryObject<T> block) {
        return RegistryHandler.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(DangerZone.BLOCKS)));
    }
    private static <T extends Block> RegistryObject<T> registerWIPBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerWIPBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerPetrifiedBlockItem(String name, RegistryObject<T> block) {
        return RegistryHandler.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(DangerZone.PETRIFIED_ORES)));
    }
    private static <T extends Block> RegistryObject<T> registerPetrifiedBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerPetrifiedBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerWIPBlockItem(String name, RegistryObject<T> block) {
        return RegistryHandler.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(DangerZone.WIP)));
    }

    //Dimensions
    public static final RegistryKey<World> DANGER = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "danger"));

    public static final RegistryKey<World> VILLAGES = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "villages"));

    public static final RegistryKey<World> CRYSTAL = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "crystal"));

    public static final RegistryKey<World> PAST = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "past"));

    //Entities
    public static final RegistryObject<EntityType<AlexiCraft>> ALEXICRAFT = ENTITIES
            .register("alexicraft",
                    () -> EntityType.Builder.<AlexiCraft>create(AlexiCraft::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "alexicraft").toString()));

    public static final RegistryObject<EntityType<Allosaurus>> ALLOSAURUS = ENTITIES
            .register("allosaurus",
                    () -> EntityType.Builder.<Allosaurus>create(Allosaurus::new, EntityClassification.MONSTER)
                            .size(1.0f, 0.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "allosaurus").toString()));

    public static final RegistryObject<EntityType<AntVenom>> ANTVENOM = ENTITIES
            .register("antvenom",
                    () -> EntityType.Builder.<AntVenom>create(AntVenom::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "antvenom").toString()));

    public static final RegistryObject<EntityType<Aphmau>> APHMAU = ENTITIES
            .register("aphmau",
                    () -> EntityType.Builder.<Aphmau>create(Aphmau::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "aphmau").toString()));

    public static final RegistryObject<EntityType<AttackSquid>> ATTACK_SQUID = ENTITIES
            .register("attack_squid",
                    () -> EntityType.Builder.<AttackSquid>create(AttackSquid::new, EntityClassification.WATER_CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "attack_squid").toString()));

    public static final RegistryObject<EntityType<BabyAngel>> BABYANGEL = ENTITIES
            .register("babyangel",
                    () -> EntityType.Builder.<BabyAngel>create(BabyAngel::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyangel").toString()));

    public static final RegistryObject<EntityType<BabyDuck>> BABYDUCK = ENTITIES
            .register("babyduck",
                    () -> EntityType.Builder.<BabyDuck>create(BabyDuck::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyduckl").toString()));

    public static final RegistryObject<EntityType<BabyLeah>> BABYLEAH = ENTITIES
            .register("babyleah",
                    () -> EntityType.Builder.<BabyLeah>create(BabyLeah::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyleah").toString()));

    public static final RegistryObject<EntityType<BabyMax>> BABYMAX = ENTITIES
            .register("babymax",
                    () -> EntityType.Builder.<BabyMax>create(BabyMax::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babymax").toString()));

    public static final RegistryObject<EntityType<BajanCanadian>> BAJANCANADIAN = ENTITIES
            .register("bajancanadian",
                    () -> EntityType.Builder.<BajanCanadian>create(BajanCanadian::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "bajancanadian").toString()));

    public static final RegistryObject<EntityType<BetterFireball>> BETTER_FIREBALL = ENTITIES
            .register("better_fireball",
                    () ->  EntityType.Builder.<BetterFireball>create(BetterFireball::new, EntityClassification.MISC)
                            .size(1.0F, 1.0F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "better_fireball").toString()));
    public static final RegistryObject<EntityType<Bird>> BIRD = ENTITIES
            .register("bird",
                    () -> EntityType.Builder.<Bird>create(Bird::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "bird").toString()));

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES
            .register("butterfly",
                    () -> EntityType.Builder.<Butterfly>create(Butterfly::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "butterfly").toString()));

    public static final RegistryObject<EntityType<CaptainSparkelz>> CAPTAINSPARKELZ = ENTITIES
            .register("captainsparkelz",
                    () -> EntityType.Builder.<CaptainSparkelz>create(CaptainSparkelz::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "captainsparkelz").toString()));

    public static final RegistryObject<EntityType<CaveFisher>> CAVE_FISHER = ENTITIES
            .register("cave_fisher",
                    () -> EntityType.Builder.<CaveFisher>create(CaveFisher::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "cave_fisher").toString()));

    public static final RegistryObject<EntityType<EasterBunny>> EASTER_BUNNY = ENTITIES
            .register("easter_bunny",
                    () -> EntityType.Builder.<EasterBunny>create(EasterBunny::new, EntityClassification.CREATURE)
                            .size(1.0F, 1.2F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "easter_bunny").toString()));

    public static final RegistryObject<EntityType<Ent>> ENT = ENTITIES
            .register("ent",
                    () -> EntityType.Builder.<Ent>create(Ent::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "ent").toString()));

    public static final RegistryObject<EntityType<Godzilla>> GODZILLA = ENTITIES
            .register("godzilla",
                    () -> EntityType.Builder.<Godzilla>create(Godzilla::new, EntityClassification.CREATURE)
                            .size(9.9F, 5.05F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "godzilla").toString()));

  /*  public static final RegistryObject<EntityType<Hydrolisc>> HYDROLISC = ENTITIES
            .register("hydrolisc",
                    () -> EntityType.Builder.<Hydrolisc>create(Hydrolisc::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "hydrolisc").toString())); */

    public static final RegistryObject<EntityType<Mermaid>> MERMAID = ENTITIES
            .register("mermaid",
                    () -> EntityType.Builder.<Mermaid>create(Mermaid::new, EntityClassification.WATER_CREATURE)
                            .size(0.9f, 1.7f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "mermaid").toString()));

    public static final RegistryObject<EntityType<NotBreeBree>> NOTBREEBREE = ENTITIES
            .register("notbreebree",
                    () -> EntityType.Builder.<NotBreeBree>create(NotBreeBree::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "notbreebree").toString()));

    public static final RegistryObject<EntityType<RainbowAnt>> RAINBOWANT = ENTITIES
            .register("rainbow_ant",
                    () -> EntityType.Builder.<RainbowAnt>create(RainbowAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "rainbow_ant").toString()));

    public static final RegistryObject<EntityType<RedAnt>> RED_ANT = ENTITIES
            .register("red_ant",
                    () -> EntityType.Builder.<RedAnt>create(RedAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "red_ant").toString()));

    public static final RegistryObject<EntityType<RedCow>> RED_COW = ENTITIES
            .register("red_cow",
                    () -> EntityType.Builder.<RedCow>create(RedCow::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.45f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "red_cow").toString()));

    public static final RegistryObject<EntityType<RedRoseWarrior>> REDROSEWARRIOR = ENTITIES
            .register("redrosewarrior",
                    () -> EntityType.Builder.<RedRoseWarrior>create(RedRoseWarrior::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "redrosewarrior").toString()));

    public static final RegistryObject<EntityType<RoboTechnoblade>> ROBO_TECHNOBLADE = ENTITIES
            .register("robo_technoblade",
                    () -> EntityType.Builder.<RoboTechnoblade>create(RoboTechnoblade::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "robo_technoblade").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "stampylongnose").toString()));

    public static final RegistryObject<EntityType<Technoblade>> TECHNOBLADE = ENTITIES
            .register("technoblade",
                    () -> EntityType.Builder.<Technoblade>create(Technoblade::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "technoblade").toString()));

   public static final RegistryObject<EntityType<Termite>> TERMITE = ENTITIES
            .register("termite",
                    () -> EntityType.Builder.<Termite>create(Termite::new, EntityClassification.CREATURE)
                            .size(0.9f, .9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "termite").toString()));

    public static final RegistryObject<EntityType<Tewtiy>> TEWTIY = ENTITIES
            .register("tewtiy",
                    () -> EntityType.Builder.<Tewtiy>create(Tewtiy::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<WaterProjectile>> WATER_PROJECTILE = ENTITIES
            .register("water_projectile",
                    () -> EntityType.Builder.<WaterProjectile>create(WaterProjectile::new, EntityClassification.MISC)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "water_projectile").toString()));
    //Item

    public static final RegistryObject<Item> ALLOSAURUS_TOOTH = ITEMS.register("allosaurus_tooth", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "They don't wash their teeth" + "\u00A7f"));
    public static final RegistryObject<Item> ALUMINIUM = ITEMS.register("aluminium_ingot",() -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "A lightweight ingot"));
    public static final RegistryObject<Item> ALUMINIUM_LUMP = ITEMS.register("aluminium_lump", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "A lightweight lump" + "\u00A7f"));
    public static final RegistryObject<Item> APPLE_SEED = ITEMS.register("apple_seed", () -> new AItem(DangerZone.WIP).addInfo("\u00A76" +"Apples come to life!" + "\u00A76"));
    public static final RegistryObject<Item> BASILISK_SCALE = ITEMS.register("basilisk_scale",() -> new AItem(DangerZone.TAB).addInfo("\u00A72" + "This is your badge of honor." + "\u00A72"));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "Don't put it in your ear" + "\u00A7f"));
    public static final RegistryObject<Item> BLOODSTONE = ITEMS.register("bloodstone", () -> new AItem(DangerZone.TAB).addInfo("\u00A74" + "Might be useful some day. Until then, it's still pretty cool!" + "\u00A74"));
    public static final RegistryObject<BLT> BLT = ITEMS.register("blt", BLT::new);
    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);
    public static final RegistryObject<ButterCandy> BUTTER_CANDY = ITEMS.register("butter_candy", ButterCandy::new);
    public static final RegistryObject<CandyCane> CANDY_CANE = ITEMS.register("candy_cane", CandyCane::new);
    public static final RegistryObject<Item> CATS_EYE = ITEMS.register("cats_eye", () -> new AItem(DangerZone.TAB).addInfo("\u00A76" + "Cats are connoisseurs of comfort" + "\u00A76"));
    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);
    public static final RegistryObject<Item> COARSE_AMETHYST = ITEMS.register("coarse_amethyst", () -> new AItem(DangerZone.TAB).addInfo("\u00A75" + "They make some pretty cool Coarse Amethyst Tools & a Coarse Amethyst Sword, you can also make Coarse Amethyst Armor" + "\u00A75"));
    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);
    public static final RegistryObject<Item> COPPER_LUMP = ITEMS.register("copper_lump", () -> new AItem(DangerZone.TAB).addInfo("\u00A76" + "Makes some of the worst armor in the game" + "\u00A76"));
    public static final RegistryObject<Item> CRITTER_CAGE = ITEMS.register("critter_cage", () -> new AItem(DangerZone.TAB).addInfo("\u00A78" + "Critter Cages only work about 80% of the time. You may have to throw more than one. And yes, they catch all types of critters. Handy against creepers. Just throw one at an entity to catch it. Right click it on the ground to release the captured critter. Yes, they work on big critters too, but very rarely.\n" + "\u00A78"));
    public static final RegistryObject<CrystalApple> CRYSTAL_APPLE = ITEMS.register("crystal_apple", CrystalApple::new);
    public static final RegistryObject<Item> CZ_LOIN_COIN = ITEMS.register("cz_loin_coin", () -> new AItem(DangerZone.TAB).addInfo("\u00A7e" + "Wait isn't this AdventureKraft?" + "\u00A7e"));
    public static final RegistryObject<DeadRainbowAnt> DEAD_RAINBOW_ANT = ITEMS.register("dead_rainbow_ant", DeadRainbowAnt::new);
    public static final RegistryObject<DeadTermite> DEAD_TERMITE = ITEMS.register("dead_termite", DeadTermite::new);
    public static final RegistryObject<StairItem> INSTANT_BRIDGE = ITEMS.register("instant_bridge", StairItem::new);
    public static final RegistryObject<StairItem> INSTANT_STAIRS_UP = ITEMS.register("instant_stairs_up", StairItem::new);
    public static final RegistryObject<StairItem> INSTANT_STAIRS_DOWN = ITEMS.register("instant_stairs_down", StairItem::new);
    public static final RegistryObject<Item> KING_GHIDORAH_SCALE = ITEMS.register("king_ghidorah_scale", () -> new AItem(DangerZone.TAB).addInfo("\u00A76" + "Makes the gear of kings" + "\u00A76"));
    public static final RegistryObject<MinersDreamItem> MINERS_DREAM = ITEMS.register("miners_dream", MinersDreamItem::new);
    public static final RegistryObject<Item> MITHRIL_LUMP = ITEMS.register("mithril_lump", () -> new AItem(DangerZone.TAB).addInfo("\u00A73" + "A Mythical Lump" + "\u00A73"));
    public static final RegistryObject<Popcorn> POPCORN = ITEMS.register("popcorn", Popcorn::new);
    public static final RegistryObject<Item> QUEEN_GHIDORAH_SCALE = ITEMS.register("queen_ghidorah_scale", () -> new AItem(DangerZone.TAB).addInfo("\u00A75" + "Makes the gear of Queens" + "\u00A75"));
    public static final RegistryObject<Item> RAINBOW_ANT_ABDOMEN = ITEMS.register("rainbow_ant_abdomen", () -> new AItem(DangerZone.TAB).addInfo("\u00A7e" + "Wiggle Wiggle" + "\u00A7e"));
    public static final RegistryObject<Item> RAINBOW_ANT_EYE = ITEMS.register("rainbow_ant_eye", () -> new AItem(DangerZone.TAB).addInfo("\u00A7C" + "oh gross" + "\u00A7C"));
    public static final RegistryObject<Item> RAINBOW_ANT_LEG = ITEMS.register("rainbow_ant_leg", () -> new AItem(DangerZone.TAB).addInfo("\u00A72" + "It's still moving!!!!" + "\u00A72"));
    public static final RegistryObject<RainbowAntToken> RAINBOW_ANT_TOKEN = ITEMS.register("rainbow_ant_token", RainbowAntToken::new);
    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);
    public static final RegistryObject<Item> RED_ANT_EYE = ITEMS.register("red_ant_eye", () -> new AItem(DangerZone.TAB).addInfo("\u00A7c" + "Not Ice Cream" + "\u00A7c"));
    public static final RegistryObject<RedAntToken> RED_ANT_TOKEN = ITEMS.register("red_ant_token", RedAntToken::new);
    public static final RegistryObject<Item> ROBOT_FINGER = ITEMS.register("robot_finger", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "It's rude to point" + "\u00A7f"));
    public static final RegistryObject<Item> ROBOT_HAND = ITEMS.register("robot_hand", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "Used to make your own droid" + "\u00A7f"));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new AItem(DangerZone.TAB).addInfo("\u00A7f" + "Put a salt block in the furnace and add some salt to your food! Forget what the doctors say, this is Minecraft! :)" + "\u00A7f"));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new AItem(DangerZone.TAB).addInfo("\u00A79" + "They make some pretty Sapphire Tools & weapons" + "\u00A79"));
    public static final RegistryObject<Item> STONE_RUNE = ITEMS.register("stone_rune", () -> new AItem(DangerZone.TAB).addInfo("\u00A77" + "Which path will you take?" + "\u00A77"));
    public static final RegistryObject<Item> TERMITE_ABDOMEN = ITEMS.register("termite_abdomen", () -> new AItem(DangerZone.TAB).addInfo("\u00A77" + "It's gross" + "\u00A77"));
    public static final RegistryObject<Item> TERMITE_EYE = ITEMS.register("termite_eye", () -> new AItem(DangerZone.TAB).addInfo("\u00A77" + "It's a demon eye" + "\u00A77"));
    public static final RegistryObject<Item> TERMITE_LEG = ITEMS.register("termite_leg", () -> new AItem(DangerZone.TAB).addInfo("\u00A70" + "It's dirty!" + "\u00A70"));
    public static final RegistryObject<TermiteToken> TERMITE_TOKEN = ITEMS.register("termite_token", TermiteToken::new);
    public static final RegistryObject<Item> TITANIUM_CAKE = ITEMS.register("titanium_cake", TitaniumCake::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new AItem(DangerZone.TAB).addInfo("\u00A7b" + "I am Titanium" + "\u00A7b"));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new AItem(DangerZone.TAB).addInfo("\u00A7b" + "Titanium Nuggets are smelted from Titanium Ore. You'll needs lots of them to have earned the Ultimate Sword!" + "\u00A7b"));
    public static final RegistryObject<Item> WATER_DRAGON_SCALE = ITEMS.register("water_dragon_scale", () -> new AItem(DangerZone.TAB).addInfo("\u00A7b" + "Dropped by the Water Dragon." + "\u00A7b"));
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", Wrench::new);

    //Petrified Mob blocks
    public static final RegistryObject<Block> BUTTERFLY_EGG_ORE = registerPetrifiedBlock("butterfly_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> GODZILLA_EGG_ORE = registerPetrifiedBlock("godzilla_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> GUARDIAN_EGG_ORE = registerPetrifiedBlock("guardian_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> MAGMA_CUBE_EGG_ORE = registerPetrifiedBlock("magma_cube_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> MUTANT_ZOMBIE_EGG_ORE = registerPetrifiedBlock("mutant_zombie_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> RAINBOW_ANT_EGG_ORE = registerPetrifiedBlock("rainbow_ant_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> REDROSEWARRIOR_EGG_ORE = registerPetrifiedBlock("redrosewarrior_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> STAMPYLONGNOSE_EGG_ORE = registerPetrifiedBlock("petrified_stampylongnose_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> TERMITE_EGG_ORE = registerPetrifiedBlock("termite_egg_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> TEWTIY_EGG_ORE = registerPetrifiedBlock("petrified_tewtiy_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));
    public static final RegistryObject<Block> ZOMBIE_EGG_ORE = registerPetrifiedBlock("petrified_zombie_ore", () -> new ABlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance( 2F,2F).harvestLevel(2).sound(SoundType.STONE).setRequiresTool(), 0));

    //Spawn Eggs
    public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = ITEMS.register("allosaurus_spawn_egg", () -> new SpawnEgg(RegistryHandler.ALLOSAURUS, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> ATTACK_SQUID_SPAWN_EGG = ITEMS.register("attack_squid_spawn_egg", () -> new SpawnEgg(RegistryHandler.ATTACK_SQUID, 0, 0,new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> BEAVER_SPAWN_EGG = ITEMS.register("beaver_spawn_egg", BeaverSpawnEgg::new);
    public static final RegistryObject<Item> BIRD_SPAWN_EGG = ITEMS.register("bird_spawn_egg", () -> new SpawnEgg(RegistryHandler.BIRD, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> BUTTERFLY_SPAWN_EGG = ITEMS.register("butterfly_spawn_egg", () -> new SpawnEgg(RegistryHandler.BUTTERFLY, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> EASTER_BUNNY_SPAWN_EGG = ITEMS.register("easter_bunny_spawn_egg", () -> new SpawnEgg(RegistryHandler.EASTER_BUNNY, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> ENT_SPAWN_EGG = ITEMS.register("ent_spawn_egg", () -> new SpawnEgg(RegistryHandler.ENT, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> FIRE_FISH_SPAWN_EGG = ITEMS.register("fire_fish_spawn_egg", FireFishSpawnEgg::new);
    public static final RegistryObject<Item> GODZILLA_SPAWN_EGG = ITEMS.register("godzilla_spawn_egg", () -> new SpawnEgg(RegistryHandler.GODZILLA, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = ITEMS.register("iron_golem_spawn_egg", () -> new SpawnEgg(EntityType.IRON_GOLEM, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", () -> new SpawnEgg(RegistryHandler.MERMAID, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> MOLDY_SPAWN_EGG = ITEMS.register("moldy_spawn_egg", MoldySpawnEgg::new);
    public static final RegistryObject<SpawnEgg> NOTBREEBREE_SPAWN_EGG = ITEMS.register("notbreebree_spawn_egg", () -> new SpawnEgg(RegistryHandler.NOTBREEBREE, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> RAINBOW_ANT_SPAWN_EGG = ITEMS.register("rainbow_ant_spawn_egg", () -> new SpawnEgg(RegistryHandler.RAINBOWANT, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> RED_ANT_SPAWN_EGG = ITEMS.register("red_ant_spawn_egg", () -> new SpawnEgg(RegistryHandler.RED_ANT, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> RED_COW_SPAWN_EGG = ITEMS.register("red_cow_spawn_egg", () -> new SpawnEgg(RegistryHandler.RED_COW, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> REDROSEWARRIOR_SPAWN_EGG = ITEMS.register("redrosewarrior_spawn_egg", () -> new SpawnEgg(RegistryHandler.REDROSEWARRIOR, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> ROBO_BOMB_SPAWN_EGG = ITEMS.register("robo-bomb_spawn_egg", RoboBombSpawnEgg::new);
    public static final RegistryObject<Item> SCORPION_SPAWN_EGG = ITEMS.register("scorpion_spawn_egg", ScorpionSpawnEgg::new);
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg", () -> new SpawnEgg(EntityType.SNOW_GOLEM, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> STAMPYLONGNOSE_SPAWN_EGG = ITEMS.register("stampylongnose_spawn_egg", () -> new SpawnEgg(RegistryHandler.STAMPYLONGNOSE, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> TECHNOBLADE_SPAWN_EGG = ITEMS.register("technoblade_spawn_egg", () -> new SpawnEgg(RegistryHandler.TECHNOBLADE, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> TERMITE_SPAWN_EGG = ITEMS.register("termite_spawn_egg", () -> new SpawnEgg(RegistryHandler.TERMITE, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> TEWTIY_SPAWN_EGG = ITEMS.register("tewtiy_spawn_egg", () -> new SpawnEgg(RegistryHandler.TEWTIY, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> TREX_SPAWN_EGG = ITEMS.register("trex_spawn_egg", TrexSpawnEgg::new);

    //Tools and Weapons

    public static final RegistryObject<CoarseAmethystAxe> COARSE_AMETHYST_AXE = ITEMS.register("coarse_amethyst_axe", CoarseAmethystAxe::new);
    public static final RegistryObject<CoarseAmethystHoe> COARSE_AMETHYST_HOE = ITEMS.register("coarse_amethyst_hoe", CoarseAmethystHoe::new);
    public static final RegistryObject<CoarseAmethystPickaxe> COARSE_AMETHYST_PICKAXE = ITEMS.register("coarse_amethyst_pickaxe", CoarseAmethystPickaxe::new);
    public static final RegistryObject<CoarseAmethystShovel> COARSE_AMETHYST_SHOVEL = ITEMS.register("coarse_amethyst_shovel", CoarseAmethystShovel::new);
    public static final RegistryObject<CoarseAmethystSword> COARSE_AMETHYST_SWORD = ITEMS.register("coarse_amethyst_sword", CoarseAmethystSword::new);
    public static final RegistryObject<CakeSword> CAKE_SWORD = ITEMS.register("cake_sword", CakeSword::new);
    public static final RegistryObject<EmeraldAxe> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);
    public static final RegistryObject<EmeraldHoe> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);
    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);
    public static final RegistryObject<EmeraldShovel> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);
    public static final RegistryObject<EmeraldSword> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);
    public static final RegistryObject<Hammy> HAMMY = ITEMS.register("hammy", Hammy::new);
    public static final RegistryObject<MantisClaw> MANTIS_CLAW = ITEMS.register("mantis_claw", MantisClaw::new);
    public static final RegistryObject<PoppySword> POPPY_SWORD = ITEMS.register("poppy_sword", PoppySword::new);
    public static final RegistryObject<QueenGhidorahScaleBattleAxe> QUEEN_GHIDORAH_SCALE_BATTLE_AXE = ITEMS.register("queen_ghidorah_scale_battle_axe", QueenGhidorahScaleBattleAxe::new);
    public static final RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", SapphireAxe::new);
    public static final RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", SapphireHoe::new);
    public static final RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", SapphirePickaxe::new);
    public static final RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", SapphireShovel::new);
    public static final RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", SapphireSword::new);
    public static final RegistryObject<AluminiumAxe> ALUMINIUM_AXE = ITEMS.register("aluminium_axe", AluminiumAxe::new);
    public static final RegistryObject<AluminiumHoe> ALUMINIUM_HOE = ITEMS.register("aluminium_hoe", AluminiumHoe::new);
    public static final RegistryObject<AluminiumPickaxe> ALUMINIUM_PICKAXE = ITEMS.register("aluminium_pickaxe", AluminiumPickaxe::new);
    public static final RegistryObject<AluminiumShovel> ALUMINIUM_SHOVEL = ITEMS.register("aluminium_shovel", AluminiumShovel::new);
    public static final RegistryObject<GodzillaAxe> GODZILLA_AXE = ITEMS.register("godzilla_axe", GodzillaAxe::new);
    public static final RegistryObject<FireCakeSword> FIRE_CAKE_SWORD = ITEMS.register("fire_cake_sword", FireCakeSword::new);
    public static final RegistryObject<TitaniumCakeSword> TITANIUM_CAKE_SWORD = ITEMS.register("titanium_cake_sword", TitaniumCakeSword::new);
    public static final RegistryObject<TitaniumHoe> TITANIUM_HOE = ITEMS.register("titanium_hoe", TitaniumHoe::new);
    public static final RegistryObject<TitaniumShovel> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", TitaniumShovel::new);
    public static final RegistryObject<TitaniumPickaxe> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", TitaniumPickaxe::new);
    public static final RegistryObject<TitaniumAxe> TITANIUM_AXE = ITEMS.register("titanium_axe", TitaniumAxe::new);

    //SOUNDS
    public static final RegistryObject<SoundEvent> AMOXICILLIN_AMBIENT = SOUNDS.register("amoxcillin_ambient", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "amoxcillin_ambient")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_BREAK = SOUNDS.register("leather_block_break", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_break")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_STEP = SOUNDS.register("leather_block_step", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_step")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_PLACE = SOUNDS.register("leather_block_place", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_place")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_HIT = SOUNDS.register("leather_block_hit", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID, "leather_block_hit")));
    public static final RegistryObject<SoundEvent> STAMPYLONGNOSE_AMBIENT = SOUNDS.register("stampylivingsound", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "stampylivingsound")));

    public static RegistryObject<Item> conditionallyRegisterItem(String registryName, Supplier<Item> item, Supplier<Boolean> condition) {
        if (condition.get())
            return ITEMS.register(registryName, item);
        return null;
    }
    public static RegistryObject<Block> conditionallyRegisterBlock(String registryName, Supplier<Block> block, Supplier<Boolean> condition) {
        if (condition.get())
            return BLOCKS.register(registryName, block);
        return null;
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }
}
