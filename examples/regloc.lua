function regloc(s, n)
	loc = s:getLocation()
end

function warp(s, n) 
	s:teleport(loc)
end

dispatcher:registerCommand("set", regloc)
dispatcher:registerCommand("warp", warp) 