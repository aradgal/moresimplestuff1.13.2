package beta.mod.objects.special.staff;

import java.util.List;

import beta.mod.init.ItemInit;
import beta.mod.objects.ItemBaseProperties;
import beta.mod.objects.entity.EntityLavaProjectile;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class LavaStaff extends Staff {
	public LavaStaff(ItemBaseProperties props) {
		super(props);
	}

	@Override
	public ActionResult<ItemStack> onRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		ItemStack ammo = playerIn.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
		ItemStack neededAmmo = new ItemStack(ItemInit.FIRE_AMMO);
		if(ammo == ItemStack.EMPTY || !ItemStack.areItemsEqual(ammo, neededAmmo)) {
			playerIn.sendMessage(new TextComponentTranslation("\u00A76" + "You need to have ammo in your offhand!"));
			return new ActionResult<>(EnumActionResult.FAIL, item);
		} else if(ItemStack.areItemsEqual(ammo, neededAmmo)) {
			ammo.shrink(1);
			Vec3d aim = playerIn.getLookVec();
			EntityLavaProjectile lava = new EntityLavaProjectile(worldIn, playerIn, aim.x * 0.155, aim.y * 0.155, aim.z * 0.155);
			
			playerIn.getCooldownTracker().setCooldown(this, 100);
			
			lava.setPosition(playerIn.posX + aim.x, playerIn.posY + aim.y + 2d, playerIn.posZ + aim.z);
			lava.accelerationX = aim.x * 0.155; lava.accelerationY = aim.y * 0.155; lava.accelerationZ = aim.z * 0.155;
			
			worldIn.spawnEntity(lava);
			
			item.damageItem(1, playerIn);
			return new ActionResult<>(EnumActionResult.SUCCESS, item);
		}
		return new ActionResult<>(EnumActionResult.FAIL, item);
	}

	@Override
	public void addDescription(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("\u00A7e" + "Burn your enemies"));
		tooltip.add(new TextComponentTranslation("\u00A7e" + "with this tool! Use"));
		tooltip.add(new TextComponentTranslation("\u00A7e" + "it wisely!"));
	}
	
}
