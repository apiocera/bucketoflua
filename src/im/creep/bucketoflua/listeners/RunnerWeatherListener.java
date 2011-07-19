package im.creep.bucketoflua.listeners;

import im.creep.bucketoflua.EventDispatcher;
import org.bukkit.event.weather.WeatherListener;

public class RunnerWeatherListener extends WeatherListener {
	private EventDispatcher dispatcher;

	public RunnerWeatherListener(EventDispatcher dsp) {
		dispatcher = dsp;
	}

	public void onWeatherChange(org.bukkit.event.weather.WeatherChangeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onThunderChange(org.bukkit.event.weather.ThunderChangeEvent event) {
		dispatcher.raiseEvent(event);
	}

	public void onLightningStrike(org.bukkit.event.weather.LightningStrikeEvent event) {
		dispatcher.raiseEvent(event);
	}
}
