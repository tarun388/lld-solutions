package com.verma.tarun.logger;

public class App {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogLevel.INFO, "info");
        logProcessor.log(LogLevel.DEBUG, "debug");
        logProcessor.log(LogLevel.ERROR, "error");
    }
}
