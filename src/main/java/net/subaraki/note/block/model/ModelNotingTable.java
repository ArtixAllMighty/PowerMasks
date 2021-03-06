package net.subaraki.note.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNotingTable extends ModelBase
{
	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;

	public ModelNotingTable()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-8F, -1F, -8F, 16, 4, 16);
		Shape1.setRotationPoint(0F, 9F, 0F);
		Shape1.setTextureSize(64, 32);
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(-2F, 0F, -2F, 4, 12, 4);
		Shape2.setRotationPoint(-6F, 12F, -6F);
		Shape2.setTextureSize(64, 32);
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(-2F, 0F, -2F, 4, 12, 4);
		Shape3.setRotationPoint(6F, 12F, -6F);
		Shape3.setTextureSize(64, 32);
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(-2F, 0F, -2F, 4, 12, 4);
		Shape4.setRotationPoint(6F, 12F, 6F);
		Shape4.setTextureSize(64, 32);
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(-2F, 0F, -2F, 4, 12, 4);
		Shape5.setRotationPoint(-6F, 12F, 6F);
		Shape5.setTextureSize(64, 32);
		setRotation(Shape5, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
		super.render(entity, f, f1, f2, f3, f4, f5);
		render(f5);
	}

	public void render(float f5){

		Shape2.rotateAngleY = 1.58f;
		Shape4.rotateAngleY = -1.58f;
		Shape5.rotateAngleY = 1.58f *2f;

		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
	}

	public void render(){
		render(0.0625f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z){
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
