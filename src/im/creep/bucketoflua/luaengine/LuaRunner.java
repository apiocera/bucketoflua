package im.creep.bucketoflua.luaengine;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

public class LuaRunner {
	private LuaState state;
	private Boolean halted = false;

	public LuaRunner() {
		state = LuaStateFactory.newLuaState();
		state.openBase();
		state.openString();
		state.openTable();
	}

	public void addCode(String Code) throws LuaRunnerException {
		if (state.LloadString(Code) != 0) abortRunner(getError());
	}

	public void addFile(String File) throws LuaRunnerException {
		if (state.LloadFile(File) != 0) abortRunner(getError());
	}

	public void pushObject(String alias, Object obj) throws LuaRunnerException {
		try {
			state.pushObjectValue(obj);
			state.setGlobal(alias);
		} catch (LuaException e) {
			abortRunner(e.getMessage());
		}


	}

	public void run() throws LuaRunnerException {
		if (halted) abortRunner("LuaRunner has been already halted.");
		if (state.pcall(0, LuaState.LUA_MULTRET, 0) != 0) abortRunner(getError());

	}

	public void stop() {
		if (!state.isClosed()) state.close();
		halted = true;
	}


	private String getError() {
		return state.toString(-1);
	}

	private void abortRunner(String message) throws LuaRunnerException {
		stop();
		throw new LuaRunnerException(message);
	}
}
