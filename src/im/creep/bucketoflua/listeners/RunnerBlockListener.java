package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.block.BlockListener;

public class RunnerBlockListener extends BlockListener {
	private EventDispatcher dispatcher;

	public RunnerBlockListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onBlockDamage(org.bukkit.event.block.BlockDamageEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockDamage(event);
	}

	public void onBlockCanBuild(org.bukkit.event.block.BlockCanBuildEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockCanBuild(event);
	}

	public void onBlockFromTo(org.bukkit.event.block.BlockFromToEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockFromTo(event);
	}

	public void onBlockIgnite(org.bukkit.event.block.BlockIgniteEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockIgnite(event);
	}

	public void onBlockPhysics(org.bukkit.event.block.BlockPhysicsEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockPhysics(event);
	}

	public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockPlace(event);
	}

	public void onBlockRedstoneChange(org.bukkit.event.block.BlockRedstoneEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockRedstoneChange(event);
	}

	public void onLeavesDecay(org.bukkit.event.block.LeavesDecayEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onLeavesDecay(event);
	}

	public void onSignChange(org.bukkit.event.block.SignChangeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onSignChange(event);
	}

	public void onBlockBurn(org.bukkit.event.block.BlockBurnEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockBurn(event);
	}

	public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockBreak(event);
	}

	public void onBlockForm(org.bukkit.event.block.BlockFormEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockForm(event);
	}

	public void onBlockSpread(org.bukkit.event.block.BlockSpreadEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockSpread(event);
	}

	public void onBlockFade(org.bukkit.event.block.BlockFadeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockFade(event);
	}

	public void onBlockDispense(org.bukkit.event.block.BlockDispenseEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onBlockDispense(event);
	}
}
