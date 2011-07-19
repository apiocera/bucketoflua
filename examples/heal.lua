function heal(sender, cName, cmdargs)
	if assistant:isPlayer(sender) then
		sender:setHealth(20)
	else
		sender:sendMessage("Only players can heal!")
	end
end

dispatcher:registerCommand("heal", heal)