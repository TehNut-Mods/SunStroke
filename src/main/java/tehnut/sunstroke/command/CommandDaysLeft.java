package tehnut.sunstroke.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import tehnut.sunstroke.util.Utils;

public class CommandDaysLeft extends CommandBase {

    @Override
    public String getCommandName() {
        return "getDaysLeft";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (Utils.getDaysLeft(sender.getEntityWorld()) >= 0)
            sender.addChatMessage(new ChatComponentText(String.format(Utils.localize("chat.sunstroke.remaining.day"), Utils.getDaysLeft(sender.getEntityWorld()))));
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
