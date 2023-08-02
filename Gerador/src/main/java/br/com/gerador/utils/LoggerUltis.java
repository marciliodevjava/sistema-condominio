package br.com.gerador.utils;

import net.logstash.logback.argument.StructuredArguments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggerUltis {

    private static final Logger logger = LogManager.getLogger(LoggerUltis.class);

    LoggerUltis() {
    }


    public void logInfo(String mensagem) {
        logger.info("{}", mensagem);
    }

    public void logInfo(String mensagem, String identificador) {
        logger.info("{} {}", mensagem, StructuredArguments.value("identificador", identificador));
    }

    public void logInfo(String mensagem, Object object) {
        logger.info("{} {}", mensagem, StructuredArguments.value("object", object));
    }

    public void logInfo(String mensagem, String identificador, String localizador) {
        logger.info("{} {} {}", mensagem, StructuredArguments.value("identificador", identificador), StructuredArguments.value("localizador", localizador));
    }
}
