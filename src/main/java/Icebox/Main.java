package Icebox;

import Icebox.events.*;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Main extends PluginBase {

    public Config config;

    @Override
    public void onEnable() {

        // load configuration
        saveDefaultConfig();
        config = getConfig();

        // register plugin events
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
    }
}

