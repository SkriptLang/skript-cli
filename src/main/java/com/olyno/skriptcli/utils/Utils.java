package com.olyno.skriptcli.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.olyno.skriptcli.CLI;

public class Utils {

    public static final Path getExecutablePath() {
        try {
            return Paths.get(CLI.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final String getExecutableName() {
        final Path cliPath = getExecutablePath();
        return cliPath.getFileName().toString().split("\\.")[0];
    }

    public static final OS getOS() {
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
            return OS.WINDOWS;
        } else if (operSys.contains("nix") || operSys.contains("nux")
                || operSys.contains("aix")) {
            return OS.LINUX;
        } else if (operSys.contains("mac")) {
            return OS.MAC;
        } else if (operSys.contains("sunos")) {
            return OS.SOLARIS;
        }
        return null;
    }

}