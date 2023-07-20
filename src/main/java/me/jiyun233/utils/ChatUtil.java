package me.jiyun233.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

@SuppressWarnings("ALL")
public class ChatUtil {
    public static String color(String s) {
        return s.replaceAll("&","\u00A7");
    }
    public static void sendRawMessage(String message) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
                new TextComponentString(message)
        );
    }

    public static void sendColoredMessage(String message) {
        sendRawMessage(color(message));
    }

    public static void sendMessage(String message) {
        sendColoredMessage("&8[&9Tutorial&8]&r" + message);
    }
}
