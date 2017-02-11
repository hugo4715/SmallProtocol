package tk.hugo4715.tinyprotocol.packet;

import java.lang.reflect.Field;

import tk.hugo4715.tinyprotocol.util.Reflection;

public class PacketAccessor {
	private Object handle;
	
	private Field[] fields;
	
	public PacketAccessor(Object handle) {
		this.handle = handle;
		fields = handle.getClass().getDeclaredFields();
	}
	
	public Field getField(int index) throws ReflectiveOperationException{
		Field f = fields[index];
		f = Reflection.removeFinal(f);
		return f;
	}
	
	public String getPacketClassName() {
		return handle.getClass().getName();
	}
	
	public String getPacketClassSimpleName() {
		return handle.getClass().getSimpleName();
	}
	
	public Object getHandle() {
		return handle;
	}
}
