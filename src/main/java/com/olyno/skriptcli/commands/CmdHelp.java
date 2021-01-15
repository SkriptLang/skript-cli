package com.olyno.skriptcli.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.olyno.skriptcli.CLI;
import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;

import io.github.syst3ms.skriptparser.util.ConsoleColors;

public class CmdHelp extends Command {

    public CmdHelp() {
        this.setDescription("Show an help message about cli");
        this.setUsage("help");
        this.setPattern("help");
        this.setSince("0.1.0");
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags) {
        System.out.println(ConsoleColors.PURPLE + "\nSkript CLI - v" + CLI.VERSION + "\n");
        System.out.println("Usage: ");
        for (Command command : CLI.COMMANDS) {
            System.out.println("\t" + ConsoleColors.BLUE + "skript " + command.getUsage() + ConsoleColors.RESET + " - " + command.getDescription() + " (" + command.getSince() + ")");
        }
    }

}