package Icebox.events;

import Icebox.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    Main plugin;

    public QuitEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        if (plugin.chatFormat.get(player.getName()) == null ) {
            plugin.chatFormat.remove(player.getName());
        }

        if (plugin.nametagFormat.get(player.getName()) == null) {
            plugin.nametagFormat.remove(player.getName());
        }

    }
}
