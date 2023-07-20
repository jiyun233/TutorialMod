package me.jiyun233.modules;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.jiyun233.utils.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public final String name;
    public final Category category;
    public int KeyBind;
    private boolean enable;

    public Module(String name,Category category, int keyBind) {
        this.name = name;
        this.category = category;
        KeyBind = keyBind;
    }

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void onEnable() { }
    public void onDisable() { }
    public void onUpdate() { }

    public final void enable() {
        enable = true;
        MinecraftForge.EVENT_BUS.register(this);
        ChatUtil.sendMessage("&aModule: &6&l" + this.name + "&a toggle enabled!");
        onEnable();
    }

    public final void disable() {
        enable = false;
        MinecraftForge.EVENT_BUS.unregister(this);
        ChatUtil.sendMessage("&cModule: &6&l" + this.name + "&c toggle disabled!");
        onDisable();
    }

    public void toggle() {
        if (enable) {
            disable();
        } else  {
            enable();
        }
    }

    public boolean fullNullCheck() {
        return mc.player == null || mc.world == null;
    }

    public boolean isEnable() {
        return enable;
    }

    public Minecraft mc = Minecraft.getMinecraft();
}
