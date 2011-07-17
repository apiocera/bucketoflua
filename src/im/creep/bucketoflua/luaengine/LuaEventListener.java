package im.creep.bucketoflua.luaengine;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public interface LuaEventListener extends Listener {
	public void onAnyEvent(Event ev);
}
