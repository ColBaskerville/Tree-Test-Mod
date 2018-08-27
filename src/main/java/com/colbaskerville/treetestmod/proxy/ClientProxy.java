package com.colbaskerville.treetestmod.proxy;

import java.util.List;

import com.colbaskerville.treetestmod.Main;
import com.colbaskerville.treetestmod.blocks.BlockLeavesApple;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = Main.MODID)
public class ClientProxy implements IProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}	
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		//DEBUG
		System.out.println("on Client side");
		
		Minecraft mc = Minecraft.getMinecraft();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init(FMLInitializationEvent event)
	{
		//DEBUG
		System.out.println("on Client side");
		
		Minecraft mc = Minecraft.getMinecraft();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		//DEBUG
		System.out.println("on Client side");
		
		refreshLangResources();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void refreshLangResources()
	{
		//DEBUG
		System.out.println("Refreshing lang files with proper precedence");
		Minecraft.getMinecraft().refreshResources();
		List<String> list = Lists.newArrayList("en_us");
		
		if(!"en_us".equals(Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage()))
		{
			list.add(Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().toString());
		}
	}
	
	@Override
	public void serverStarting(FMLServerStartingEvent event)
	{
		// This will never get called on client side
	}
	
	@Override
	public void setGraphicsLevel(BlockLeavesApple parBlock, boolean parFancyEnabled)
	{
		parBlock.setGraphicsLevel(parFancyEnabled);
	}

	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().player : ctx.getServerHandler().player);
	}

	@Override
	public boolean handleMaterialAcceleration(Entity parEntity, Material parMaterial) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	
}
