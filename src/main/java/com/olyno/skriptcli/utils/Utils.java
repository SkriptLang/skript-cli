package com.olyno.skriptcli.utils;

public class Utils {

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