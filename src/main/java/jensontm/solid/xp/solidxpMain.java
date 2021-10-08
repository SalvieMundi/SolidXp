package jensontm.solid.xp;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class solidxpMain implements ModInitializer {
	
	public static final Item XP_CLUSTER = new xpCluster(new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON));
	public static final Item XP_ARTIFACT = new xpArtifact(new Item.Settings().group(ItemGroup.MISC).maxCount(1).rarity(Rarity.RARE));
	public static final Block XP_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(4f, 25f).sounds(BlockSoundGroup.METAL));
	public static final Block XP_VEIN = new xpVein(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3f, 15f).sounds(BlockSoundGroup.STONE));

	//public static final EntityType<FATxpBottleEntity> FATxpBottleEntityType = Registry.register(Registry.ENTITY_TYPE, new Identifier("solidxp", "greater_experience_bottle"), FabricEntityTypeBuilder.<FATxpBottleEntity>create(SpawnGroup.MISC, FATxpBottleEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build());

	private static ConfiguredFeature<?, ?> XP_VEIN_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, XP_VEIN.getDefaultState(), 4))
		.range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(-40), YOffset.fixed(50)))).spreadHorizontally().repeat(12);
		
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("solidxp", "cluster_of_experience"), XP_CLUSTER);
		Registry.register(Registry.ITEM, new Identifier("solidxp", "experience_artifact"), XP_ARTIFACT);
		Registry.register(Registry.ITEM, new Identifier("solidxp", "block_of_experience"), new BlockItem(XP_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("solidxp", "experience_vein"), new BlockItem(XP_VEIN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("solidxp", "block_of_experience"), XP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("solidxp", "experience_vein"), XP_VEIN);

		RegistryKey<ConfiguredFeature<?, ?>> xpVeinOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("solidxp", "experience_vein"));
    	Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, xpVeinOverworld.getValue(), XP_VEIN_OVERWORLD);
    	BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, xpVeinOverworld);
	}
}
