package im.creep.bucketoflua;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;

public class CommandListener extends PlayerListener {
	private EventDispatcher dispatcher;

	public CommandListener(EventDispatcher dsp){
		dispatcher = dsp;
	}

	public void onPlayerCommandPreprocess (PlayerCommandPreprocessEvent ev){
		if (dispatcher.parseCommand(ev)) {
			ev.setCancelled(true);
		};
	}
}
