package tk.hugo4715.tinyprotocol;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.eventbus.EventBus;

import tk.hugo4715.tinyprotocol.handler.ProtocolAccessor;
import tk.hugo4715.tinyprotocol.handler.tinyprotocol.TinyProtocolAccessor;
import tk.hugo4715.tinyprotocol.util.PacketHookLogger;

public class PacketHook {
	private JavaPlugin plugin;

	private EventBus eventBus;

	private ProtocolAccessor protocol;

	private PacketHookLogger logger;

	public PacketHook(JavaPlugin plugin) {
		this.plugin = plugin;
		this.eventBus = new EventBus(getClass().getSimpleName());
		this.logger = new PacketHookLogger(this);
		init();
	}


	private void init() {
		getLogger().info("PacketHook is initializing...");
		protocol = new TinyProtocolAccessor(this);

		if(protocol != null){
			getLogger().info("Successfully hooked into minecraft protocol!");
		}else{
			getLogger().severe("");
			getLogger().severe("Could not hook into minecraft protocol! Plugin may not work!");
			getLogger().severe("");
		}
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public PacketHookLogger getLogger() {
		return logger;
	}

	/**
	 *  Check if there is an obvious error
	 * @return True is there is an error, false otherwise
	 */
	public boolean isErrored(){
		return protocol == null;
	}


}
