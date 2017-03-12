package future.code.essentials.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import future.code.essentials.main.main;

public class LanguageManager {

	private File file;
	private main plugin;
	private static FileConfiguration config;
	public LanguageManager(main plugin) {
		this.plugin = plugin;
		file = new File(this.plugin.getDataFolder(), "language.yml");
		config = YamlConfiguration.loadConfiguration(file);
		load();
	}
	
	public void load() {
		if(file.exists()) {
			try {
				config.load(file);
			} catch (IOException | InvalidConfigurationException e) {
				System.out.println("Essentials: Config-Error");
			}
		} else {
			config.options().copyDefaults(true);
			config.addDefault("NoAccess", "%prefix% &cYou have no access");
			config.addDefault("ReloadMessage", "%prefix% &eReload complete");
			save();
		}
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			System.out.println("Essentials: Config-Error");
		}
	}
	
	public static String ReloadMessage() {
		return ApiManager.encryptFormat(config.getString("ReloadMessage"));
	}
	
	public static String noAccess() {
		return ApiManager.encryptFormat(config.getString("NoAccess"));
	}
	
}
