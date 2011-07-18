package im.creep.bucketoflua.luaengine;

import org.bukkit.event.Listener;

public interface LuaEventListener extends Listener {
	public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event);

	public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event);

	public void onPlayerKick(org.bukkit.event.player.PlayerKickEvent event);

	public void onPlayerChat(org.bukkit.event.player.PlayerChatEvent event);

	public void onPlayerCommandPreprocess(org.bukkit.event.player.PlayerCommandPreprocessEvent event);

	public void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent event);

	public void onPlayerTeleport(org.bukkit.event.player.PlayerTeleportEvent event);

	public void onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent event);

	public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent event);

	public void onPlayerInteractEntity(org.bukkit.event.player.PlayerInteractEntityEvent event);

	public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event);

	public void onPlayerPreLogin(org.bukkit.event.player.PlayerPreLoginEvent event);

	public void onPlayerEggThrow(org.bukkit.event.player.PlayerEggThrowEvent event);

	public void onPlayerAnimation(org.bukkit.event.player.PlayerAnimationEvent event);

	public void onInventoryOpen(org.bukkit.event.player.PlayerInventoryEvent event);

	public void onItemHeldChange(org.bukkit.event.player.PlayerItemHeldEvent event);

	public void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event);

	public void onPlayerPickupItem(org.bukkit.event.player.PlayerPickupItemEvent event);

	public void onPlayerToggleSneak(org.bukkit.event.player.PlayerToggleSneakEvent event);

	public void onPlayerBucketFill(org.bukkit.event.player.PlayerBucketFillEvent event);

	public void onPlayerBucketEmpty(org.bukkit.event.player.PlayerBucketEmptyEvent event);

	public void onPlayerBedEnter(org.bukkit.event.player.PlayerBedEnterEvent event);

	public void onPlayerBedLeave(org.bukkit.event.player.PlayerBedLeaveEvent event);

	public void onPlayerPortal(org.bukkit.event.player.PlayerPortalEvent event);

	public void onBlockDamage(org.bukkit.event.block.BlockDamageEvent event);

	public void onBlockCanBuild(org.bukkit.event.block.BlockCanBuildEvent event);

	public void onBlockFromTo(org.bukkit.event.block.BlockFromToEvent event);

	public void onBlockIgnite(org.bukkit.event.block.BlockIgniteEvent event);

	public void onBlockPhysics(org.bukkit.event.block.BlockPhysicsEvent event);

	public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event);

	public void onBlockRedstoneChange(org.bukkit.event.block.BlockRedstoneEvent event);

	public void onLeavesDecay(org.bukkit.event.block.LeavesDecayEvent event);

	public void onSignChange(org.bukkit.event.block.SignChangeEvent event);

	public void onBlockBurn(org.bukkit.event.block.BlockBurnEvent event);

	public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event);

	public void onBlockForm(org.bukkit.event.block.BlockFormEvent event);

	public void onBlockSpread(org.bukkit.event.block.BlockSpreadEvent event);

	public void onBlockFade(org.bukkit.event.block.BlockFadeEvent event);

	public void onBlockDispense(org.bukkit.event.block.BlockDispenseEvent event);

	public void onCreatureSpawn(org.bukkit.event.entity.CreatureSpawnEvent event);

	public void onItemSpawn(org.bukkit.event.entity.ItemSpawnEvent event);

	public void onEntityCombust(org.bukkit.event.entity.EntityCombustEvent event);

	public void onEntityDamage(org.bukkit.event.entity.EntityDamageEvent event);

	public void onEntityExplode(org.bukkit.event.entity.EntityExplodeEvent event);

	public void onExplosionPrime(org.bukkit.event.entity.ExplosionPrimeEvent event);

	public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event);

	public void onEntityTarget(org.bukkit.event.entity.EntityTargetEvent event);

	public void onEntityInteract(org.bukkit.event.entity.EntityInteractEvent event);

	public void onEntityPortalEnter(org.bukkit.event.entity.EntityPortalEnterEvent event);

	public void onPaintingPlace(org.bukkit.event.painting.PaintingPlaceEvent event);

	public void onPaintingBreak(org.bukkit.event.painting.PaintingBreakEvent event);

	public void onPigZap(org.bukkit.event.entity.PigZapEvent event);

	public void onCreeperPower(org.bukkit.event.entity.CreeperPowerEvent event);

	public void onEntityTame(org.bukkit.event.entity.EntityTameEvent event);

	public void onEntityRegainHealth(org.bukkit.event.entity.EntityRegainHealthEvent event);

	public void onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent event);

	public void onFurnaceSmelt(org.bukkit.event.inventory.FurnaceSmeltEvent event);

	public void onFurnaceBurn(org.bukkit.event.inventory.FurnaceBurnEvent event);

	public void onPluginEnable(org.bukkit.event.server.PluginEnableEvent event);

	public void onPluginDisable(org.bukkit.event.server.PluginDisableEvent event);

	public void onServerCommand(org.bukkit.event.server.ServerCommandEvent event);

	public void onVehicleCreate(org.bukkit.event.vehicle.VehicleCreateEvent event);

	public void onVehicleDamage(org.bukkit.event.vehicle.VehicleDamageEvent event);

	public void onVehicleBlockCollision(org.bukkit.event.vehicle.VehicleBlockCollisionEvent event);

	public void onVehicleEntityCollision(org.bukkit.event.vehicle.VehicleEntityCollisionEvent event);

	public void onVehicleEnter(org.bukkit.event.vehicle.VehicleEnterEvent event);

	public void onVehicleExit(org.bukkit.event.vehicle.VehicleExitEvent event);

	public void onVehicleMove(org.bukkit.event.vehicle.VehicleMoveEvent event);

	public void onVehicleDestroy(org.bukkit.event.vehicle.VehicleDestroyEvent event);

	public void onVehicleUpdate(org.bukkit.event.vehicle.VehicleUpdateEvent event);

	public void onWeatherChange(org.bukkit.event.weather.WeatherChangeEvent event);

	public void onThunderChange(org.bukkit.event.weather.ThunderChangeEvent event);

	public void onLightningStrike(org.bukkit.event.weather.LightningStrikeEvent event);
}
