function oh_the_pain(event)
	local player = event:getPlayer()
	if event:getMaterial():equals(MC_MATERIAL_AIR) then
		if event:getAction():equals(MC_ACTION_LEFT_CLICK_BLOCK) then
			player:damage(1)
		end
	end
end

dispatcher:registerListener(MC_EVENT_PLAYER_INTERACT, oh_the_pain)