package tk.hugo4715.tinyprotocol.handler;

import tk.hugo4715.tinyprotocol.PacketHook;

public abstract class ProtocolAccessor {
	protected PacketHook lib;

	public ProtocolAccessor(PacketHook lib) {
		this.lib = lib;
	}
	
	
	
}
