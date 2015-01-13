package tehnut.sunstroke;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tehnut.sunstroke.command.CommandDayCount;
import tehnut.sunstroke.command.CommandDaysLeft;
import tehnut.sunstroke.util.EventHandler;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
public class SunStroke {

	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static SunStroke instance;
	public static Configuration config;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(new File(event.getModConfigurationDirectory() + "/SunStroke" + ".cfg"));
		ConfigHandler.init(config);

		FMLCommonHandler.instance().bus().register(new EventHandler());
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event)	{
		event.registerServerCommand(new CommandDayCount());
		event.registerServerCommand(new CommandDaysLeft());
	}
}
