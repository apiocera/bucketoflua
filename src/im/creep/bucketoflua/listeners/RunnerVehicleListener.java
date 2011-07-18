package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.vehicle.VehicleListener;

public class RunnerVehicleListener extends VehicleListener {
	private EventDispatcher dispatcher;

	public RunnerVehicleListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onVehicleCreate(org.bukkit.event.vehicle.VehicleCreateEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleCreate(event);
	}

	public void onVehicleDamage(org.bukkit.event.vehicle.VehicleDamageEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleDamage(event);
	}

	public void onVehicleBlockCollision(org.bukkit.event.vehicle.VehicleBlockCollisionEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleBlockCollision(event);
	}

	public void onVehicleEntityCollision(org.bukkit.event.vehicle.VehicleEntityCollisionEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleEntityCollision(event);
	}

	public void onVehicleEnter(org.bukkit.event.vehicle.VehicleEnterEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleEnter(event);
	}

	public void onVehicleExit(org.bukkit.event.vehicle.VehicleExitEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleExit(event);
	}

	public void onVehicleMove(org.bukkit.event.vehicle.VehicleMoveEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleMove(event);
	}

	public void onVehicleDestroy(org.bukkit.event.vehicle.VehicleDestroyEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleDestroy(event);
	}

	public void onVehicleUpdate(org.bukkit.event.vehicle.VehicleUpdateEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onVehicleUpdate(event);
	}
}
