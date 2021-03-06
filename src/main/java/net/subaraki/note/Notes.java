package net.subaraki.note;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.subaraki.note.block.BlockNotingTable;
import net.subaraki.note.block.inventory.TileEntityNoteTable;
import net.subaraki.note.config.Config;
import net.subaraki.note.item.ItemMagicNote;
import net.subaraki.note.item.ItemNote;
import net.subaraki.note.proxy.ServerProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "noteditems", name = "Noted Items", version = "ModJamBeta")
public class Notes {

	public static Item note;
	public static Item magicNote;

	public static Block table;

	@SidedProxy(clientSide = "net.subaraki.note.proxy.ClientProxy", serverSide = "net.subaraki.note.proxy.ServerProxy")
	public static ServerProxy proxy;

	public static Notes instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e){

		Config.instance.loadConfig(e.getSuggestedConfigurationFile());

		instance = this;
		addItems();
		addBlocks();
		registerItems();
		registerBlocks();
		addRecipes();
	}

	@EventHandler
	public void init(FMLInitializationEvent e){

		GameRegistry.registerTileEntity(TileEntityNoteTable.class, "notingTable");

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		proxy.registerRendering();
	}

	private void addItems(){
		note = new ItemNote().setUnlocalizedName("notedItem").setTextureName("map_empty").setCreativeTab(CreativeTabs.tabMaterials);
		magicNote = new ItemMagicNote().setUnlocalizedName("notedMagicItem").setTextureName("map_empty").setCreativeTab(CreativeTabs.tabMaterials);
	}

	private void addBlocks(){
		table = new BlockNotingTable(Material.wood).setBlockName("notedTable").setBlockTextureName("planks_oak").setHardness(2.0f).setLightOpacity(0);
	}

	private void registerItems(){
		GameRegistry.registerItem(note, "notedItem");
		GameRegistry.registerItem(magicNote, "notedItemMagic");
	}

	private void registerBlocks(){
		GameRegistry.registerBlock(table, "notingTable");
	}

	private void addRecipes(){
		GameRegistry.addRecipe(new ItemStack(note), new Object[]{
			"xxx","xpx","xxx", 'x', Items.paper, 'p' , Items.feather
		});

		GameRegistry.addRecipe(new ItemStack(table), new Object[]{"xnx","x x","x x", 'x', Blocks.planks, 'n', note});
	}
}
