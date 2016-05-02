package cc.isotopestudio.CompassPower;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CompassPower extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("指南针").append("]").append(ChatColor.GREEN).toString();
	public static final String pluginName = "CompassPower";

	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new CompassListener(), this);
		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "成功卸载!");
	}

	public void onReload() {
		this.reloadConfig();
		getLogger().info(pluginName + "成功重载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
	}
}
