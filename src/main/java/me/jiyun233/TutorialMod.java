package me.jiyun233;

import me.jiyun233.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.opengl.Display;

@Mod(modid = TutorialMod.MOD_ID,name = TutorialMod.MOD_NAME,version = TutorialMod.MOD_VER)
public class TutorialMod {
    public static final String MOD_ID = "tutorial";
    public static final String MOD_NAME = "Tutorial Mod";
    public static final String MOD_VER = "0.0.1-SNAPSHOT";

    public static ModuleManager moduleManager;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(MOD_NAME + " " + MOD_VER + " by jiyun233");
        moduleManager = new ModuleManager();
        moduleManager.init();
    }
}
