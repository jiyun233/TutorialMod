package me.jiyun233.modules;

import me.jiyun233.modules.impl.FullBright;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class ModuleManager {
    private final ArrayList<Module> modules = new ArrayList<>();

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);

        modules.add(new FullBright());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            modules.stream().filter(it -> Keyboard.isKeyDown(it.KeyBind)).forEach(Module::toggle);
        }
    }
}
