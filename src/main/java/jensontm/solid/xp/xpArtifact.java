package jensontm.solid.xp;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class xpArtifact extends Item{

    public xpArtifact(Settings settings) {
        super(settings);
    }
    
    public boolean hasGlint(ItemStack stack) {
        super.hasGlint(stack);
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            if (player.totalExperience >= 32) {
                player.giveItemStack(new ItemStack(solidxpMain.XP_CLUSTER));
                player.getItemCooldownManager().set(this, 25);
                player.addExperience(-32);

                player.playSound(SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 3f, 1.5f);
                player.playSound(SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 3f, 0.4f);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 0.5f, 0.9f);
                player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS, 0.5f, 0.3f);
                player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS, 0.5f, 0.3f);
            }
            else {
                player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS, 0.5f, 0.7f);
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
