package com.olyno.skriptcli.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.olyno.skriptcli.CLI;

import io.github.syst3ms.skriptparser.Parser;
import io.github.syst3ms.skriptparser.log.LogEntry;
import io.github.syst3ms.skriptparser.log.LogType;
import io.github.syst3ms.skriptparser.log.SkriptLogger;
import io.github.syst3ms.skriptparser.util.ConsoleColors;

public abstract class Command {

    private SkriptLogger logger = new SkriptLogger();

    private String description;
    private String usage;
    private String since;
    private Pattern pattern;

    public abstract void execute(ArrayList<String> args, HashMap<Flags, Boolean> flags);

    protected void fail(String message) {
        logger.error(message, null);
    }

    protected void warn(String message) {
        logger.warn(message);
    }

    protected void info(String message) {
        logger.info(message);
    }

    protected void showHelp() {
        CLI.HELP_COMMAND.execute(new ArrayList<>(), new HashMap<>());
    }

    public void log() {
        // TODO Fix logs here
        // logger.logOutput();
        List<LogEntry> logs = logger.close();
        Calendar time = Calendar.getInstance();
        if (!logs.isEmpty()) {
            System.out.print(ConsoleColors.PURPLE);
        }
        printLogs(logs, time);
        logger.clearLogs();
        System.out.print(ConsoleColors.RESET);
    }

    public SkriptLogger getLogger() {
        return logger;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = Pattern.compile("^" + pattern + "$");
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void printLogs(List<LogEntry> logs, Calendar time) {
        for (LogEntry log : logs) {
            ConsoleColors color = ConsoleColors.WHITE;
            if (log.getType() == LogType.WARNING) {
                color = ConsoleColors.YELLOW;
            } else if (log.getType() == LogType.ERROR) {
                color = ConsoleColors.RED;
            } else if (log.getType() == LogType.INFO) {
                color = ConsoleColors.BLUE;
            } else if (log.getType() == LogType.DEBUG) {
                color = ConsoleColors.PURPLE;
            }
            System.out.printf(color + Parser.CONSOLE_FORMAT + ConsoleColors.RESET, time, log.getType().name(), log.getMessage());
        }
    }

}