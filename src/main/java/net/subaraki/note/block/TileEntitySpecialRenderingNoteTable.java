package net.subaraki.note.block;

import static org.lwjgl.opengl.GL11.*;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntitySpecialRenderingNoteTable extends
		TileEntitySpecialRenderer {

	private static ModelNoteTable table; 
	private static final ResourceLocation texture = new ResourceLocation("noteditems","model/table.png");
	public TileEntitySpecialRenderingNoteTable() {
		table = new ModelNoteTable();
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y,
			double z, float var8) {
		
		glPushMatrix();

		glTranslatef((float) x + 0.5F, (float) y + 2.25F, (float) z + 0.5F);
		glScalef(1.0F, -1F, -1F);

		bindTexture(texture);

		table.render();
		
		glPopMatrix();
	}

}
