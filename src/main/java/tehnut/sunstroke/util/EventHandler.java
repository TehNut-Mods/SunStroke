package tehnut.sunstroke.util;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import tehnut.sunstroke.ConfigHandler;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        int xCoord = (int)event.player.posX;
        int yCoord = (int)event.player.posY;
        int zCoord = (int)event.player.posZ;

        World world = event.player.worldObj;

        if (Utils.shouldPlayerSunStroke(world, xCoord, yCoord, zCoord) && !Utils.isWorldPeaceful(world) && Utils.getWorldDay(world) >= ConfigHandler.daysToWait) {
            if (!event.player.capabilities.isCreativeMode)
                event.player.attackEntityFrom(Utils.sunStroke, (float)ConfigHandler.damageAmount);
        }
    }
}
