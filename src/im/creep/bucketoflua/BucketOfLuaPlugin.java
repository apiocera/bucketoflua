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

		if (!new File(mainDir).mkdir()) {
			log.severe(logPrefix + "config directory not present, also unable to create.");
			return;
		}
		config = new BetterConfig(new File(mainDir, configurationFile));
		config.load();

		langEngine = new LuaLangEngine(getSnipList(), log, mainDir);
		langEngine.setFramework(loadFramework());
		langEngine.setLogPrefix(logPrefix);
		langEngine.startEngine();
		langEngine.publishObject("dispatcher", dispatcher);
		for (Event.Type ev : Event.Type.values()) {
			langEngine.publishObject("MC_EVENT_" + ev.toString(), ev); // this is the most sane way to push Java enums into Lua
		}

		for (Event.Priority ev : Event.Priority.values()) {
			langEngine.publishObject("MC_PRIORITY_" + ev.toString(), ev);
		}
		langEngine.run();

		config.save();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("luareload")) {
			dispatcher.reset();
			langEngine.restartEngine();
			langEngine.run();
			return true;
		}
		return false;
	}

	public void onDisable() {
		log.info(logPrefix + "is disabled!");
		langEngine.stopEngine();
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
			e.printStackTrace();
		}
		return framework;
	}
}
