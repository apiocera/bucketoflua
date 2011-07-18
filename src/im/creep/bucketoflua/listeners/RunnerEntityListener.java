package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.entity.EntityListener;

public class RunnerEntityListener extends EntityListener {
	private EventDispatcher dispatcher;

	public RunnerEntityListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onCreatureSpawn(org.bukkit.event.entity.CreatureSpawnEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onCreatureSpawn(event);
	}

	public void onItemSpawn(org.bukkit.event.entity.ItemSpawnEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onItemSpawn(event);
	}

	public void onEntityCombust(org.bukkit.event.entity.EntityCombustEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityCombust(event);
	}

	public void onEntityDamage(org.bukkit.event.entity.EntityDamageEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityDamage(event);
	}

	public void onEntityExplode(org.bukkit.event.entity.EntityExplodeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityExplode(event);
	}

	public void onExplosionPrime(org.bukkit.event.entity.ExplosionPrimeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onExplosionPrime(event);
	}

	public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityDeath(event);
	}

	public void onEntityTarget(org.bukkit.event.entity.EntityTargetEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityTarget(event);
	}

	public void onEntityInteract(org.bukkit.event.entity.EntityInteractEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityInteract(event);
	}

	public void onEntityPortalEnter(org.bukkit.event.entity.EntityPortalEnterEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityPortalEnter(event);
	}

	public void onPaintingPlace(org.bukkit.event.painting.PaintingPlaceEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPaintingPlace(event);
	}

	public void onPaintingBreak(org.bukkit.event.painting.PaintingBreakEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPaintingBreak(event);
	}

	public void onPigZap(org.bukkit.event.entity.PigZapEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onPigZap(event);
	}

	public void onCreeperPower(org.bukkit.event.entity.CreeperPowerEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onCreeperPower(event);
	}

	public void onEntityTame(org.bukkit.event.entity.EntityTameEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityTame(event);
	}

	public void onEntityRegainHealth(org.bukkit.event.entity.EntityRegainHealthEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onEntityRegainHealth(event);
	}

	public void onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onProjectileHit(event);
	}
}
