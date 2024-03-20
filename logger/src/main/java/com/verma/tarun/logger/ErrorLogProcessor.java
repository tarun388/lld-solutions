package com.verma.tarun.logger;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogLevel level, String msg) {
        if (level.equals(LogLevel.ERROR)) {
            System.out.println("Error: " + msg);
        }
        else {
            super.log(level, msg);
        }
    }
}
