package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.player.PlayerListener;

public class RunnerPlayerListener extends PlayerListener {
	private EventDispatcher dispatcher;

	public RunnerPlayerListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerJoin(event);
	}

	public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerQuit(event);
	}

	public void onPlayerKick(org.bukkit.event.player.PlayerKickEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerKick(event);
	}

	public void onPlayerChat(org.bukkit.event.player.PlayerChatEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerChat(event);
	}

	public void onPlayerCommandPreprocess(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerCommandPreprocess(event);
	}

	public void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerMove(event);
	}

	public void onPlayerTeleport(org.bukkit.event.player.PlayerTeleportEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerTeleport(event);
	}

	public void onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerRespawn(event);
	}

	public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerInteract(event);
	}

	public void onPlayerInteractEntity(org.bukkit.event.player.PlayerInteractEntityEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerInteractEntity(event);
	}

	public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerLogin(event);
	}

	public void onPlayerPreLogin(org.bukkit.event.player.PlayerPreLoginEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerPreLogin(event);
	}

	public void onPlayerEggThrow(org.bukkit.event.player.PlayerEggThrowEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerEggThrow(event);
	}

	public void onPlayerAnimation(org.bukkit.event.player.PlayerAnimationEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerAnimation(event);
	}

	public void onInventoryOpen(org.bukkit.event.player.PlayerInventoryEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onInventoryOpen(event);
	}

	public void onItemHeldChange(org.bukkit.event.player.PlayerItemHeldEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onItemHeldChange(event);
	}

	public void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerDropItem(event);
	}

	public void onPlayerPickupItem(org.bukkit.event.player.PlayerPickupItemEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerPickupItem(event);
	}

	public void onPlayerToggleSneak(org.bukkit.event.player.PlayerToggleSneakEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerToggleSneak(event);
	}

	public void onPlayerBucketFill(org.bukkit.event.player.PlayerBucketFillEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerBucketFill(event);
	}

	public void onPlayerBucketEmpty(org.bukkit.event.player.PlayerBucketEmptyEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerBucketEmpty(event);
	}

	public void onPlayerBedEnter(org.bukkit.event.player.PlayerBedEnterEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerBedEnter(event);
	}

	public void onPlayerBedLeave(org.bukkit.event.player.PlayerBedLeaveEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerBedLeave(event);
	}

	public void onPlayerPortal(org.bukkit.event.player.PlayerPortalEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPlayerPortal(event);
	}
}
