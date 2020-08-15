package Icebox;

import Icebox.events.*;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import com.creeperface.nukkit.placeholderapi.api.PlaceholderAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;

import java.util.HashMap;
import java.util.Map;

public class Main extends PluginBase {

    /**
     * Plugin config
     */
    public Config config;

    /**
     * Map containing the formatted string for a players chat output
     */
    public Map<String, String> chatFormat = new HashMap<>();

    /**
     * Map containing the formatted string for a players nametag
     */
    public Map<String, String> nametagFormat = new HashMap<>();

    /**
     * PlaceholderAPI
     */
    public PlaceholderAPI placeholderAPI;

    public LuckPerms luckPerms;

    @Override
    public void onEnable() {

        // load configuration
        saveDefaultConfig();
        config = getConfig();

        // load placeholder api
        placeholderAPI = PlaceholderAPI.getInstance();

        // load luckperms api
        luckPerms = LuckPermsProvider.get();

        // register plugin events
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);

        // create default formats for akk groups provided from luckperms
        loadAllGroups();
    }

    public void loadAllGroups() {
        for (Group group : luckPerms.getGroupManager().getLoadedGroups()) {
            if (getGroupFormats(group.getName()) == null) {
                Map<String, String> formatData = new HashMap<>();
                formatData.put("chat-format", "&l&8"+group.getName()+" &r%player% > %msg%");
                formatData.put("nametag", "&l&8"+group.getName()+" &r%player%");
                config.set(group.getName(), formatData);
            }
        }

        config.save();
    }

    public Map<String, String> getGroupFormats(String group) {
        return (Map<String, String>) config.get(group);
    }

    public String getChatFormat(Player player) {
        return placeholderAPI.translateString(chatFormat.get(player.getName()), player);
    }

    public String getNametagFormat(Player player) {
        return placeholderAPI.translateString(nametagFormat.get(player.getName()), player);
    }
}

