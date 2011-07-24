package im.creep.bucketoflua;

import im.creep.bucketoflua.listeners.*;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {
	private Map<String, LuaObject> commands = new HashMap<String, LuaObject>();
	private Map<Event.Type, ArrayList<LuaObject>> callbacks = new HashMap<Event.Type, ArrayList<LuaObject>>();
	private ArrayList<Event.Type> registeredEvents = new ArrayList<Event.Type>();

	private Plugin thisPlugin;
	private PluginManager thisManager;

	private RunnerBlockListener blockListener;
	private RunnerEntityListener entityListener;
	private RunnerInventoryListener inventoryListener;
	private RunnerPlayerListener playerListener;
	private RunnerServerListener serverListener;
	private RunnerVehicleListener vehicleListener;
	private RunnerWeatherListener weatherListener;
	private RunnerWorldListener worldListener;

	public EventDispatcher(Plugin pl) {
		thisPlugin = pl;
		thisManager = pl.getServer().getPluginManager();

		blockListener = new RunnerBlockListener(this);
		entityListener = new RunnerEntityListener(this);
		inventoryListener = new RunnerInventoryListener(this);
		playerListener = new RunnerPlayerListener(this);
		serverListener = new RunnerServerListener(this);
		vehicleListener = new RunnerVehicleListener(this);
		weatherListener = new RunnerWeatherListener(this);
		worldListener = new RunnerWorldListener(this);
	}

	// Interface functions for Lua scripts
	public boolean registerListener(Event.Type type, LuaObject Listener) {
		if (!Listener.isFunction()) {
			return false;
		}

		if (!callbacks.containsKey(type)) {
			ArrayList<LuaObject> newCallback = new ArrayList<LuaObject>();
			newCallback.add(Listener);
			callbacks.put(type, newCallback);

			if (!registeredEvents.contains(type)) {
				registerInManager(type, Event.Priority.Normal);
				registeredEvents.add(type);
			}
		} else {
			callbacks.get(type).add(Listener);
		}

		return true;
	}

	public boolean registerCommand(String cmd, LuaObject Listener) {
		if (!Listener.isFunction()) {
			return false;
		}

		if (commands.containsKey(cmd)) {
			return false;
		}

		commands.put(cmd, Listener);
		return true;
	}

	public Server getServer(){
		return thisPlugin.getServer();
	}

	// Interface for Java event handling
	public void raiseEvent(Event ev) {
		Event args[] = new Event[1];
		args[0] = ev;
		ArrayList<LuaObject> listeners = callbacks.get(ev.getType());

		if (listeners == null) return;

		for (LuaObject listener : listeners) {
			try {
				listener.call(args);
			} catch (LuaException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean parseCommand(PlayerCommandPreprocessEvent ev){
		for (Map.Entry<String, LuaObject> commandListener : commands.entrySet()){
			if (ev.getMessage().equals("/" + commandListener.getKey()) || ev.getMessage().startsWith("/" + commandListener.getKey() + " ")){
				Object args[] = new Object[2];
				args[0] = ev.getPlayer();
				args[1] = ev.getMessage();
				try {
					commandListener.getValue().call(args);
				} catch (LuaException e) {
					e.printStackTrace();
				}
				return true;
			}
		}

		return false;
	}


	public void reset() {
		callbacks.clear();
		commands.clear();
	}


	// Private tools
	private void registerInManager(Event.Type Type, Event.Priority Priority) {
		switch (Type.getCategory()) {
			case BLOCK:
				thisManager.registerEvent(Type, blockListener, Priority, thisPlugin);
				break;
			case ENTITY:
				thisManager.registerEvent(Type, entityListener, Priority, thisPlugin);
				break;
			case INVENTORY:
				thisManager.registerEvent(Type, inventoryListener, Priority, thisPlugin);
				break;
			case PLAYER:
				thisManager.registerEvent(Type, playerListener, Priority, thisPlugin);
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
			case LIVING_ENTITY:
				thisManager.registerEvent(Type, entityListener, Priority, thisPlugin);
				break;
			case WORLD:
				thisManager.registerEvent(Type, worldListener, Priority, thisPlugin);
				break;
			case MISCELLANEOUS:
				break;
		}
	}


}
