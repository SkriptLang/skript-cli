package com.olyno.skriptcli.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import com.olyno.skriptcli.Playground;
import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;

import io.github.syst3ms.skriptparser.parsing.SyntaxParser;

public class CmdPlayground extends Command {

    private Playground playground;
    private AtomicBoolean running = new AtomicBoolean(true);

    public CmdPlayground() {
        this.setDescription("Go in the playground of Skript");
        this.setUsage("");
        this.setPattern("");
        this.setSince("0.1.0");
    }

    @Override
    public void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags) {
        playground = new Playground(flags);
        Scanner scanner = new Scanner(System.in);
        this.info("Entered in the Skript playground");
        // ! Fix logs here
        // this.log();
        while (running.get()) {
            try {
                System.out.print("> ");
                String effectLine = scanner.nextLine();
                SyntaxParser.parseEffect(effectLine, null, this.getLogger()).ifPresent(effect -> effect.run(null));
            } catch (NoSuchElementException ignore) {
                running.set(false);
                System.out.println("");
            }
        }
    }

}