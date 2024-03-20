package com.verma.tarun.logger;

public abstract class LogProcessor {
    private LogProcessor nextLogProcessor;
    public LogProcessor(LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(LogLevel level, String msg) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(level,msg);
        }
    }
}
