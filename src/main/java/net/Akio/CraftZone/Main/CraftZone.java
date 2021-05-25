package net.Akio.CraftZone.Main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.Akio.CraftZone.Main.Blocks.Dried_Cow;
import net.Akio.CraftZone.Main.Blocks.Dried_Villager;
import net.Akio.CraftZone.Main.Blocks.Ruby_Block;
import net.Akio.CraftZone.Main.Foods.Butter;
import net.Akio.CraftZone.Main.Foods.Butter_Candy;
import net.Akio.CraftZone.Main.Foods.Cheese;
import net.Akio.CraftZone.Main.Foods.Fire_Fish;
import net.Akio.CraftZone.Main.Items.Critter_Cage;
import net.Akio.CraftZone.Main.Materials.Amethyst;
import net.Akio.CraftZone.Main.Materials.Ruby;
import net.Akio.CraftZone.Main.Materials.Salt;
import net.Akio.CraftZone.Main.Tools.Amethyst_Axe;
import net.Akio.CraftZone.Main.Tools.Amethyst_Pickaxe;
import net.Akio.CraftZone.Main.Tools.Emerald_Hoe;
import net.Akio.CraftZone.Main.Tools.Emerald_Pickaxe;

import net.Akio.CraftZone.Main.Tools.Ruby_Axe;
import net.Akio.CraftZone.Main.Tools.Ruby_Pickaxe;
import net.Akio.CraftZone.Main.Tools.Ultimate_Pickaxe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = CraftZone.MOD_ID, version = CraftZone.MC_VERSION)

public class CraftZone {

	public static final String MOD_AUTHOR = "Katara";
	public static final String MOD_CODER = "Akio";
    public static final String MOD_ID = "DangerZone";
    public static final String MC_VERSION = "1.7.10";
    public static final double MOD_VERSION = 1.0;
    
