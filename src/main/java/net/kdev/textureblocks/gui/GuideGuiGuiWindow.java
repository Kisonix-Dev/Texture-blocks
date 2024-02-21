
package net.kdev.textureblocks.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.kdev.textureblocks.TextureBlocksMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GuideGuiGuiWindow extends ContainerScreen<GuideGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GuideGuiGui.guistate;

	public GuideGuiGuiWindow(GuideGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 342;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("texture_blocks:textures/screens/guide_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Material ID (Texture) ", 113, 6, -12829636);
		this.font.drawString(ms, "Asphalt - ID_1", 8, 25, -12829636);
		this.font.drawString(ms, "Concrete - ID_2", 8, 34, -12829636);
		this.font.drawString(ms, "Cobblestone - ID_3", 8, 43, -12829636);
		this.font.drawString(ms, "Granite ID_4", 8, 52, -12829636);
		this.font.drawString(ms, "Ground - ID_5", 8, 61, -12829636);
		this.font.drawString(ms, "Dirt - ID_6", 8, 70, -12829636);
		this.font.drawString(ms, "Wood - ID_7", 8, 79, -12829636);
		this.font.drawString(ms, "Woodenplanks - ID_8", 8, 88, -12829636);
		this.font.drawString(ms, "Example: //set texture_blocks:asphalt_7", 9, 146, -13408513);
		this.font.drawString(ms, "Stone - ID_9", 8, 97, -12829636);
		this.font.drawString(ms, "Brick - ID_10", 8, 106, -12829636);
		this.font.drawString(ms, "Carpet - ID_11", 8, 115, -12829636);
		this.font.drawString(ms, "World Edit", 144, 129, -12829636);
		this.font.drawString(ms, "Laminate - ID_12", 113, 25, -12829636);
		this.font.drawString(ms, "Linoleum - ID_13", 113, 34, -12829636);
		this.font.drawString(ms, "Moss - ID_14", 113, 44, -12829636);
		this.font.drawString(ms, "Marble tiles - ID_15", 113, 54, -12829636);
		this.font.drawString(ms, "Panels - ID_16", 113, 63, -12829636);
		this.font.drawString(ms, "Parquet - ID_17", 113, 73, -12829636);
		this.font.drawString(ms, "Wallpapers - ID_18 ", 113, 84, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 288, this.guiTop + 138, 46, 20, new StringTextComponent("Exit"), e -> {
			if (true) {
				TextureBlocksMod.PACKET_HANDLER.sendToServer(new GuideGuiGui.ButtonPressedMessage(0, x, y, z));
				GuideGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
