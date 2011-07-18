package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockListener;

public class RunnerBlockListener extends BlockListener {
	private EventDispatcher dispatcher;

	public RunnerBlockListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	private void processEvent(Event ev) {
		dispatcher.raiseCall(ev);
	}

	public void onBlockDamage(org.bukkit.event.block.BlockDamageEvent event) {
		processEvent(event);
	}

	public void onBlockCanBuild(org.bukkit.event.block.BlockCanBuildEvent event) {
		processEvent(event);
	}

	public void onBlockFromTo(org.bukkit.event.block.BlockFromToEvent event) {
		processEvent(event);
	}

	public void onBlockIgnite(org.bukkit.event.block.BlockIgniteEvent event) {
		processEvent(event);
	}

	public void onBlockPhysics(org.bukkit.event.block.BlockPhysicsEvent event) {
		processEvent(event);
	}

	public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
		processEvent(event);
	}

	public void onBlockRedstoneChange(org.bukkit.event.block.BlockRedstoneEvent event) {
		processEvent(event);
	}

	public void onLeavesDecay(org.bukkit.event.block.LeavesDecayEvent event) {
		processEvent(event);
	}

	public void onSignChange(org.bukkit.event.block.SignChangeEvent event) {
		processEvent(event);
	}

	public void onBlockBurn(org.bukkit.event.block.BlockBurnEvent event) {
		processEvent(event);
	}

	public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
		processEvent(event);
	}
}
