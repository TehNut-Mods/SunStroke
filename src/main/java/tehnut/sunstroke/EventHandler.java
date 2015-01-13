package tehnut.sunstroke;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;

public class EventHandler {

    public static DamageSource sunStroke = (new DamageSource("sunStroke")).setDamageBypassesArmor();

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        int xCoord = (int)event.player.posX;
        int yCoord = (int)event.player.posY;
        int zCoord = (int)event.player.posZ;

        if (event.player.worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) && event.player.worldObj.isDaytime() && !(event.player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)) {
            if (!event.player.capabilities.isCreativeMode)
                event.player.attackEntityFrom(sunStroke, (float)ConfigHandler.damageAmount);
        }
    }
}
