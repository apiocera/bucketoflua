function broken(event)
	local player = event:getPlayer()
	local block = event:getBlock()
	local id = block:getTypeId()
	player:chat("i broke block id " .. id)
end

dispatcher:registerListener(MC_EVENT_BLOCK_BREAK, broken)