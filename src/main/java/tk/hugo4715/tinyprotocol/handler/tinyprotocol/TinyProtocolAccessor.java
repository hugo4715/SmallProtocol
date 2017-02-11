package tk.hugo4715.tinyprotocol.handler.tinyprotocol;

import org.bukkit.entity.Player;

import io.netty.channel.Channel;
import tk.hugo4715.tinyprotocol.PacketHook;
import tk.hugo4715.tinyprotocol.event.PacketInEvent;
import tk.hugo4715.tinyprotocol.event.PacketOutEvent;
import tk.hugo4715.tinyprotocol.handler.ProtocolAccessor;
import tk.hugo4715.tinyprotocol.packet.PacketAccessor;

public class TinyProtocolAccessor extends ProtocolAccessor {
	
	private TinyProtocol protocol ;
	public TinyProtocolAccessor(PacketHook lib) {
		super(lib);
		protocol = new TinyProtocol(lib.getPlugin()) {
			@Override
			public Object onPacketInAsync(Player sender, Channel channel, Object packet) {
				PacketAccessor a = new PacketAccessor(packet);
				PacketInEvent event = new PacketInEvent(sender, a);
				lib.getEventBus().post(event);
				
				if(event.isCancelled())return null;
				else return event.getPacket().getHandle();
			}
			
			@Override
			public Object onPacketOutAsync(Player reciever, Channel channel, Object packet) {
				PacketAccessor a = new PacketAccessor(packet);
				PacketOutEvent event = new PacketOutEvent(reciever, a);
				lib.getEventBus().post(event);
				
				if(event.isCancelled())return null;
				else return event.getPacket().getHandle();
			}
		};
	}
	
	@Override
	public void close() {
		protocol.close();
	}

	@Override
	public void sendPacket(Object packet, Player... players) {
		for(Player p : players){
			protocol.sendPacket(p, packet);
		}
	}

}
