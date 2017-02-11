package tk.hugo4715.tinyprotocol.handler;

import org.bukkit.entity.Player;

import tk.hugo4715.tinyprotocol.PacketHook;

public abstract class ProtocolAccessor {
	protected PacketHook lib;

	public ProtocolAccessor(PacketHook lib) {
		this.lib = lib;
	}
	
	public abstract void sendPacket(Object packet, Player... players);
	public void close(){};
	
}
