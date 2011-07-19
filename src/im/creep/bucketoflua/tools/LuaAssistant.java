package im.creep.bucketoflua.tools;

import org.bukkit.entity.Player;

public class LuaAssistant {
	public static boolean isPlayer(Object obj){
		return (obj instanceof Player);
	}
}
