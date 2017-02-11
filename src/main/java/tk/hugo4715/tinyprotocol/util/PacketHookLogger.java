package tk.hugo4715.tinyprotocol.util;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import tk.hugo4715.tinyprotocol.PacketHook;

public class PacketHookLogger extends Logger {
	private String prefix;

	public PacketHookLogger(PacketHook hook) {
		super(hook.getClass().getSimpleName(), null);
		this.prefix = "[" + hook.getClass().getSimpleName() + "] ";
		setParent(hook.getPlugin().getLogger());
		setLevel(Level.ALL);
	}

	public void log(LogRecord logRecord) {
		logRecord.setMessage(this.prefix + logRecord.getMessage());
		super.log(logRecord);
	}
}