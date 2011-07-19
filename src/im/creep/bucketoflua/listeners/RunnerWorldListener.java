package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.world.WorldListener;

public class RunnerWorldListener extends WorldListener {
	private EventDispatcher dispatcher;

	public RunnerWorldListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onChunkLoad(org.bukkit.event.world.ChunkLoadEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onChunkPopulate(org.bukkit.event.world.ChunkPopulateEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onChunkUnload(org.bukkit.event.world.ChunkUnloadEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onSpawnChange(org.bukkit.event.world.SpawnChangeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPortalCreate(org.bukkit.event.world.PortalCreateEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onWorldSave(org.bukkit.event.world.WorldSaveEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onWorldInit(org.bukkit.event.world.WorldInitEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onWorldLoad(org.bukkit.event.world.WorldLoadEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onWorldUnload(org.bukkit.event.world.WorldUnloadEvent event) {
		dispatcher.raiseEvent(event);
	}
}
