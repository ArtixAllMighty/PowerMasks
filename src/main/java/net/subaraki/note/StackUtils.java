package net.subaraki.note;

import net.minecraft.nbt.NBTTagCompound;

public class StackUtils {

	/**display name*/
	public static String ID  = "notedItemName";
	/**amount of items stored*/
	public static String AMT = "notedAmount";
	/**damage of the stored item*/
	public static String DMG = "notedDamage";
	/**a short: the item ID*/
	public static String ITM = "notedItemID";

	public StackUtils(){
	}

	/**creates a new nbt tag with all requiered tags for a noted item*/
	public NBTTagCompound createNotedNbt(int amt, String name, int damage, short itemid){
		NBTTagCompound tag = new NBTTagCompound();

		tag.setInteger(AMT, amt);
		tag.setString(ID, name);
		tag.setInteger(DMG, damage);
		tag.setShort(ITM, itemid);

		return tag;
	}

	public NBTTagCompound fuseNbt(NBTTagCompound tag1, NBTTagCompound tag2) {
		NBTTagCompound tag = new NBTTagCompound();

		tag.setInteger(AMT, tag1.getInteger(AMT) + tag2.getInteger(AMT));
		tag.setString(ID, tag1.getString(ID));
		tag.setInteger(DMG, tag1.getInteger(DMG));
		tag.setShort(ITM, tag1.getShort(ITM));
		
		return tag;
	}


}
