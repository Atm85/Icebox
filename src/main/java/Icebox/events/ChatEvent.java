package Icebox.events;

import Icebox.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.utils.TextFormat;

public class ChatEvent implements Listener {

    Main plugin;

    public ChatEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String content = event.getMessage();
        String raw_content = plugin.getChatFormat(player);
        String format_content = raw_content.replaceAll("msg", content);
        event.setFormat(TextFormat.colorize(format_content));
    }
}
