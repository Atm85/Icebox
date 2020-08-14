package Icebox;

import Icebox.events.*;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import com.creeperface.nukkit.placeholderapi.api.PlaceholderAPI;

public class Main extends PluginBase {

    /**
     * Plugin config
     */
    public Config config;

    /**
     * PlaceholderAPI
     */
    public PlaceholderAPI placeholderAPI;

    @Override
    public void onEnable() {

        // load configuration
        saveDefaultConfig();
        config = getConfig();

        // load placeholder api
        placeholderAPI = PlaceholderAPI.getInstance();

        // register plugin events
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
    }
}

