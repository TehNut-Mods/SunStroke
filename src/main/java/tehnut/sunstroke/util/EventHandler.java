package tehnut.sunstroke.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tehnut.sunstroke.ConfigHandler;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        int xCoord = (int)event.player.posX;
        int yCoord = (int)event.player.posY;
        int zCoord = (int)event.player.posZ;

        World world = event.player.worldObj;

        // SunStroke effect
        if (Utils.shouldPlayerSunStroke(world, xCoord, yCoord, zCoord)) {
            if (!event.player.capabilities.isCreativeMode)
                event.player.attackEntityFrom(Utils.sunStroke, (float)ConfigHandler.damageAmount);
        }

        // Regen at low light levels
        if (Utils.shouldPlayerRegen(world, event.player, xCoord, yCoord, zCoord) && ConfigHandler.regenAtLowLight) {
            if (event.player.getFoodStats().getFoodLevel() > 6)
                event.player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 0));
        }
    }
}
