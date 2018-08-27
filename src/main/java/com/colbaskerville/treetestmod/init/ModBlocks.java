package com.colbaskerville.treetestmod.init;

import com.colbaskerville.treetestmod.Main;
import com.colbaskerville.treetestmod.blocks.BlockLeavesApple;
import com.colbaskerville.treetestmod.blocks.BlockLogApple;
import com.colbaskerville.treetestmod.blocks.BlockSaplingApple;
import com.colbaskerville.treetestmod.utilities.Utilities;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Main.MODID)
public class ModBlocks 
{
	//Block Instances
	public static final BlockLeavesApple apple_leaves = null;
	public static final BlockLogApple apple_log = null;
	public static final BlockSaplingApple apple_sapling = null;
	
	//ItemBlock Instances
	@ObjectHolder("apple_sapling")
	public static final ItemBlock item_block_apple_sapling = null;
	@ObjectHolder("apple_leaves")
	public static final ItemBlock item_block_apple_leaves = null;
	@ObjectHolder("apple_log")
	public static final ItemBlock item_block_apple_log = null;
	
	@EventBusSubscriber(modid = Main.MODID)
	public static class RegistrationHandler
	{
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<Block> event)
		{
			//DEBUG
			System.out.println("Registering Blocks");
			
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			registry.register(Utilities.setBlockName(new BlockLeavesApple(), "apple_leaves"));
			registry.register(Utilities.setBlockName(new BlockLogApple(), "apple_log"));
			registry.register(Utilities.setBlockName(new BlockSaplingApple(), "apple_sapling"));
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
		{
			//DEBUG
			System.out.println("Registering ItemBlocks");
			
			final IForgeRegistry<Item> registry = event.getRegistry();
			
			registry.register(Utilities.setItemName(new ItemBlock(apple_log) {
						@Override
						public int getItemBurnTime(ItemStack itemStack)
						{
							return 300;
						}
					}, apple_log.getRegistryName().getResourcePath()));
			registry.register(Utilities.setItemName(new ItemBlock(apple_leaves), apple_leaves.getRegistryName().getResourcePath()));
			registry.register(Utilities.setItemName(new ItemBlock(apple_sapling) {
				@Override
				public int getItemBurnTime(ItemStack itemStack)
				{
					return 100;
				}
			}, apple_sapling.getRegistryName().getResourcePath()));
		}
		
		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onModelEvent(final ModelRegistryEvent event)
		{
			//DEBUG
			System.out.println("Registering blockModels");
			
			registerBlockModel(apple_log);
			registerBlockModel(apple_leaves);
			registerBlockModel(apple_sapling);
			registerItemBlockModels();
		}
		
		@SideOnly(Side.CLIENT)
		public static void registerBlockModel(Block parBlock)
		{
			registerBlockModel(parBlock, 0);
		}
		
		@SideOnly(Side.CLIENT)
		public static void registerBlockModel(Block parBlock, int parMetaData)
		{
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(parBlock), parMetaData, new ModelResourceLocation(Main.MODID + ":" + parBlock.getUnlocalizedName().substring(5), "inventory"));
		}
		
		@SideOnly(Side.CLIENT)
		public static void registerItemBlockModels()
		{
			registerItemBlockModel(item_block_apple_leaves);
			registerItemBlockModel(item_block_apple_log);
			registerItemBlockModel(item_block_apple_sapling);
		}
		
		@SideOnly(Side.CLIENT)
		public static void registerItemBlockModel(ItemBlock parBlock)
		{
			registerItemBlockModel(parBlock, 0);
		}
		
		@SideOnly(Side.CLIENT)
		public static void registerItemBlockModel(ItemBlock parBlock, int parMetaData)
		{
			ModelLoader.setCustomModelResourceLocation(parBlock, parMetaData, new ModelResourceLocation(parBlock.getRegistryName(), "inventory"));
			
		}

	}

	public static void registerOreDictionaryEntries() {
		OreDictionary.registerOre("treeLeaves", apple_leaves);
		OreDictionary.registerOre("treeSapling", apple_sapling);
		OreDictionary.registerOre("logWood", new ItemStack(apple_log, 1, OreDictionary.WILDCARD_VALUE));
	}
	
}
