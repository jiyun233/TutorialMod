package me.jiyun233.modules.impl.visual;

import me.jiyun233.modules.Category;
import me.jiyun233.modules.Module;
import org.lwjgl.input.Keyboard;

public class FullBright extends Module {
    public FullBright() {
        super("FullBright", Category.VISUAL, Keyboard.KEY_V);
    }

    @Override
    public void onEnable() {
        mc.gameSettings.gammaSetting = 15f;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = 1f;
    }
}
