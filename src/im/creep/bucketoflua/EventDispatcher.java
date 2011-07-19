package im.creep.bucketoflua;

import im.creep.bucketoflua.listeners.*;
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
	private RunnerInventoryListener inventoryListener;
	private RunnerServerListener serverListener;
	private RunnerVehicleListener vehicleListener;
	private RunnerWeatherListener weatherListener;

	public EventDispatcher(Plugin pl) {
		thisPlugin = pl;
		thisManager = pl.getServer().getPluginManager();

		playerListener = new RunnerPlayerListener(this);
		blockListener = new RunnerBlockListener(this);
		entityListener = new RunnerEntityListener(this);
		inventoryListener = new RunnerInventoryListener(this);
		serverListener = new RunnerServerListener(this);
		vehicleListener = new RunnerVehicleListener(this);
		weatherListener = new RunnerWeatherListener(this);
	}

	public void registerListener(LuaEventListener Listener) {
		listeners.add(Listener);
	}

	public void subscribeTo(Event.Type Type, Event.Priority Priority) {
		if (!subscriptions.contains(Type)) {
			// If one subscribes twice to the same event, one will encounter two calls with that event.
			// That's why I am checking for this.

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
				case INVENTORY:
					thisManager.registerEvent(Type, inventoryListener, Priority, thisPlugin);
					break;
				case SERVER:
					thisManager.registerEvent(Type, serverListener, Priority, thisPlugin);
					break;
				case VEHICLE:
					thisManager.registerEvent(Type, vehicleListener, Priority, thisPlugin);
					break;
				case WEATHER:
					thisManager.registerEvent(Type, weatherListener, Priority, thisPlugin);
					break;
			}

		}
	}

	public List<LuaEventListener> getListeners() {
		return listeners;
	}


	public void reset() {
		listeners.clear();
	}
}
