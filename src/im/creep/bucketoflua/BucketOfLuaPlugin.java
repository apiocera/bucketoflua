package im.creep.bucketoflua;

import im.creep.bucketoflua.luaengine.LuaLangEngine;
import im.creep.bucketoflua.tools.BetterConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class BucketOfLuaPlugin extends JavaPlugin {
	String mainDir;
	String configurationFile = "BucketOfLua.yml";
	String logPrefix;
	BetterConfig config;
	Boolean failedOnStart = false;

	Boolean running = false;

	LuaLangEngine langEngine;

	public Logger getLogger() {
		return log;
	}

	Logger log = Logger.getLogger("Minecraft");
	EventDispatcher dispatcher;

	public void onEnable() {
		dispatcher = new EventDispatcher(this);

		PluginDescriptionFile pdfFile = this.getDescription();
		logPrefix = "[" + pdfFile.getName() + "]: ";
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");

		mainDir = getDataFolder().getAbsolutePath();

		// Creating a config directory if it doesn't exist yet
		File mD = new File(mainDir);
		if (!mD.exists()) {
			if (!(new File(mainDir).mkdir())) {
				log.severe(logPrefix + "config directory not present and unable to be made. No operations follow.");
				failedOnStart = true;
				return;
			}
		}

		config = new BetterConfig(new File(mainDir, configurationFile));
		config.load();

		// Configuring Lua VMs
		langEngine = new LuaLangEngine(getSnipList(), log, mainDir);
		langEngine.setLogPrefix(logPrefix);
		langEngine.load();

		// Publishing dispatcher and Event.Types
		langEngine.publishObject("dispatcher", dispatcher);
		for (Event.Type ev : Event.Type.values()) {
			langEngine.publishObject("MC_EVENT_" + ev.toString(), ev); // this is the most sane way to push Java enums into Lua
		}

		// Finally, running
		langEngine.run();
		running = true;
		config.save();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equals("l")) {
			if (args.length < 1) return false;
			dispatcher.runCommand(sender, args[0], args);
			return true;
		}

		if (commandLabel.equals("lua")) {
			if (args.length < 1) return false;
			if (args[0].equals("reset")) {
				resetPlugin();
				sender.sendMessage("OK, scripts are resetted.");
				return true;
			}

			if (args[0].equals("run")) {
				if (running) {
					sender.sendMessage("Already running.");
				} else {
					runPlugin();
					sender.sendMessage("OK, scripts are running.");

				}
				return true;
			}

			if (args[0].equals("stop")) {
				if (!running) {
					sender.sendMessage("Already stopped.");
				} else {
					stopPlugin();
					sender.sendMessage("OK, scripts are stopped.");
				}
				return true;
			}

			// Not now.
			/*if (args[0].equals("console")){
				if (args.length < 2){

				}
			}*/
		}
		return false;

	}

	public void onDisable() {
		log.info(logPrefix + "is disabled!");
		if (!failedOnStart) langEngine.unload();
	}

	private List<Object> getSnipList() {
		return config.getList("snips");
	}


	// ...and now command actors
	private void resetPlugin() {
		stopPlugin();
		runPlugin();
	}

	private void runPlugin() {
		running = true;
		langEngine.load();
		langEngine.run();
	}

	private void stopPlugin() {
		running = false;
		dispatcher.reset();
		langEngine.unload();
	}
}
