package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.server.ServerListener;

public class RunnerServerListener extends ServerListener {
	private EventDispatcher dispatcher;

	public RunnerServerListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onPluginEnable(org.bukkit.event.server.PluginEnableEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPluginEnable(event);
	}

	public void onPluginDisable(org.bukkit.event.server.PluginDisableEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPluginDisable(event);
	}

	public void onServerCommand(org.bukkit.event.server.ServerCommandEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onServerCommand(event);
	}
}
