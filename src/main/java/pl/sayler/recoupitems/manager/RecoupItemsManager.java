package pl.sayler.recoupitems.manager;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class RecoupItemsManager {
    private static final HashMap<Player, List<ItemStack>> items = new HashMap<>();

    public boolean hasItems(Player player){
         return items.containsKey(player) && items.get(player).size() > 0;
    }

    public void setItems(Player player, List<ItemStack> items){
        RecoupItemsManager.items.put(player, items);
    }
    public void removeItems(Player player){
        if(!hasItems(player)) return;
        RecoupItemsManager.items.remove(player);
    }

    public List<ItemStack> getItems(Player player){
        if(!hasItems(player)) return null;
        return items.get(player);
    }
}
