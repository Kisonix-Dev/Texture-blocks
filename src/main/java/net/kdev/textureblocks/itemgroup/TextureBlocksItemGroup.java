
package net.kdev.textureblocks.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.kdev.textureblocks.block.Cobblestone31Block;
import net.kdev.textureblocks.TextureBlocksModElements;

@TextureBlocksModElements.ModElement.Tag
public class TextureBlocksItemGroup extends TextureBlocksModElements.ModElement {
	public TextureBlocksItemGroup(TextureBlocksModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtexture_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Cobblestone31Block.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
