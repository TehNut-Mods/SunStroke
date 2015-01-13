package tehnut.sunstroke;

import net.minecraftforge.common.config.Configuration;

import java.io.*;

public class ConfigHandler {

	// Options
	public static int damageAmount;

	public static File cfg;

	public static void init(Configuration config) {
		config.load();

		damageAmount = config.get(Configuration.CATEGORY_GENERAL, "damageAmount", 1, "Amount of damage to deal to the player while in the sun.").getInt();

		if(config.hasChanged()) {
			config.save();
		}
	}
}
