package com.olyno.skriptcli.commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;

import com.olyno.skriptcli.utils.Command;
import com.olyno.skriptcli.utils.Flags;
import com.olyno.skriptcli.utils.OS;
import com.olyno.skriptcli.utils.Utils;

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
        OS userOs = Utils.getOS();
        String fileName = userOs.name().toLowerCase();
        if (userOs == OS.WINDOWS)
            fileName = fileName + ".exe";
        try {
            updateUrl = updateUrl.replaceAll("\\$os", fileName);
            ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(updateUrl).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(Utils.getExecutablePath().toString());
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);          
        } catch (FileNotFoundException ex) {
            this.fail("The latest version of skript-cli for " + userOs.name().toLowerCase()  + " has not been found.");
        } catch (IOException ex) {
            this.fail("An error occured when skript-cli tried to update itself.");
        }
    }

}