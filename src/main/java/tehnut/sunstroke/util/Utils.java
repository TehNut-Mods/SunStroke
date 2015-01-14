package tehnut.sunstroke.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import tehnut.sunstroke.ConfigHandler;
import tehnut.sunstroke.SunStroke;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static DamageSource sunStroke = (new DamageSource("sunStroke")).setDamageBypassesArmor();

    public static int getWorldDay(World world) {
        return (int)world.getWorldTime() / 24000;
    }

    public static int getWorldTime(World world) {
        return (int)world.getWorldTime();
    }

    public static int getDaysLeft(World world) {
        if ((ConfigHandler.daysToWait - Utils.getWorldDay(world) >= 0))
            return ConfigHandler.daysToWait - Utils.getWorldDay(world);
        else
            return 0;
    }

    public static int getLightValue(World world, int x, int y, int z) {
        return world.getBlockLightValue(x, y, z);
    }

    public static boolean shouldPlayerSunStroke(World world, int x, int y, int z) {
        return world.canBlockSeeTheSky(x, y, z) && world.isDaytime() && !isWorldPeaceful(world) && Utils.getWorldDay(world) >= ConfigHandler.daysToWait;
    }

    public static boolean shouldPlayerRegen(World world, EntityPlayer player, int x, int y, int z) {
        return !world.canBlockSeeTheSky(x, y, z) && getLightValue(world, x, y, z) <= 3 && !player.isPotionActive(Potion.regeneration);
    }

    public static boolean isWorldPeaceful(World world) {
        return world.difficultySetting == EnumDifficulty.PEACEFUL;
    }

    public static String localize(String unloc) {
        return StatCollector.translateToLocal(unloc);
    }
}
