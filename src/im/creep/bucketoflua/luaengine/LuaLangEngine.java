package im.creep.bucketoflua.luaengine;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class LuaLangEngine {
	private HashMap<String, LuaRunner> LuaVMs = new HashMap<String, LuaRunner>();
	private HashMap<String, Object> publishedObjects = new HashMap<String, Object>();

	private List<Object> snipList;
	private String mainDir;

	private Logger log;
	private String logPrefix = "[LuaEngine]: ";

	private Boolean useFramework = false;
	private String framework;

	public LuaLangEngine(List<Object> snips, Logger logger, String path) {
		snipList = snips;
		log = logger;
		mainDir = path;
	}

	public void setFramework(String newFramework) {
		useFramework = true;
		framework = newFramework;
	}

	public void setLogPrefix(String logPrefix) {
		this.logPrefix = logPrefix;
	}

	public void publishObject(String name, Object obj) {
		if (publishedObjects.containsKey(name)) {
			log.warning(logPrefix + "double-publishing object " + name);
			return;
		}
		publishedObjects.put(name, obj);
		pushObject(name, obj);
	}

	public void run() {
		for (Map.Entry<String, LuaRunner> LuaVMEntry : LuaVMs.entrySet()) {
			try {
				LuaVMEntry.getValue().run();
			} catch (LuaRunnerException e) {
				log.warning(logPrefix + "snip " + LuaVMEntry.getKey() + " committed runtime error: " + e.getMessage());
			}
		}
	}

	public void load() {
		loadLuas();
		publishSaved();
	}

	public void unload() {
		unloadLuas();
	}

	public void reload() {
		unload();
		load();
	}

	// *** and now private
	private void publishSaved() {
		for (Map.Entry<String, Object> entry : publishedObjects.entrySet()) {
			pushObject(entry.getKey(), entry.getValue());
		}
	}

	private void pushObject(String name, Object obj) {
		for (LuaRunner LuaVM : LuaVMs.values()) {
			try {
				LuaVM.pushObject(name, obj);
			} catch (LuaRunnerException ex) {
				log.warning(logPrefix + "cannot push object into " + name + ": " + ex.getMessage());
			}
		}
	}

	private void loadLuas() {
		for (Object snip : snipList) {
			File F = new File(mainDir, snip.toString());
			if (!F.exists()) {
				log.warning(logPrefix + "snip " + snip.toString() + " doesn't seem to exist, ignoring");
				continue;
			}

			log.info(logPrefix + "loading snip " + snip.toString());

			LuaRunner LuaVM = new LuaRunner();
			try {
				if (useFramework) LuaVM.addCode(framework);
				LuaVM.addFile(F.getAbsolutePath());
			} catch (LuaRunnerException e) {
				log.warning(logPrefix + "snip " + snip.toString() + " committed loading error: " + e.getMessage());
			}

			LuaVMs.put(snip.toString(), LuaVM);
		}
	}

	private void unloadLuas() {
		for (LuaRunner LuaVM : LuaVMs.values()) {
			LuaVM.stop();
		}
		LuaVMs.clear();
	}
}