package me.jiyun233.modules;

import me.jiyun233.modules.impl.movement.Sprint;
import me.jiyun233.modules.impl.visual.FullBright;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final ArrayList<Module> modules = new ArrayList<>();

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);

        modules.add(new FullBright());
        modules.add(new Sprint());
    }

    public List<Module> getModules() {
        return modules;
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            modules.stream().filter(it -> Keyboard.isKeyDown(it.KeyBind)).forEach(Module::toggle);
        }
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.ClientTickEvent event) {
        modules.stream().filter(Module::isEnable).forEach(Module::onUpdate);
    }
}
