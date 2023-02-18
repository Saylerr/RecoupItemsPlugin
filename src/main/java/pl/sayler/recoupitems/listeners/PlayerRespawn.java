package pl.sayler.recoupitems.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import pl.sayler.recoupitems.manager.RecoupItemsManager;
import pl.sayler.recoupitems.RecoupItems;

import java.util.List;

public class PlayerRespawn implements Listener {
    private final RecoupItemsManager recoupItemsManager  =  RecoupItems.getRecoupItemsManager();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        if(!this.recoupItemsManager.hasItems(player)) return;

        List<ItemStack> items = this.recoupItemsManager.getItems(player);

        for(ItemStack itemStacks : items){
            event.getPlayer().getInventory().addItem(itemStacks);
        }

        this.recoupItemsManager.removeItems(player);
    }
}
