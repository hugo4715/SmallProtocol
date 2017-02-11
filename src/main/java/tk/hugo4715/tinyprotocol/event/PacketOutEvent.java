package tk.hugo4715.tinyprotocol.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

import tk.hugo4715.tinyprotocol.packet.PacketAccessor;

/**
 * Server to client
 */
public class PacketOutEvent implements Cancellable{
	
	private PacketAccessor packet;
	private Player player;
	
	private boolean cancelled = false;

	public PacketOutEvent(Player player,PacketAccessor packet) {
		this.packet = packet;
		this.player = player;
	}
	
	public PacketAccessor getPacket() {
		return packet;
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean v) {
		this.cancelled = v;
	}
	
	
}
