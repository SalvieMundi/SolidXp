// package jensontm.solid.xp;

// import net.fabricmc.api.EnvType;
// import net.fabricmc.api.Environment;
// import net.minecraft.entity.Entity;
// import net.minecraft.entity.EntityType;
// import net.minecraft.entity.ExperienceOrbEntity;
// import net.minecraft.entity.LivingEntity;
// import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
// import net.minecraft.item.Item;
// import net.minecraft.util.hit.HitResult;
// import net.minecraft.util.math.MathHelper;
// import net.minecraft.world.World;

// public class FATxpBottleEntity extends ThrownItemEntity{
//     public FATxpBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
// 		super(entityType, world);
// 	}
 
// 	public FATxpBottleEntity(World world, LivingEntity owner) {
// 		super(solidxpMain.FATxpBottleEntityType, owner, world);
// 	}
 
// 	public FATxpBottleEntity(World world, double x, double y, double z) {
// 		super(solidxpMain.FATxpBottleEntityType, x, y, z, world);
// 	}
 
// 	@Override
// 	protected Item getDefaultItem() {
// 		return null;
// 	}
 
// 	protected void onCollision(HitResult hitResult) { // called on collision with a block
// 		super.onCollision(hitResult);
// 		if (!this.world.isClient) { // checks if the world is client
// 			ExperienceOrbEntity xpOrb = EntityType.EXPERIENCE_ORB.create(world);
			
			
// 			MathHelper.nextInt(world.random, 6, 10);
			
// 			this.world.spawnEntity(xpOrb);
// 			this.world.sendEntityStatus(this, (byte)3); // particle?
// 			this.remove(getRemovalReason()); // kills the projectile
// 		}
 
// 	}
// }
