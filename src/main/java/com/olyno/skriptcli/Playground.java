package com.olyno.skriptcli;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.olyno.skriptcli.utils.Flags;

import io.github.syst3ms.skriptparser.Parser;

public class Playground {

    public Playground(HashMap<Flags, Boolean> flags) {
        List<String> programArgs = flags.keySet()
            .stream()
            .filter(flag -> flags.get(flag))
            .map(flag -> "--" + flag.name().toLowerCase().replaceAll("_", "-"))
            .collect(Collectors.toList());
        String[] mainPackages = new String[0];
        String[] subPackages = new String[0];
        Parser.init(mainPackages, subPackages, programArgs.toArray(new String[programArgs.size()]), true);
    }


}