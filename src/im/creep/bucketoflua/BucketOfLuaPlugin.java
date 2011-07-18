package im.creep.bucketoflua;

import im.creep.bucketoflua.luaengine.LuaLangEngine;
import im.creep.bucketoflua.tools.BetterConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public class BucketOfLuaPlugin extends JavaPlugin {
	String mainDir;
	String configurationFile = "BucketOfLua.yml";
	String logPrefix;
	BetterConfig config;
	Boolean failedOnStart = false;

	LuaLangEngine langEngine;

	String framework;
	Logger log = Logger.getLogger("Minecraft");
	EventDispatcher dispatcher;

	public String convertStreamToString(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}

		br.close();
		return sb.toString();
	}

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
		langEngine.setFramework(loadFramework());
		langEngine.load();

		// Publishing dispatcher and Event.Types
		langEngine.publishObject("dispatcher", dispatcher);
		for (Event.Type ev : Event.Type.values()) {
			langEngine.publishObject("MC_EVENT_" + ev.toString(), ev); // this is the most sane way to push Java enums into Lua
		}

		for (Event.Priority ev : Event.Priority.values()) {
			langEngine.publishObject("MC_PRIORITY_" + ev.toString(), ev);
		}

		// Finally, running
		langEngine.run();
		config.save();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("luareload")) {
			dispatcher.reset();
			langEngine.reload();
			langEngine.run();
			return true;
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

	private String loadFramework() {
		InputStream framework_stream;

		framework_stream = getClass().getResourceAsStream("/res/framework.lua");
		try {
			framework = convertStreamToString(framework_stream);
		} catch (IOException e) {
			log.warning(logPrefix + "could not find internal framework.lua, snippets will probably go insane");
			return "";
		}
		return framework;
	}
}
