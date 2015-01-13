package tehnut.sunstroke.util;

import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Utils {

    public static DamageSource sunStroke = (new DamageSource("sunStroke")).setDamageBypassesArmor();

    public static int getWorldDay(World world) {
        return (int)world.getWorldTime() / 24000;
    }

    public static int getWorldTime(World world) {
        return (int)world.getWorldTime();
    }

    public static boolean shouldPlayerSunStroke(World world, int xCoord, int yCoord, int zCoord) {
        return world.canBlockSeeTheSky(xCoord, yCoord, zCoord) && world.isDaytime();
    }

    public static boolean isWorldPeaceful(World world) {
        return world.difficultySetting == EnumDifficulty.PEACEFUL;
    }

    public static String localize(String unloc) {
        return StatCollector.translateToLocal(unloc);
    }
}
