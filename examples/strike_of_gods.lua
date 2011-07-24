function kill_meh(sender, cmdargs)
	if not assistant:isPlayer(sender) then
		sender:sendMessage("Only players can be struck by lightning!")
		return
	end

	if location == nil then
		sender:sendMessage("Set a location to punish first!")
		return
	end

	local world = sender:getWorld()
	world:strikeLightning(location)
	world:createExplosion(location:getX(), location:getY(), location:getZ(), 18, true)
end


function set_punishment_location(sender, cmdargs)
	if not assistant:isPlayer(sender) then
		sender:sendMessage("Only players can be struck by lightning!")
		return
	end

	location = sender:getLocation()
end

function nuke(s,  a)
	set_punishment_location(s, n, a)
	kill_meh(s, n, a)
end

dispatcher:registerCommand("punish", kill_meh)
dispatcher:registerCommand("spl", set_punishment_location)
dispatcher:registerCommand("nuke", nuke)