package log;

import org.apache.logging.log4j.*;

public record LoggerClass() {

    public static void initLogger (String className){
        Logger log = LogManager.getLogger(className);
        LogThreadManager.setLogManager(log);
        }

        public static Logger getLogger(){
            return LogThreadManager.getLogger();
        }

}
