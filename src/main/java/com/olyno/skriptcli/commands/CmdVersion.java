package com.olyno.skriptcli.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.olyno.skriptcli.CLI;
import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;

import io.github.syst3ms.skriptparser.util.ConsoleColors;

public class CmdVersion extends Command {

    public CmdVersion() {
        this.setDescription("Show athe current version of the cli");
        this.setUsage("version");
        this.setPattern("version");
        this.setSince("0.1.0");
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags) {
        System.out.println(ConsoleColors.PURPLE + "\nSkript CLI - v" + CLI.VERSION + "\n");
    }

}