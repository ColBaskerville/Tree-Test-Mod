package com.colbaskerville.treetestmod;

import com.colbaskerville.treetestmod.init.ModBlocks;
import com.colbaskerville.treetestmod.init.ModItems;
import com.colbaskerville.treetestmod.init.ModNetworking;
import com.colbaskerville.treetestmod.proxy.IProxy;
import com.colbaskerville.treetestmod.utilities.Utilities;

import net.minecraft.stats.StatBasic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID,
	 name = Main.NAME,
	 version = Main.VERSION,
	 acceptedMinecraftVersions = "[1.12]"
		)
public class Main 
{
	public static final String MODID = "ttm";
	public static final String NAME = "Tree Test Mod";
	public static final String VERSION = "1.0";
	public static final String MODURL = "www.Col_Baskerville.com";
	public static final String MODDESCRIPTION = "Testing out trees";
	public static final String MODAUTHOR = "Col_Baskerville";
	public static final String MODCREDITS = "Jabelar";
	public static StatBasic deconstructedItemsStat;
	
	static
	{
		FluidRegistry.enableUniversalBucket();
	}
	
	
	@Instance(Main.MODID)
	public static Main instance;
	
	@SidedProxy(clientSide = "com.colbaskerville.treetestmod.proxy.ClientProxy", serverSide = "com.colbaskerville.treetestmod.proxy.ServerProxy")
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//DEBUG
		System.out.println("preInit() " + event.getModMetadata().name);
		
		Utilities.setModInfo(event);
		ModNetworking.registerSimpleNetworking();
		
		
		
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//DEBUG
		System.out.println("Registering gui handler");
		
		ModBlocks.registerOreDictionaryEntries();
		ModItems.registerOreDictionaryEntries();
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//DEBUG
		System.out.println("postInit()");
		
		proxy.postInit(event);
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		//DEBUG
		System.out.println("Server starting");
		proxy.serverStarting(event);
	}
}