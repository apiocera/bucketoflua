package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerListener;

public class RunnerPlayerListener extends PlayerListener {
	private EventDispatcher dispatcher;

	public RunnerPlayerListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	private void processEvent(Event ev) {
		dispatcher.raiseCall(ev);
	}

	public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
		processEvent(event);
	}

	public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
		processEvent(event);
	}

	public void onPlayerKick(org.bukkit.event.player.PlayerKickEvent event) {
		processEvent(event);
	}

	public void onPlayerChat(org.bukkit.event.player.PlayerChatEvent event) {
		processEvent(event);
	}

	public void onPlayerCommandPreprocess(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
		processEvent(event);
	}

	public void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent event) {
		processEvent(event);
	}

	public void onPlayerTeleport(org.bukkit.event.player.PlayerTeleportEvent event) {
		processEvent(event);
	}

	public void onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent event) {
		processEvent(event);
	}

	public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent event) {
		processEvent(event);
	}

	public void onPlayerInteractEntity(org.bukkit.event.player.PlayerInteractEntityEvent event) {
		processEvent(event);
	}

	public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
		processEvent(event);
	}

	public void onPlayerPreLogin(org.bukkit.event.player.PlayerPreLoginEvent event) {
		processEvent(event);
	}

	public void onPlayerEggThrow(org.bukkit.event.player.PlayerEggThrowEvent event) {
		processEvent(event);
	}

	public void onPlayerAnimation(org.bukkit.event.player.PlayerAnimationEvent event) {
		processEvent(event);
	}

	public void onInventoryOpen(org.bukkit.event.player.PlayerInventoryEvent event) {
		processEvent(event);
	}

	public void onItemHeldChange(org.bukkit.event.player.PlayerItemHeldEvent event) {
		processEvent(event);
	}

	public void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
		processEvent(event);
	}

	public void onPlayerPickupItem(org.bukkit.event.player.PlayerPickupItemEvent event) {
		processEvent(event);
	}

	public void onPlayerToggleSneak(org.bukkit.event.player.PlayerToggleSneakEvent event) {
		processEvent(event);
	}

	public void onPlayerBucketFill(org.bukkit.event.player.PlayerBucketFillEvent event) {
		processEvent(event);
	}

	public void onPlayerBucketEmpty(org.bukkit.event.player.PlayerBucketEmptyEvent event) {
		processEvent(event);
	}

	public void onPlayerBedEnter(org.bukkit.event.player.PlayerBedEnterEvent event) {
		processEvent(event);
	}

	public void onPlayerBedLeave(org.bukkit.event.player.PlayerBedLeaveEvent event) {
		processEvent(event);
	}

	public void onPlayerPortal(org.bukkit.event.player.PlayerPortalEvent event) {
		processEvent(event);
	}
}
