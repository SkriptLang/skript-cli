package com.olyno.skriptcli.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;

public class CmdUpdate extends Command {

    private String updateUrl = "https://github.com/SkriptLang/skript-cli/releases/latest/download/skript-cli-$os";

    public CmdUpdate() {
        this.setDescription("Update the CLI with latest available version. Fail if the OS is not supposed.");
        this.setUsage("update");
        this.setPattern("up(date)?");
        this.setSince("0.1.0");
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags) {
        // TODO Find a way to make this command correctly
        this.fail("Command not implemented yet");
    }

}