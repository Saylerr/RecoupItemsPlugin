package pl.sayler.recoupitems.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import pl.sayler.recoupitems.RecoupItems;
import pl.sayler.recoupitems.manager.RecoupItemsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerDeath implements Listener {
    private final RecoupItemsManager recoupItemsManager  =  RecoupItems.getRecoupItemsManager();
    private final Random random = new Random();
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        List<ItemStack> drops = event.getDrops();
        List<ItemStack> itemsToSave = new ArrayList<>();

        for(int i = 0; i < drops.size() / 2; i++){
            ItemStack itemStack = drops.get(random.nextInt(drops.size()));

            event.getDrops().remove(itemStack);
            itemsToSave.add(itemStack);
        }
        this.recoupItemsManager.setItems(player, itemsToSave);
    }
}
