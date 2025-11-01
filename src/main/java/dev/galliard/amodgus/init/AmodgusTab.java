package dev.galliard.amodgus.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AmodgusTab extends CreativeModeTab{
	public static final AmodgusTab AMODGUS_TAB = new AmodgusTab(CreativeModeTab.TABS.length, "Amodgus");
	
	private AmodgusTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(InitItems.KNIFE.get());
    }
}
