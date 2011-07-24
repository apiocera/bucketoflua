package im.creep.bucketoflua;

import im.creep.bucketoflua.luaengine.LuaLangEngine;
import im.creep.bucketoflua.tools.BetterConfig;
import im.creep.bucketoflua.tools.LuaAssistant;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BucketOfLuaPlugin extends JavaPlugin {
	File mainDir;
	String configurationFile = "BucketOfLua.yml";
	String logPrefix;
	BetterConfig config;
	Boolean failedOnStart = false;

	Boolean running = false;

	LuaLangEngine langEngine;

	Logger log = Logger.getLogger("Minecraft");
	EventDispatcher dispatcher;

	CommandListener commandListener;

	public Logger getLogger() {
		return log;
	}

	public void onEnable() {
		dispatcher = new EventDispatcher(this);
		commandListener = new CommandListener(dispatcher);

		PluginDescriptionFile pdfFile = this.getDescription();
		logPrefix = "[" + pdfFile.getName() + "]: ";
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");

		mainDir = new File(getDataFolder().getAbsolutePath());

		// Creating a config directory if it doesn't exist yet
		if (!mainDir.exists()) {
			if (!mainDir.mkdir()) {
				log.severe(logPrefix + "config directory not present and unable to be made. No operations follow.");
				failedOnStart = true;
				return;
			}
		}

		config = new BetterConfig(new File(mainDir, configurationFile));
		config.load();

		// Configuring Lua VMs
		langEngine = new LuaLangEngine(log);
		langEngine.setSnipList(getSnipList());
		langEngine.setLogPrefix(logPrefix);
		langEngine.load();

		// Publishing dispatcher and Event.Types
		langEngine.publishObject("dispatcher", dispatcher);
		langEngine.publishObject("assistant", new LuaAssistant());
		publishEnums();


		// Finally, running
		langEngine.run();
		running = true;
		config.save();

		// and now registering command preprocessor
		this.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, commandListener, Event.Priority.Highest, this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (commandLabel.equals("lua")) {
			if (!sender.isOp()) {
				sender.sendMessage("You have to be an op to use Lua.");
				return true;
			}

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
		}
		return false;

	}

	public void onDisable() {
		log.info(logPrefix + "is disabled!");
		if (!failedOnStart) langEngine.unload();
	}

	private List<File> getSnipList() {
		List<File> snips = new ArrayList<File>();
		File[] children = mainDir.listFiles();
		if (children != null) {
			for (File f : children) {
				if (f.getName().endsWith(".lua")) snips.add(f);
			}
		}

		return snips;
	}


	// ...and now command actors
	private void resetPlugin() {
		stopPlugin();
		runPlugin();
	}

	private void runPlugin() {
		running = true;
		langEngine.setSnipList(getSnipList());
		langEngine.load();
		langEngine.run();
	}

	private void stopPlugin() {
		running = false;
		dispatcher.reset();
		langEngine.unload();
	}

	private void publishEnums() {
		for (Event.Type ev : Event.Type.values()) {
			langEngine.publishObject("MC_EVENT_" + ev.toString(), ev); // this is the most sane way to push Java enums into Lua
		}

		for (Action ac : Action.values()) {
			langEngine.publishObject("MC_ACTION_" + ac.toString(), ac);
		}

		for (Material m : Material.values()) {
			langEngine.publishObject("MC_MATERIAL_" + m.toString(), m);
		}

		for (ChatColor cc : ChatColor.values()) {
			langEngine.publishObject("MC_CHATCOLOR_" + cc.toString(), cc);
		}

	}
}