    public static final Item.ToolMaterial AmethystMaterials = EnumHelper.addToolMaterial("AmethystMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldMaterials = EnumHelper.addToolMaterial("EmeraldMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldPickaxe = EnumHelper.addToolMaterial("EmeraldPickaxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial RubyMaterials = EnumHelper.addToolMaterial("RubyMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial RubyAxe = EnumHelper.addToolMaterial("RubyAxe", 5, 1500, 11F, 16F, 70);
    public static final Item.ToolMaterial AmethystAxe = EnumHelper.addToolMaterial("AmethystAxe", 5, 1500, 11F, 16F, 70);
    public static final Item.ToolMaterial UltimatePick = EnumHelper.addToolMaterial("UltimatePick", 5, 1500, 11F, 16F, 70);
    public static final Item.ToolMaterial RubyPick = EnumHelper.addToolMaterial("RubyPick`", 5, 1500, 11F, 16F, 70);
    
    public static Item ruby_pickaxe;
    public static Item ultimate_pickaxe;
    public static Item critter_cage;
    public static Item salt;
    public static Block ruby_block;
    public static Block Dried_cow;
    public static Block Dried_Villager;
    public static Item cheese;
    public static Item butter;
    public static Item butter_candy;
	public static Item ruby_axe;
    public static Item amethyst_pickaxe;
    public static Item amethyst_axe;
    public static Item emerald_hoe;
    public static Item emerald_pickaxe;
    public static Item fire_fish;
    public static Item uby;
    public static Item amethyst;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	uby = new Ruby().setUnlocalizedName("Ruby").setTextureName("dangerzone:ruby");
    	GameRegistry.registerItem(uby, uby.getUnlocalizedName().substring(5)); 
    	
    	ruby_block = new Ruby_Block(0).setBlockName("Ruby_Block").setBlockTextureName("dangerzone:blockruby");
    	GameRegistry.registerBlock(ruby_block, ruby_block.getUnlocalizedName().substring(5));
    	
    	Dried_cow = new Dried_Cow(1).setBlockName("Dried_Cow").setBlockTextureName("dangerzone:orecow");
    	GameRegistry.registerBlock(Dried_cow, Dried_cow.getUnlocalizedName().substring(5));
    	
    	Dried_Villager = new Dried_Villager(1).setBlockName("Dried_Villager").setBlockTextureName("dangerzone:orevillager");
    	GameRegistry.registerBlock(Dried_Villager, Dried_Villager.getUnlocalizedName().substring(5));
    	
    	amethyst = new Amethyst().setUnlocalizedName("Amethyst").setTextureName("dangerzone:amethyst");
    	GameRegistry.registerItem(amethyst, amethyst.getUnlocalizedName().substring(5));
    	
    	fire_fish = new Fire_Fish(10, 8, 8, true).setUnlocalizedName("Fire_Fish").setTextureName("dangerzone:fire_fish");
    	GameRegistry.registerItem(fire_fish, fire_fish.getUnlocalizedName().substring(5));
    	
    	butter_candy = new Butter_Candy(10, 4, 4, true).setUnlocalizedName("Butter_Candy").setTextureName("dangerzone:butter_candy");
    	GameRegistry.registerItem(butter_candy, butter_candy.getUnlocalizedName().substring(5));
    	
    	butter = new Butter(10, 1, 1, true).setUnlocalizedName("Butter").setTextureName("dangerzone:butter");
    	GameRegistry.registerItem(butter, butter.getUnlocalizedName().substring(5));
    	
    	cheese = new Cheese(10, 4, 1, true).setUnlocalizedName("Cheese").setTextureName("dangerzone:cheese");
    	GameRegistry.registerItem(cheese, cheese.getUnlocalizedName().substring(5));
    	
    	emerald_pickaxe = new Emerald_Pickaxe(EmeraldPickaxe).setUnlocalizedName("Emerald_Pickaxe").setTextureName("dangerzone:emerald_pickaxe");
    	GameRegistry.registerItem(emerald_pickaxe, emerald_pickaxe.getUnlocalizedName().substring(5)); 
    	
    	emerald_hoe = new Emerald_Hoe(EmeraldMaterials).setUnlocalizedName("Emerald_Hoe").setTextureName("dangerzone:emerald_hoe");
    	GameRegistry.registerItem(emerald_hoe, emerald_hoe.getUnlocalizedName().substring(5));

    	amethyst_pickaxe = new Amethyst_Pickaxe(AmethystMaterials).setUnlocalizedName("Amethyst_Pickaxe").setTextureName("dangerzone:amethyst_pickaxe");
    	GameRegistry.registerItem(amethyst_pickaxe, amethyst_pickaxe.getUnlocalizedName().substring(5)); 

    	amethyst_axe = new Amethyst_Axe(AmethystAxe).setUnlocalizedName("Amethyst_Axe").setTextureName("dangerzone:amethyst_axe");
    	GameRegistry.registerItem(amethyst_axe, amethyst_axe.getUnlocalizedName().substring(5));

    	ruby_axe = new Ruby_Axe(RubyAxe).setUnlocalizedName("Ruby_Axe").setTextureName("dangerzone:ruby_axe");
    	GameRegistry.registerItem(ruby_axe, ruby_axe.getUnlocalizedName().substring(5));
    	
    	salt = new Salt().setUnlocalizedName("Salt").setTextureName("dangerzone:salt");
    	GameRegistry.registerItem(salt, salt.getUnlocalizedName().substring(5));
    	
    	critter_cage = new Critter_Cage().setUnlocalizedName("Critter_Cage").setTextureName("dangerzone:critter_cage");
    	GameRegistry.registerItem(critter_cage, critter_cage.getUnlocalizedName().substring(5)); 
    	
    	ultimate_pickaxe = new Ultimate_Pickaxe(UltimatePick).setUnlocalizedName("Ultimate_Pickaxe").setTextureName("dangerzone:ultimate_pickaxe");
    	GameRegistry.registerItem(ultimate_pickaxe, ultimate_pickaxe.getUnlocalizedName().substring(5));
    	
    	ruby_pickaxe = new Ruby_Pickaxe(RubyPick).setUnlocalizedName("Ruby_Pickaxe").setTextureName("dangerzone:rubypickaxe");
    	GameRegistry.registerItem(ruby_pickaxe, ruby_pickaxe.getUnlocalizedName().substring(5));

    }
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    	GameRegistry.addRecipe(new ItemStack(ruby_axe), new Object[]{"RR ", "RS ", " S ", 'R', CraftZone.uby, 'S', Items.stick});
    	
    	GameRegistry.addRecipe(new ItemStack(emerald_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', Items.emerald, 'S', Items.stick});
    	
    	GameRegistry.addRecipe(new ItemStack(ruby_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', CraftZone.uby, 'S', Items.stick});

    	GameRegistry.addRecipe(new ItemStack(emerald_hoe), new Object[]{"DD ", " S ", " S ", 'D', Blocks.emerald_block, 'S', Items.stick});

    	GameRegistry.addRecipe(new ItemStack(uby, 9), new Object[]{"U", 'U', ruby_block});
    	
    	GameRegistry.addRecipe(new ItemStack(ruby_block), new Object[] {"DDD", "DDD", "DDD", 'D', CraftZone.uby});
    	
    	GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 92), new Object[] {"D", "W", 'D', CraftZone.Dried_cow, 'W', Items.water_bucket});
    	
    	GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 120), new Object[] {"D", "W", 'D', CraftZone.Dried_Villager, 'W', Items.water_bucket});

    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
   
}