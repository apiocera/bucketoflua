package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.vehicle.VehicleListener;

public class RunnerVehicleListener extends VehicleListener {
	private EventDispatcher dispatcher;

	public RunnerVehicleListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onVehicleCreate(org.bukkit.event.vehicle.VehicleCreateEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleDamage(org.bukkit.event.vehicle.VehicleDamageEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleBlockCollision(org.bukkit.event.vehicle.VehicleBlockCollisionEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleEntityCollision(org.bukkit.event.vehicle.VehicleEntityCollisionEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleEnter(org.bukkit.event.vehicle.VehicleEnterEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleExit(org.bukkit.event.vehicle.VehicleExitEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleMove(org.bukkit.event.vehicle.VehicleMoveEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleDestroy(org.bukkit.event.vehicle.VehicleDestroyEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onVehicleUpdate(org.bukkit.event.vehicle.VehicleUpdateEvent event) {
		dispatcher.raiseEvent(event);
	}
}
