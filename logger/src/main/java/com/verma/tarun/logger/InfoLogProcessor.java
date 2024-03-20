package com.verma.tarun.logger;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogLevel level, String msg) {
        if (level.equals(LogLevel.INFO)) {
            System.out.println("Info: " + msg);
        }
        else {
            super.log(level, msg);
        }
    }
}
