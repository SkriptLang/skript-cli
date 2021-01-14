package com.olyno.skriptcli.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;

import io.github.syst3ms.skriptparser.Parser;

public class CmdRun extends Command {

    public CmdRun() {
        this.setDescription("Run a script from its path");
        this.setUsage("run <script path>");
        this.setPattern("run (.+)");
        this.setSince("0.1.0");
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags) {
        boolean debug = flags.get(Flags.DEBUG);
        if (args.size() == 0) {
            this.fail("You need to provide a script name !");
            return;
        }
        String scriptName = args.get(0).replaceAll("\\.sk$", "");
        Path scriptPath = Paths.get(scriptName + ".sk");
        if (Files.isRegularFile(scriptPath)) {
            Parser.init(new String[0], new String[0], new String[0], true);
            Parser.run(scriptPath.toString(), debug, true);
        } else if (Files.isDirectory(scriptPath)) {
            this.fail("You can't compile a directory!");
        } else {
            this.fail("Path not found: " + scriptPath.toString());
        }
    }

}