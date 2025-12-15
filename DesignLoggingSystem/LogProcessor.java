package DesignLoggingSystem;

public abstract class LogProcessor {
    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;
    LogProcessor nextLogProcessor;
    LogProcessor(LogProcessor logProcessor){
        this.nextLogProcessor=logProcessor;
    }
    public void log(int loglevel,String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(loglevel,message);
        }
    }

    public static void main(String[] args) {
        LogProcessor logProcessor=new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR,"exception happens");
        logProcessor.log(LogProcessor.DEBUG,"need to debug this");
        logProcessor.log(LogProcessor.INFO,"just for info");
    }
}


