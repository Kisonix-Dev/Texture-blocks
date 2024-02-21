
package net.kdev.textureblocks.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.kdev.textureblocks.itemgroup.TextureBlocksItemGroup;
import net.kdev.textureblocks.TextureBlocksModElements;

import java.util.List;
import java.util.Collections;

@TextureBlocksModElements.ModElement.Tag
public class Wallpapers99Block extends TextureBlocksModElements.ModElement {
	@ObjectHolder("texture_blocks:wallpapers_99")
	public static final Block block = null;

	public Wallpapers99Block(TextureBlocksModElements instance) {
		super(instance, 1226);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TextureBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5f, 6f).setLightLevel(s -> 0).harvestLevel(1)
					.harvestTool(ToolType.AXE));
			setRegistryName("wallpapers_99");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
