package cc.isotopestudio.CompassPower;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CompassListener implements Listener {

	@EventHandler
	public void onClickScroll(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		if (!item.getType().equals(Material.COMPASS))
			return;
		Player player = event.getPlayer();
		player.getWorld().strikeLightningEffect(player.getLocation());
		List<Player> players = player.getWorld().getPlayers();
		player.sendMessage(S.toPrefixGreen("�������λ��"));
		int count = 0;
		for (Player temp : players) {
			if (temp.equals(player))
				continue;
			count++;
			Location loc = temp.getLocation();
			player.sendMessage("         " + S.toGold(temp.getName())
					+ S.toYellow(" X: " + loc.getBlockX() + ", Y: " + loc.getBlockY() + ", Z: " + loc.getBlockZ()));
		}
		if (count < 1) {
			player.sendMessage(S.toRed("�������û�������������Ŷ"));
		}
		if (player.getWorld().getWorldBorder().getSize() >= 6E7) {
			player.sendMessage(S.toPrefixRed("�������û�б߽�"));
		} else {
			player.sendMessage(S.toPrefixGreen("����߽�"));
			Location loc = player.getWorld().getWorldBorder().getCenter();
			player.sendMessage("         "
					+ S.toYellow(" X: " + loc.getBlockX() + ", Y: " + loc.getBlockY() + ", Z: " + loc.getBlockZ())
					+ S.toGold(", ��Χ: " + player.getWorld().getWorldBorder().getSize()));
		}
	}
}
