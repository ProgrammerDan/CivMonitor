package com.programmerdan.minecraft.civmonitor;

import com.programmerdan.minecraft.civmonitor.commands.CommandHandler;
import com.programmerdan.minecraft.civmonitor.events.*;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * <p>CivMonitor quietly and unobtrusively tracks everything everyone does. Check the README for details.</p>
 *
 * @author ProgrammerDan <programmerdan@gmail.com>
 * @since 1.0.0
 */
public class CivMonitor extends JavaPlugin {
	private CommandHandler commandHandler;
	private static Logger logger;
	private static CivMonitor plugin;
	private static boolean debug = false;

	public CommandHandler commandHandler() {
		return commandHandler;
	}

	public static Logger logger() {
		return CivMonitor.logger;
	}

	public static CivMonitor instance() {
		return CivMonitor.plugin;
	}

	public static boolean isDebug() {
		return CivMonitor.debug;
	}

	public static void setDebug(boolean debug) {
		CivMonitor.debug = debug;
	}

	@Override
	public void onEnable() {
		// setting a couple of static fields so that they are available elsewhere
		logger = getLogger();
		plugin = this;
		commandHandler = new CommandHandler(this);
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
	}

	@Override
	public void onDisable() {
		// close files if open, close DB connections, etc. unregister listeners
	}

	public static void debug(String message) {
		if (CivMonitor.debug) {
			CivMonitor.logger.info(message);
		}
	}

	private void initConfig() {
		// standaard config stuff here
	}
}
