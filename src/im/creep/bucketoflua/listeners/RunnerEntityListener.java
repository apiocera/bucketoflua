package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityListener;

public class RunnerEntityListener extends EntityListener {
	private EventDispatcher dispatcher;

	public RunnerEntityListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	private void processEvent(Event ev) {
		dispatcher.raiseCall(ev);
	}

	public void onCreatureSpawn(org.bukkit.event.entity.CreatureSpawnEvent event) {
		processEvent(event);
	}

	public void onItemSpawn(org.bukkit.event.entity.ItemSpawnEvent event) {
		processEvent(event);
	}

	public void onEntityCombust(org.bukkit.event.entity.EntityCombustEvent event) {
		processEvent(event);
	}

	public void onEntityDamage(org.bukkit.event.entity.EntityDamageEvent event) {
		processEvent(event);
	}

	public void onEntityExplode(org.bukkit.event.entity.EntityExplodeEvent event) {
		processEvent(event);
	}

	public void onExplosionPrime(org.bukkit.event.entity.ExplosionPrimeEvent event) {
		processEvent(event);
	}

	public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
		processEvent(event);
	}

	public void onEntityTarget(org.bukkit.event.entity.EntityTargetEvent event) {
		processEvent(event);
	}

	public void onEntityInteract(org.bukkit.event.entity.EntityInteractEvent event) {
		processEvent(event);
	}

	public void onEntityPortalEnter(org.bukkit.event.entity.EntityPortalEnterEvent event) {
		processEvent(event);
	}

	public void onPaintingPlace(org.bukkit.event.painting.PaintingPlaceEvent event) {
		processEvent(event);
	}

	public void onPaintingBreak(org.bukkit.event.painting.PaintingBreakEvent event) {
		processEvent(event);
	}

	public void onPigZap(org.bukkit.event.entity.PigZapEvent event) {
		processEvent(event);
	}

	public void onCreeperPower(org.bukkit.event.entity.CreeperPowerEvent event) {
		processEvent(event);
	}

	public void onEntityTame(org.bukkit.event.entity.EntityTameEvent event) {
		processEvent(event);
	}

	public void onEntityRegainHealth(org.bukkit.event.entity.EntityRegainHealthEvent event) {
		processEvent(event);
	}

	public void onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent event) {
		processEvent(event);
	}
}
