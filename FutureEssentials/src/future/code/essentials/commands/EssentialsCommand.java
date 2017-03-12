package future.code.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import future.code.essentials.main.main;
import future.code.essentials.manager.LanguageManager;

public class EssentialsCommand implements CommandExecutor {

	private main plugin;
	
	public EssentialsCommand(main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("essentials.command")) {
				if(args.length > 0) {
					if(args[0].equalsIgnoreCase("reload")) {
						if(player.hasPermission("essentials.command.reload")) {
							plugin.getMainManager().load();
							player.sendMessage(main.prefix + "§8Essentials-§7MainManager: §aOK");
							plugin.getPlayerManager().load();
							player.sendMessage(main.prefix + "§8Essentials-§7PlayerManager: §aOK");
							plugin.getLanguageManager().load();
							player.sendMessage(main.prefix + "§8Essentials-§7LanguageManager: §aOK");
							player.sendMessage(LanguageManager.ReloadMessage());
						} else {
							player.sendMessage(main.noAccess);
						}

					}
				}
			} else {
				player.sendMessage(main.noAccess);
			}
		} else {
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					plugin.getMainManager().load();
					Bukkit.getConsoleSender().sendMessage("§8Essentials-§7MainManager: §aOK");
				}
			} else {
				sender.sendMessage("[ reload / author ]");
			}
		}
		return true;
	}

}
