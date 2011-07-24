function nice_day(sender, cmdargs)
	if not assistant:isPlayer(sender) then
		sender:sendMessage("Only players can manipulate weather!")
		return
	end

	local world = sender:getWorld()

	world:setStorm(false)
	world:setThundering(false)
	world:setFullTime(0)
end

dispatcher:registerCommand("nice", nice_day)