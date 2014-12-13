package im.creep.bucketoflua.luaengine;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

public class LuaStateKeeper {
	private LuaState state;
	private Boolean halted = false;

	private String name;

	public LuaStateKeeper(String runnerName) {
		name = runnerName;

		state = LuaStateFactory.newLuaState();
                // Opening all libs for work with  file and modules and so on
		state.openLibs(); 
	}

	public void addCode(String Code) throws LuaStateKeeperException {
		if (halted) abortRunner("Adding code string while Runner is halted");
		state.LloadBuffer(Code.getBytes(), "console");
		// if (state.LloadString(Code) != 0) abortRunner(getError());
	}

	public void addFile(String File) throws LuaStateKeeperException {
		if (halted) abortRunner("Adding code file while Runner is halted");
		if (state.LloadFile(File) != 0) abortRunner(getError());
	}

	public void pushObject(String alias, Object obj) throws LuaStateKeeperException {
		if (halted) abortRunner("Pushing object while Runner is halted");
		try {
			state.pushObjectValue(obj);
			state.setGlobal(alias);
		} catch (LuaException e) {
			abortRunner(e.getMessage());
		}


	}

	public void run() throws LuaStateKeeperException {
		if (halted) abortRunner("LuaRunner has been already halted.");
		if (state.pcall(0, LuaState.LUA_MULTRET, 0) != 0) abortRunner(getError());

	}

	public Boolean isHalted() {
		return halted;
	}

	public void stop() {
		if (!state.isClosed()) state.close();
		halted = true;
	}


	private String getError() {
		return state.toString(-1);
	}

	private void abortRunner(String message) throws LuaStateKeeperException {
		stop();
		throw new LuaStateKeeperException(message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
