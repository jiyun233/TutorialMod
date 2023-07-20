package me.jiyun233.command.impl;

import me.jiyun233.TutorialMod;
import me.jiyun233.command.AbstractCommand;
import me.jiyun233.modules.Module;
import me.jiyun233.utils.ChatUtil;

public class EnableCommand extends AbstractCommand {
    public EnableCommand() {
        super("Toggle");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            ChatUtil.sendMessage("&cPlease type a module.");
            return;
        }
        String module = args[0];
        boolean found = false;
        for (Module modules : TutorialMod.moduleManager.getModules()) {
            if (modules.name.equalsIgnoreCase(module)) {
                modules.toggle();
                found = true;
            }
        }
        if (!found) {
            ChatUtil.sendMessage("&cNot find this modules.");
        }
    }
}
