package log;

import org.apache.logging.log4j.Logger;

public final class LogThreadManager {

    private LogThreadManager() {}

    private static ThreadLocal<Logger> logManagerThreadLocal = new ThreadLocal<>();

    public static void setLogManager(Logger log){
        logManagerThreadLocal.set(log);

    }

    public static Logger getLogger(){
        return logManagerThreadLocal.get();
    }

    public static void unloadLogger(){
        logManagerThreadLocal.remove();
    }

}


