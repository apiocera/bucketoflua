package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.server.ServerListener;

public class RunnerServerListener extends ServerListener {
	private EventDispatcher dispatcher;

	public RunnerServerListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onPluginEnable(org.bukkit.event.server.PluginEnableEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPluginDisable(org.bukkit.event.server.PluginDisableEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onServerCommand(org.bukkit.event.server.ServerCommandEvent event) {
		dispatcher.raiseEvent(event);
	}
}
