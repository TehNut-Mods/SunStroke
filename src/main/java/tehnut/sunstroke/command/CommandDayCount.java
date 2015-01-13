package tehnut.sunstroke.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import tehnut.sunstroke.ConfigHandler;
import tehnut.sunstroke.util.Utils;

public class CommandDayCount extends CommandBase {

    @Override
    public String getCommandName() {
        return "getDayCount";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (Utils.getWorldDay(sender.getEntityWorld()) >= ConfigHandler.daysToWait) {
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.day"), "" + EnumChatFormatting.RED + Utils.getWorldDay(sender.getEntityWorld()))));
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.time"), "" + EnumChatFormatting.RED + Utils.getWorldTime(sender.getEntityWorld()))));
        } else {
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.day"), "" + EnumChatFormatting.GREEN + Utils.getWorldDay(sender.getEntityWorld()))));
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.current.time"), "" + EnumChatFormatting.GREEN + Utils.getWorldTime(sender.getEntityWorld()))));
        }
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
