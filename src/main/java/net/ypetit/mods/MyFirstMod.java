package net.ypetit.mods;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.ypetit.mods.init.ModItems;

import org.apache.logging.log4j.Logger;

@Mod(modid = MyFirstMod.MOD_ID, name = MyFirstMod.NAME, version = MyFirstMod.VERSION)
public class MyFirstMod
{
    public static final String MOD_ID = "myfirstmod";
    public static final String NAME = "My First Mod";
    public static final String VERSION = "1.0";
    // TODO add accepted minecraft versions 

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info(MyFirstMod.MOD_ID + ":preInit()");
        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info(MyFirstMod.MOD_ID + ":init()");

        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void postInit(FMLPreInitializationEvent event) {
        //logger.info(MyFirstMod.MOD_ID + ":postInit()");
    }
}
