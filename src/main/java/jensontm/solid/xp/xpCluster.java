package jensontm.solid.xp;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xpCluster extends Item{

    public xpCluster(Settings settings) {
        super(settings);
    }
    
    public boolean hasGlint(ItemStack stack) {
        super.hasGlint(stack);
        return true;
    }
}
