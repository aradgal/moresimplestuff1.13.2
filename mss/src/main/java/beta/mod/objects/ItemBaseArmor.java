package beta.mod.objects;

import javax.annotation.Nullable;

import beta.mod.lists.ArmorMaterialList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBaseArmor extends ItemArmor {
	@Nullable
	private PotionEffect effect;
	
	public ItemBaseArmor(ArmorMaterialList materialIn, EntityEquipmentSlot slot, ItemBaseProperties props) {
		super(materialIn, slot, props.getProps());
	}
	
	public ItemBaseArmor(ArmorMaterialList materialIn, EntityEquipmentSlot slot, ItemBaseProperties props, @Nullable PotionEffect effect) {
		this(materialIn, slot, props);
		this.effect = effect;
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, EntityPlayer player) {
		if(effect != null) {
			player.addPotionEffect(effect);
		}
	}
}
