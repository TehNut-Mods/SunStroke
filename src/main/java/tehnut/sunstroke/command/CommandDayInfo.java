package tehnut.sunstroke.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import tehnut.sunstroke.ConfigHandler;
import tehnut.sunstroke.util.Utils;

public class CommandDayInfo extends CommandBase {

    @Override
    public String getCommandName() {
        return "getDayInfo";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        int xCoord = sender.getPlayerCoordinates().posX;
        int yCoord = sender.getPlayerCoordinates().posY;
        int zCoord = sender.getPlayerCoordinates().posZ;
        World world = sender.getEntityWorld();

        if (Utils.getWorldDay(sender.getEntityWorld()) >= ConfigHandler.daysToWait) {
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.day"), "" + EnumChatFormatting.RED + Utils.getWorldDay(world))));
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.time"), "" + EnumChatFormatting.RED + Utils.getWorldTime(world))));
        } else {
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.day"), "" + EnumChatFormatting.GREEN + Utils.getWorldDay(world))));
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.time"), "" + EnumChatFormatting.GREEN + Utils.getWorldTime(world))));
        }

        if (Utils.getLightValue(world, xCoord, yCoord, zCoord) <= 3)
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.light"), "" + EnumChatFormatting.GREEN + Utils.getLightValue(world, xCoord, yCoord, zCoord))));
        else
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.light"), "" + EnumChatFormatting.RED + Utils.getLightValue(world, xCoord, yCoord, zCoord))));
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
