package com.example.chowbattle.entity.sam;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SamuelModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "samuel"), "main");
	private final ModelPart sam;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart body;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart arms;

	public SamuelModel(ModelPart root) {
		this.sam = root.getChild("sam");
		this.head = root.getChild("sam");
		this.nose = root.getChild("sam");
		this.body = root.getChild("sam");
		this.RightLeg = root.getChild("sam");
		this.LeftLeg = root.getChild("sam");
		this.RightArm = root.getChild("sam");
		this.LeftArm = root.getChild("sam");
		this.arms = root.getChild("sam");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sam = partdefinition.addOrReplaceChild("sam", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = sam.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 13).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(50, 39).addBox(-4.0F, -1.0F, 3.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -11.0F, -8.0F, 8.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition body = head.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 31).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 15.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = sam.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(29, 49).addBox(-1.0F, -18.0F, -2.0F, 3.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition LeftLeg = sam.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(12, 49).addBox(-2.0F, -22.0F, -2.0F, 3.0F, 34.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition RightArm = sam.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(47, 44).addBox(-6.0F, -14.0F, -2.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, -1.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(52, 48).addBox(-5.5F, -16.0F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition RightArm_r3 = RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(50, 47).addBox(-6.0F, -24.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, 5.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition RightArm_r4 = RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(46, 45).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 14.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition LeftArm = sam.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 37).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition arms = sam.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(50, 31).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sam.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}