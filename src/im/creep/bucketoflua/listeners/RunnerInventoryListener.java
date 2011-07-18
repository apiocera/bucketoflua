package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.inventory.InventoryListener;

public class RunnerInventoryListener extends InventoryListener {
	private EventDispatcher dispatcher;

	public RunnerInventoryListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onFurnaceSmelt(org.bukkit.event.inventory.FurnaceSmeltEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onFurnaceSmelt(event);
	}

	public void onFurnaceBurn(org.bukkit.event.inventory.FurnaceBurnEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onFurnaceBurn(event);
	}
}
