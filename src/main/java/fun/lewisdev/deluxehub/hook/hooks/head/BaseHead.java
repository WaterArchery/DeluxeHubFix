package fun.lewisdev.deluxehub.hook.hooks.head;

import dev.dbassett.skullcreator.SkullCreator;
import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.hook.PluginHook;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.Map;

public class BaseHead implements PluginHook, HeadHook {

    private Map<String, ItemStack> cache;

    @Override
    public void onEnable(DeluxeHubPlugin plugin) {
        cache = new HashMap<>();
    }

    @Override
    public ItemStack getHead(String data) {
        if (cache.containsKey(data)) return cache.get(data);

        ItemStack head = SkullCreator.itemFromBase64(data);

        cache.put(data, head);
        return head;
    }
}
