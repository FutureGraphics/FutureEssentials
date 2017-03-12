package future.code.essentials.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ApiManager {

	public static ItemStack createItemStack(Material material, int amount, int meta, String name, Enchantment enchantment, int enchlvl, ItemFlag flag, String... lore) {
		ItemStack item = new ItemStack(material, amount, (short) meta);
		ItemMeta Itemmeta = item.getItemMeta();
		if(name != null) {
			Itemmeta.setDisplayName(name);
		}
		if(enchantment != null && enchlvl != 0) {
			Itemmeta.addEnchant(enchantment, enchlvl, true);
		}
		if(flag != null) {
			Itemmeta.addItemFlags(flag);
		}
		
		if(lore != null) {
			List<String> loreList = new ArrayList<String>();
			for(String loreText : lore) {
				loreList.add(loreText);
			}
			Itemmeta.setLore(loreList);
		}
		item.setItemMeta(Itemmeta);
		return item;
	}
	
	public static String encryptFormat(String format) {
		format = format.replace("%server%", MainManager.getName());
		format = format.replace("%prefix%", MainManager.getPrefix());
		format = format.replace("&", "§");
		return format;
	}
 	
}
