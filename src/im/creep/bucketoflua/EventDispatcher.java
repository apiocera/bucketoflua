package im.creep.bucketoflua;

import im.creep.bucketoflua.listeners.RunnerPlayerListener;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {
	private List<LuaEventListener> listeners = new ArrayList<LuaEventListener>();
	private List<Event.Type> subscriptions = new ArrayList<Event.Type>();

	private Plugin thisPlugin;
	private PluginManager thisManager;

	private RunnerPlayerListener playerListener;

	public EventDispatcher(Plugin pl) {
		thisPlugin = pl;
		thisManager = pl.getServer().getPluginManager();
		playerListener = new RunnerPlayerListener(this);
	}

	public void registerListener(LuaEventListener Listener) {
		listeners.add(Listener);
	}

	public void subscribeTo(Event.Type Type, Event.Priority Priority) {
		if (!subscriptions.contains(Type)) {
			subscriptions.add(Type);
			thisManager.registerEvent(Type, playerListener, Priority, thisPlugin);
		}
	}

	public void raiseCall(Event ev) {
		for (LuaEventListener lst : listeners) {
			lst.onAnyEvent(ev);
		}
	}

	public void reset() {
		listeners.clear();
	}
}
