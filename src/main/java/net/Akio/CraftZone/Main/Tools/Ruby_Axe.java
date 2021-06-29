package net.Akio.CraftZone.Main.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class Ruby_Axe extends ItemAxe {	     
	       
	       private float weaponDamage;



		public Ruby_Axe(ToolMaterial material) {
	      super(material);
	       this.maxStackSize = 1;
	      setMaxDamage(6000);
	      setCreativeTab(CreativeTabs.tabTools);
		  float weaponDamage = 50;

	       }
	     
	     
	     
	     
	       
	       public float getDamageVsEntity(Entity par1Entity) {
	       return this.weaponDamage;
	       }
	     
	     
	       
	       public String getMaterialName() {
	       return "Ruby";
	       }

}