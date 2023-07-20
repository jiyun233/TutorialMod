package me.jiyun233.modules.impl.movement;

import me.jiyun233.modules.Category;
import me.jiyun233.modules.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.MOVEMENT, Keyboard.KEY_Y);
    }

    @Override
    public void onUpdate() {
        if (fullNullCheck()) return;
        mc.player.setSprinting(!mc.player.collidedHorizontally && mc.player.moveForward > 0);
    }
}
