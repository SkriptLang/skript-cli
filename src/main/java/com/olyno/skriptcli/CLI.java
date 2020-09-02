package com.olyno.skriptcli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

import com.olyno.skriptcli.commands.CmdHelp;
import com.olyno.skriptcli.commands.CmdPlayground;
import com.olyno.skriptcli.commands.CmdRun;
import com.olyno.skriptcli.commands.CmdUpdate;
import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;
import com.olyno.skriptcli.utils.Utils;

public class CLI extends Command {

    public static List<Command> COMMANDS = new ArrayList<>();
    public static Command HELP_COMMAND;

    private static CLI cli;

    public static void main(String[] args) {
        cli = new CLI();
        cli.execute(new ArrayList<>(List.of(args)), new HashMap<>());
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> none) {
        LinkedList<String> argsList = new LinkedList<>(args);
        ArrayList<String> newArgs = new ArrayList<>();
        HashMap<Flags, Boolean> flags = new HashMap<>();
        boolean commandFound = false;
        HELP_COMMAND = new CmdHelp();
        COMMANDS.add(new CmdPlayground());
        COMMANDS.add(HELP_COMMAND);
        COMMANDS.add(new CmdRun());
        COMMANDS.add(new CmdUpdate());
        for (Flags flag : Flags.values()) {
            flags.put(flag, false);
        }
        for (String arg : args) {
            if (arg.startsWith("--")) {
                String flagName = arg.replaceFirst("^--", "").replaceAll("-", "_").toUpperCase();
                if (isValidFlag(flagName)) {
                    Flags flag = Flags.valueOf(flagName);
                    if (flags.containsKey(flag)) {
                        flags.put(flag, true);
                    }
                } else {
                    this.warn("The flag '" + arg + "' has not been found.");
                }
                argsList.remove(arg);
            }
        }
        String fullCommand = String.join(" ", argsList);
        for (Command command : COMMANDS) {
            Matcher commandMatcher = command.getPattern().matcher(fullCommand);
            if (commandMatcher.find()) {
                commandMatcher.reset();
                while (commandMatcher.find()) {
                    if (commandMatcher.groupCount() > 0) {
                        newArgs.add(commandMatcher.group(1));
                    }
                }
                command.execute(newArgs, flags);
                command.log();
                commandFound = true;
                break;
            }
        }
        if (!commandFound) {
            this.fail("Command not found. Have a look in all commands using '" + Utils.getExecutableName() + " help'");
        }
        cli.log();
    }

    private static boolean isValidFlag(String flagName) {
        try {
            Flags.valueOf(flagName);
            return true;
        } catch (IllegalArgumentException ex) {  
            return false;
        }
    }
    
}
