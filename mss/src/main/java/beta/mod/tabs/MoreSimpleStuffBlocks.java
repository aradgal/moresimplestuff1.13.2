package beta.mod.tabs;

import beta.mod.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoreSimpleStuffBlocks extends ItemGroup {
	private static final ResourceLocation SEARCH_BAR = new ResourceLocation("textures/gui/container/creative_inventory/tab_item_search.png");

	public MoreSimpleStuffBlocks() {
		super("mssblocks");
	}
	
	@Override @OnlyIn(Dist.CLIENT)
	public ItemStack createIcon() {
		return new ItemStack(BlockInit.mixed_bricks);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

	@Override
	public ResourceLocation getBackgroundImage() {
		return SEARCH_BAR;
	}
}
