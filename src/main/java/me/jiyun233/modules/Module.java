package me.jiyun233.modules;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public String name;
    public int KeyBind;
    private boolean enable;

    public Module(String name, int keyBind) {
        this.name = name;
        KeyBind = keyBind;
    }

    public void onEnable() { }
    public void onDisable() { }

    public final void enable() {
        enable = true;
        MinecraftForge.EVENT_BUS.register(this);
        mc.ingameGUI.getChatGUI().printChatMessage(
                new TextComponentString(ChatFormatting.GREEN + this.name + " has enabled!")
        );
        onEnable();
    }

    public final void disable() {
        enable = false;
        MinecraftForge.EVENT_BUS.unregister(this);
        mc.ingameGUI.getChatGUI().printChatMessage(
                new TextComponentString(ChatFormatting.RED + this.name + " has disabled!")
        );
        onDisable();
    }

    public void toggle() {
        if (enable) {
            disable();
        } else  {
            enable();
        }
    }

    public Minecraft mc = Minecraft.getMinecraft();
}
