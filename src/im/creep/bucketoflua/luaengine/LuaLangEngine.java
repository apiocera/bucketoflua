package im.creep.bucketoflua.luaengine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class LuaLangEngine {
	private ArrayList<LuaStateKeeper> LuaKeepers = new ArrayList<LuaStateKeeper>();
	private HashMap<String, Object> publishedObjects = new HashMap<String, Object>();

	private List<File> snipList;

	private Logger log;
	private String logPrefix = "[LuaEngine]: ";

	public LuaLangEngine(Logger logger) {
		log = logger;
	}

	public void setSnipList(List<File> snipList) {
		this.snipList = snipList;
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
		for (LuaStateKeeper LuaKeeper : LuaKeepers) {
			try {
				LuaKeeper.run();
			} catch (LuaStateKeeperException e) {
				log.warning(logPrefix + "snip " + LuaKeeper.getName() + " committed runtime error: " + e.getMessage());
			}
		}
	}

	public void load() {
		loadLuas();
		publishSaved();
	}

	public void unload() {
		stopLuas();
		LuaKeepers.clear();
	}


	// *** and now private
	private void publishSaved() {
		for (Map.Entry<String, Object> entry : publishedObjects.entrySet()) {
			pushObject(entry.getKey(), entry.getValue());
		}
	}

	private void pushObject(String name, Object obj) {
		for (LuaStateKeeper LuaKeeper : LuaKeepers) {
			if (LuaKeeper.isHalted()) {
				continue;
			}
			try {
				LuaKeeper.pushObject(name, obj);
			} catch (LuaStateKeeperException ex) {
				log.warning(logPrefix + "cannot push object " + name + ": " + ex.getMessage());
			}
		}
	}

	private void loadLuas() {
		for (File snip : snipList) {
			log.info(logPrefix + "loading snip " + snip.getName());
			LuaStateKeeper LuaKeeper = new LuaStateKeeper(snip.getName());
			try {
				LuaKeeper.addFile(snip.getAbsolutePath());
			} catch (LuaStateKeeperException e) {
				log.warning(logPrefix + "snip " + snip.getName() + " committed loading error: " + e.getMessage());
			}
			LuaKeepers.add(LuaKeeper);
		}
	}

	private void stopLuas() {
		for (LuaStateKeeper LuaKeeper : LuaKeepers) {
			LuaKeeper.stop();
		}
	}
}