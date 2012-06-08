package net.minecraft.src.buildcraft.core;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import net.minecraft.src.Render;
import net.minecraft.src.forge.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

public class RenderRobot extends Render {

	protected ModelBase model = new ModelBase() {};
	private ModelRenderer box;

	public RenderRobot() {
		box = new ModelRenderer(model, 0, 0);
		box.addBox(-4F, -4F, -4F, 8, 8, 8);
		box.rotationPointX = 0;
		box.rotationPointY = 0;
		box.rotationPointZ = 0;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float f, float f1) {
		doRender((EntityRobot) entity, x, y, z, f, f1);
	}

	private void doRender(EntityRobot laser, double x, double y, double z, float f, float f1) {

		GL11.glPushMatrix();
		GL11.glDisable(2896 /* GL_LIGHTING */);
		GL11.glTranslated(x, y, z);

		MinecraftForgeClient.bindTexture("/net/minecraft/src/buildcraft/core/gui/robot.png");

		float factor = (float) (1.0 / 16.0);

		box.render(factor);

		GL11.glEnable(2896 /* GL_LIGHTING */);
		GL11.glPopMatrix();

	}

}
