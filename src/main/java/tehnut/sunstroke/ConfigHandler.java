package tehnut.sunstroke;

import net.minecraftforge.common.config.Configuration;

import java.io.*;

public class ConfigHandler {

	// Categories
	public static String gameplay = "Gameplay";

	// Options
	public static int damageAmount;
	public static int daysToWait;

	public static File cfg;

	public static void init(Configuration config) {
		config.load();

		damageAmount = config.get(gameplay, "damageAmount", 1, "Amount of damage to deal to the player while in the sun.").getInt();
		daysToWait = config.get(gameplay, "daysToWait", 0, "Amount of days to wait until sun strokes begin.").getInt();

		if(config.hasChanged()) {
			config.save();
		}
	}
}
