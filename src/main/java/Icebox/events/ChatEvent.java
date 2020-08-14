package Icebox.events;

import Icebox.Main;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;

public class ChatEvent implements Listener {

    Main plugin;

    public ChatEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onChat(PlayerChatEvent event) {

    }
}
