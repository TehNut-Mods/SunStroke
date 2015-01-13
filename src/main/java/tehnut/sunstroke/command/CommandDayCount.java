package tehnut.sunstroke.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
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
        sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sunstroke.current.day") + " : " + Utils.getWorldDay(sender.getEntityWorld())));
        sender.addChatMessage(new ChatComponentText(Utils.localize("chat.sunstroke.current.time") + " : " + Utils.getWorldTime(sender.getEntityWorld())));
    }
}
