package com.verma.tarun.logger;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogLevel level, String msg) {
        if (level.equals(LogLevel.DEBUG)) {
            System.out.println("Debug: " + msg);
        }
        else {
            super.log(level, msg);
        }
    }
}
