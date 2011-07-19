package im.creep.bucketoflua.tools;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BucketOfLuaHelp {
	public static Map<String, String> messages = new HashMap<String, String>();

	static {
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("reset", "Resets every snip state, reads all snip files again\n" +
			"and loads them.");
		messages = Collections.unmodifiableMap(aMap);
	}
}
