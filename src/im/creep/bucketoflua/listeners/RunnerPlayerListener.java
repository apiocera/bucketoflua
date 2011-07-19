package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.player.PlayerListener;

public class RunnerPlayerListener extends PlayerListener {
	private EventDispatcher dispatcher;

	public RunnerPlayerListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerKick(org.bukkit.event.player.PlayerKickEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerChat(org.bukkit.event.player.PlayerChatEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerCommandPreprocess(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerTeleport(org.bukkit.event.player.PlayerTeleportEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerInteractEntity(org.bukkit.event.player.PlayerInteractEntityEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerPreLogin(org.bukkit.event.player.PlayerPreLoginEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerEggThrow(org.bukkit.event.player.PlayerEggThrowEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerAnimation(org.bukkit.event.player.PlayerAnimationEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onInventoryOpen(org.bukkit.event.player.PlayerInventoryEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onItemHeldChange(org.bukkit.event.player.PlayerItemHeldEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerPickupItem(org.bukkit.event.player.PlayerPickupItemEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerToggleSneak(org.bukkit.event.player.PlayerToggleSneakEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerBucketFill(org.bukkit.event.player.PlayerBucketFillEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerBucketEmpty(org.bukkit.event.player.PlayerBucketEmptyEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerBedEnter(org.bukkit.event.player.PlayerBedEnterEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerBedLeave(org.bukkit.event.player.PlayerBedLeaveEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPlayerPortal(org.bukkit.event.player.PlayerPortalEvent event) {
		dispatcher.raiseEvent(event);
	}
}
