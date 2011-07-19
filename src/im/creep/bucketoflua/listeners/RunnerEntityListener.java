package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.entity.EntityListener;

public class RunnerEntityListener extends EntityListener {
	private EventDispatcher dispatcher;

	public RunnerEntityListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onCreatureSpawn(org.bukkit.event.entity.CreatureSpawnEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onItemSpawn(org.bukkit.event.entity.ItemSpawnEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityCombust(org.bukkit.event.entity.EntityCombustEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityDamage(org.bukkit.event.entity.EntityDamageEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityExplode(org.bukkit.event.entity.EntityExplodeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onExplosionPrime(org.bukkit.event.entity.ExplosionPrimeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityTarget(org.bukkit.event.entity.EntityTargetEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityInteract(org.bukkit.event.entity.EntityInteractEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityPortalEnter(org.bukkit.event.entity.EntityPortalEnterEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPaintingPlace(org.bukkit.event.painting.PaintingPlaceEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPaintingBreak(org.bukkit.event.painting.PaintingBreakEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onPigZap(org.bukkit.event.entity.PigZapEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onCreeperPower(org.bukkit.event.entity.CreeperPowerEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityTame(org.bukkit.event.entity.EntityTameEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onEntityRegainHealth(org.bukkit.event.entity.EntityRegainHealthEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent event) {
		dispatcher.raiseEvent(event);
	}
}
