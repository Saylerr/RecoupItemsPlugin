package pl.sayler.recoupitems;

import org.bukkit.plugin.java.JavaPlugin;
import pl.sayler.recoupitems.listeners.PlayerDeath;
import pl.sayler.recoupitems.listeners.PlayerRespawn;
import pl.sayler.recoupitems.manager.RecoupItemsManager;

public final class RecoupItems extends JavaPlugin {
    private static final RecoupItemsManager recoupItemsManager = new RecoupItemsManager();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
    }

    @Override
    public void onDisable() {

    }

    public static RecoupItemsManager getRecoupItemsManager() {
        return recoupItemsManager;
    }
}
