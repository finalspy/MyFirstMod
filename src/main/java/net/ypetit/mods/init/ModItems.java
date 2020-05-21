package net.ypetit.mods.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.ypetit.mods.MyFirstMod;
import net.ypetit.mods.items.ItemBasic;

@Mod.EventBusSubscriber(modid = MyFirstMod.MOD_ID )
public class ModItems {
    
    public static Item pikachu;
    public static Item unicorn;

    public static void init(){
        pikachu = new ItemBasic("pikachu");
        unicorn = new ItemBasic("unicorn");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(pikachu,unicorn);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
        ModItems.registerRender(pikachu);
        ModItems.registerRender(unicorn);
    }

    public static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}