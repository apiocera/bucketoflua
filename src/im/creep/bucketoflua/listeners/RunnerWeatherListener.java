package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import im.creep.bucketoflua.luaengine.LuaEventListener;
import org.bukkit.event.weather.WeatherListener;

public class RunnerWeatherListener extends WeatherListener {
	private EventDispatcher dispatcher;

	public RunnerWeatherListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onWeatherChange(org.bukkit.event.weather.WeatherChangeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onWeatherChange(event);
	}

	public void onThunderChange(org.bukkit.event.weather.ThunderChangeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onThunderChange(event);
	}

	public void onLightningStrike(org.bukkit.event.weather.LightningStrikeEvent event) {
		for (LuaEventListener L : dispatcher.getListeners()) L.onLightningStrike(event);
	}
}
