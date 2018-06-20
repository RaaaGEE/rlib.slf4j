package com.ss.rlib.logging.spi;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.slf4j.LoggerFactory;

import com.ss.rlib.common.function.TripleFunction;
import com.ss.rlib.common.logging.Logger;
import com.ss.rlib.common.logging.LoggerLevel;

/**
 * SlfLoggerAdapter.java
 * 
 * @author n3k0nation
 * @date 14.03.2018
 * @project rlib.slf4j
 */
public class SlfLoggerAdapter implements Logger {

    private org.slf4j.Logger log;
    private String name;
    
    public SlfLoggerAdapter() {
    }

    @Override
	public String getName() {
        return name;
    }

    @Override
	public void setName(String name) {
        this.name = name;
        this.log = LoggerFactory.getLogger(name);
    }

    @Override
	public void print(LoggerLevel level, Object owner, String message) {
        print(level, message);
    }

    @Override
	public void print(LoggerLevel level, String message) {
        switch (level) {
        case DEBUG:
            log.debug(message);
            break;

        case INFO:
            log.info(message);
            break;

        case WARNING:
            log.warn(message);
            break;

        case ERROR:
            log.error(message);
            break;
        }
    }

    @Override
	public void print(LoggerLevel level, Object owner, Throwable exception) {
        print(level, exception);
    }

    @Override
	public void print(LoggerLevel level, Throwable exception) {
        switch (level) {
        case DEBUG:
            log.debug("", exception);
            break;

        case INFO:
            log.info("", exception);
            break;

        case WARNING:
            log.warn("", exception);
            break;

        case ERROR:
            log.error("", exception);
            break;
        }
    }

    @Override
	public <T> void print(LoggerLevel level, Object owner, T arg, Function<T, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(arg));
    }

    @Override
	public <F, S> void print(LoggerLevel level, Object owner, F first, S second, BiFunction<F, S, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(first, second));
    }

    @Override
	public <F, S, T> void print(LoggerLevel level, Object owner, F first, S second, T third, TripleFunction<F, S, T, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(first, second, third));
    }

    @Override
	public <T> void print(LoggerLevel level, T arg, Function<T, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(arg));
    }

    @Override
	public <F, S> void print(LoggerLevel level, F first, S second, BiFunction<F, S, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(first, second));
    }

    @Override
	public <F, S, T> void print(LoggerLevel level, F first, S second, T third, TripleFunction<F, S, T, String> messageFactory) {
        if(!isLevelEnabled(level)) {
            return;
        }
        
        print(level, messageFactory.apply(first, second, third));
    }
    
    private boolean isLevelEnabled(LoggerLevel level) {
        switch (level) {
        case DEBUG:
            return log.isDebugEnabled();

        case INFO:
            return log.isInfoEnabled();

        case WARNING:
            return log.isWarnEnabled();

        case ERROR:
            return log.isErrorEnabled();
        }
        return false;
    }

}
