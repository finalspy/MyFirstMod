package net.ypetit.mods.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.ypetit.mods.MyFirstMod;
import net.ypetit.mods.blocks.BlockBasic;

@Mod.EventBusSubscriber(modid = MyFirstMod.MOD_ID)
public class ModBlocks {
    
    public static Block pikachuBlock;

    public static void init() {
        pikachuBlock = new BlockBasic("pikachublock", Material.ROCK).setHardness(1.5f)
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(1.0f);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(pikachuBlock);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(pikachuBlock).setRegistryName(pikachuBlock.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(pikachuBlock));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }


}