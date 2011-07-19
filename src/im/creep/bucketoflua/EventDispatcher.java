package im.creep.bucketoflua;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import im.creep.bucketoflua.listeners.*;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
	private HashMap<Event.Type, ArrayList<LuaObject>> callbacks = new HashMap<Event.Type, ArrayList<LuaObject>>();
	private ArrayList<Event.Type> registeredEvents = new ArrayList<Event.Type>();

	private HashMap<String, LuaObject> commands = new HashMap<String, LuaObject>();

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

	public boolean registerCommand(String cmd, LuaObject Listener){
		if (!Listener.isFunction()){
			return false;
		}

		if (commands.containsKey(cmd)){
			return false;
		}

		commands.put(cmd, Listener);
		return true;
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

	public void runCommand(CommandSender sender, String commandName, String[] cmdargs){
		if (commands.containsKey(commandName)){
			Object args[] = new Object[3];
			args[0] = sender;
			args[1] = commandName;
			args[2] = cmdargs;
			try {
				commands.get(commandName).call(args);
			} catch (LuaException e) {
				e.printStackTrace();
			}
		}
	}


	public void reset() {
		callbacks.clear();
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
