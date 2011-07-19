package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.inventory.InventoryListener;

public class RunnerInventoryListener extends InventoryListener {
	private EventDispatcher dispatcher;

	public RunnerInventoryListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onFurnaceSmelt(org.bukkit.event.inventory.FurnaceSmeltEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onFurnaceBurn(org.bukkit.event.inventory.FurnaceBurnEvent event) {
		dispatcher.raiseEvent(event);
	}
}
