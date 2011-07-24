should_announce = false
function onJoin(event)
  local player = event:getPlayer()
  print(player:getName())
  player:chat("i connected")
  return true
end

function moving(event)
	local player = event:getPlayer()
	local loc = player:getEyeLocation()
	if should_announce then player:chat("my location: " .. loc:getX() .. ", " .. loc:getZ()) end
end


-- commands
function shut_up(sender, cmdargs)
	should_announce = false
	sender:sendMessage("no more word")
end

function speak(sender, cmdargs)
	should_announce = true
	sender:sendMessage("okay, speaking starting now")
end

dispatcher:registerListener(MC_EVENT_PLAYER_JOIN, onJoin)
dispatcher:registerListener(MC_EVENT_PLAYER_MOVE, moving)

dispatcher:registerCommand("shutup", shut_up)
dispatcher:registerCommand("speak", speak)