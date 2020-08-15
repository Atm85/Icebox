package Icebox.events;

import Icebox.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import net.luckperms.api.model.user.User;

import java.util.Map;

public class JoinEvent implements Listener {

    Main plugin;

    Map<String, String> configValue;

    public JoinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        User luckpermsUser = plugin.luckPerms.getUserManager().getUser(player.getUniqueId());

        assert luckpermsUser != null;
        String group = luckpermsUser.getPrimaryGroup();

        configValue = (Map<String, String>) plugin.config.get(group);
        if (configValue == null) {
            luckpermsUser.setPrimaryGroup("default");
            configValue = (Map<String, String>) plugin.config.get("default");
            plugin.getLogger().warning("group " + group + " format not fount! setting default group format");
        }

        plugin.chatFormat.put(player.getName(), configValue.get("chat-format"));
        plugin.nametagFormat.put(player.getName(), configValue.get("nametag"));
    }
}
