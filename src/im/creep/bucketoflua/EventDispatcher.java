package im.creep.bucketoflua;

import im.creep.bucketoflua.listeners.RunnerBlockListener;
import im.creep.bucketoflua.listeners.RunnerEntityListener;
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
	private RunnerBlockListener blockListener;
	private RunnerEntityListener entityListener;

	public EventDispatcher(Plugin pl) {
		thisPlugin = pl;
		thisManager = pl.getServer().getPluginManager();

		playerListener = new RunnerPlayerListener(this);
		blockListener = new RunnerBlockListener(this);
		entityListener = new RunnerEntityListener(this);
	}

	public void registerListener(LuaEventListener Listener) {
		listeners.add(Listener);
	}

	public void subscribeTo(Event.Type Type, Event.Priority Priority) {
		if (!subscriptions.contains(Type)) {
			// If one subscribes twice to the same event, one will encounter two calls with that event.
			// That's why I am checking for this awesomeness.

			// When it WILL go wrong: when two snips subscribe to the same event, but request different priority.
			// They will get the event at the same time with priority depending on who's been first to subscribe.
			subscriptions.add(Type);
			switch (Type.getCategory()) {
				case PLAYER:
					thisManager.registerEvent(Type, playerListener, Priority, thisPlugin);
					break;
				case BLOCK:
					thisManager.registerEvent(Type, blockListener, Priority, thisPlugin);
					break;
				case ENTITY:
					thisManager.registerEvent(Type, entityListener, Priority, thisPlugin);
					break;
			}

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
