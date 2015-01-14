package tehnut.sunstroke;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tehnut.sunstroke.command.CommandDayInfo;
import tehnut.sunstroke.command.CommandDaysLeft;
import tehnut.sunstroke.util.EventHandler;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
public class SunStroke {

	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static SunStroke instance;
	public static Configuration config;
	public static String mcPath;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(new File(event.getModConfigurationDirectory() + "/SunStroke" + ".cfg"));
		ConfigHandler.init(config);

		mcPath = event.getModConfigurationDirectory().getParent();

		FMLCommonHandler.instance().bus().register(new EventHandler());
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event)	{
		event.registerServerCommand(new CommandDayInfo());
		event.registerServerCommand(new CommandDaysLeft());
	}
}
