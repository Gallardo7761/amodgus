package dev.galliard.amodgus.init;

import dev.galliard.amodgus.sound.ModSounds;
import dev.galliard.amodgus.Amodgus;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, Amodgus.MODID
    	);
    public static final RegistryObject<SwordItem> KNIFE = ITEMS.register(
        "knife", () -> new SwordItem(
            Tiers.IRON, 
            2, 
            -2.0f, 
            new Item.Properties().tab(AmodgusTab.AMODGUS_TAB))
    	);
    
    public static final RegistryObject<Item> EGGHAT = ITEMS.register(
        "egghat", () -> new Item(
            new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
        );
    
    public static final RegistryObject<Item> AMONGUS_SPAWN_EGG = ITEMS.register(
    	"amongus_spawn_egg", () -> new ForgeSpawnEggItem(
    		MobsInit.AMONGUS, 0xb4202a, 0xb9bffb, new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
        );
    
    public static final RegistryObject<Item> IMPOSTOR_SPAWN_EGG = ITEMS.register(
        	"impostor_spawn_egg", () -> new ForgeSpawnEggItem(
        		MobsInit.IMPOSTOR, 0x3f474e, 0x1e1f26, new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    
    public static final RegistryObject<Item> RED_TOY = ITEMS.register(
            "red_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> BLACK_TOY = ITEMS.register(
            "black_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> WHITE_TOY = ITEMS.register(
            "white_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> CYAN_TOY = ITEMS.register(
            "cyan_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> PINK_TOY = ITEMS.register(
            "pink_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> PURPLE_TOY = ITEMS.register(
            "purple_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> MAGENTA_TOY = ITEMS.register(
            "magenta_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> BLUE_TOY = ITEMS.register(
            "blue_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> BROWN_TOY = ITEMS.register(
            "brown_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> GREEN_TOY = ITEMS.register(
            "green_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> LIME_TOY = ITEMS.register(
            "lime_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> YELLOW_TOY = ITEMS.register(
            "yellow_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    public static final RegistryObject<Item> ORANGE_TOY = ITEMS.register(
            "orange_toy", () -> new Item(
                new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
            );
    
    public static final RegistryObject<Item> FLASK = ITEMS.register(
    		"flask", () -> new Item(
    				new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1))
    		);

    public static final RegistryObject<Item> AMONGUS_DRIP_SONG_MUSIC_DISC = ITEMS.register("music_disc_amongus_drip",
            () -> new RecordItem(4, ModSounds.AMONGUS_DRIP,
                    new Item.Properties().tab(AmodgusTab.AMODGUS_TAB).stacksTo(1), 0));
}
