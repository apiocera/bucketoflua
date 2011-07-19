package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.block.BlockListener;

public class RunnerBlockListener extends BlockListener {
	private EventDispatcher dispatcher;

	public RunnerBlockListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onBlockDamage(org.bukkit.event.block.BlockDamageEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockCanBuild(org.bukkit.event.block.BlockCanBuildEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockFromTo(org.bukkit.event.block.BlockFromToEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockIgnite(org.bukkit.event.block.BlockIgniteEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockPhysics(org.bukkit.event.block.BlockPhysicsEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockRedstoneChange(org.bukkit.event.block.BlockRedstoneEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onLeavesDecay(org.bukkit.event.block.LeavesDecayEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onSignChange(org.bukkit.event.block.SignChangeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockBurn(org.bukkit.event.block.BlockBurnEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockForm(org.bukkit.event.block.BlockFormEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockSpread(org.bukkit.event.block.BlockSpreadEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockFade(org.bukkit.event.block.BlockFadeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onBlockDispense(org.bukkit.event.block.BlockDispenseEvent event) {
		dispatcher.raiseEvent(event);
	}
}
