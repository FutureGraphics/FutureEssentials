package future.code.essentials.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import future.code.essentials.main.main;

public class PlayerManager {

	private File file;
	private main plugin;
	private static FileConfiguration config;
	public PlayerManager(main plugin) {
		this.plugin = plugin;
		file = new File(this.plugin.getDataFolder(), "players.yml");
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
	
}
