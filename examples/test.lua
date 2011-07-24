function dmg(event)
	if assistant:isPlayer(event:getEntity()) then
		event:setCancelled(true)
	end
end

dispatcher:registerListener(MC_EVENT_ENTITY_DAMAGE, dmg)