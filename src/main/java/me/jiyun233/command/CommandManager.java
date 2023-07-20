package me.jiyun233.command;

import me.jiyun233.command.impl.EnableCommand;
import me.jiyun233.utils.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager {

    private char chatPrefix = '.';

    private final ArrayList<AbstractCommand> commands = new ArrayList<>();

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);

        commands.add(new EnableCommand());
    }

    @SubscribeEvent
    public void onCommand(ClientChatEvent event) {
        if (event.getOriginalMessage().startsWith(String.valueOf(chatPrefix))) {
            event.setCanceled(true);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
            String command = event.getOriginalMessage().substring(1);
            if (command.isEmpty()) {
                ChatUtil.sendMessage("&cNot a command!");
                return;
            }
            String[] parts = command.split(" ");
            String commandName = parts[0];
            boolean executed = false;
            for (AbstractCommand abstractCommand : commands) {
                if (abstractCommand.getCommand().equalsIgnoreCase(commandName)) {
                    abstractCommand.execute(Arrays.copyOfRange(parts,1,parts.length));
                    executed = true;
                }
            }
            if (!executed) {
                ChatUtil.sendMessage("&cNot find this command.");
            }
        }
    }

    public char getChatPrefix() {
        return chatPrefix;
    }

    public void setChatPrefix(char chatPrefix) {
        this.chatPrefix = chatPrefix;
    }
}
