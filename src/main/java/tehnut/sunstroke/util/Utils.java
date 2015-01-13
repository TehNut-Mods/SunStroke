package tehnut.sunstroke.util;

import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import tehnut.sunstroke.ConfigHandler;

public class Utils {

    public static DamageSource sunStroke = (new DamageSource("sunStroke")).setDamageBypassesArmor();

    public static int getWorldDay(World world) {
        return (int)world.getWorldTime() / 24000;
    }

    public static int getWorldTime(World world) {
        return (int)world.getWorldTime();
    }

    public static boolean shouldPlayerSunStroke(World world, int x, int y, int z) {
        return world.canBlockSeeSky(new BlockPos(x, y, z)) && world.isDaytime();
    }

    public static int getDaysLeft(World world) {
        if ((ConfigHandler.daysToWait - Utils.getWorldDay(world) >= 0))
            return ConfigHandler.daysToWait - Utils.getWorldDay(world);
        else
            return 0;
    }

    public static boolean isWorldPeaceful(World world) {
        return world.getDifficulty() == EnumDifficulty.PEACEFUL;
    }

    public static String localize(String unloc) {
        return StatCollector.translateToLocal(unloc);
    }
}
