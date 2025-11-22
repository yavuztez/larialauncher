package xyz.laria.utils;

import java.util.Iterator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.Filter.Result;
import org.apache.logging.log4j.core.LifeCycle.State;
import org.apache.logging.log4j.message.FormattedMessageFactory;
import org.apache.logging.log4j.message.Message;

public class ConsoleFilter implements Filter {
    private FormattedMessageFactory fd = new FormattedMessageFactory();
    private boolean fz = false;

    public Filter.Result filter(LogEvent logEvent) {
        if (logEvent != null && logEvent.getMessage() != null) {
            this.x(logEvent.getMessage().getFormattedMessage());
        }

        return this.x(logEvent);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object... array) {
        if (s != null) {
            this.x(this.x(s, array));
        }

        return this.x(logger, level, marker, s, array);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, Object o, Throwable t) {
        if (o != null) {
            this.x(o.toString());
        }

        return this.x(logger, level, marker, o, t);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable t) {
        if (message != null) {
            this.x(message.getFormattedMessage());
        }

        return this.x(logger, level, marker, message, t);
    }

    public LifeCycle.State getState() {
        return this.fz ? State.STARTED : State.STOPPED;
    }

    public void initialize() {
    }

    public boolean isStarted() {
        return this.fz;
    }

    public boolean isStopped() {
        return !this.fz;
    }

    public void start() {
        this.fz = true;
    }

    public void stop() {
        this.fz = false;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o) {
        return this.x(logger, level, marker, s, o);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2) {
        if (s != null) {
            this.x(this.x(s, o, o2));
        }

        return this.x(logger, level, marker, s, o, o2);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3) {
        return this.x(logger, level, marker, s, o, o2, o3);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4) {
        return this.x(logger, level, marker, s, o, o2, o3, o4);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9);
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
    }

    public Filter.Result getOnMatch() {
        return Result.NEUTRAL;
    }

    public Filter.Result getOnMismatch() {
        return Result.NEUTRAL;
    }

    private Filter.Result x(LogEvent logEvent) {
        try {
            Iterator filters = ((Logger)LogManager.getLogger(logEvent.getLoggerName())).getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logEvent);
                }
            }

            return result;
        } catch (Exception var5) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object... array) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, array);
                }
            }

            return result;
        } catch (Exception var9) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, Object o, Throwable t) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, o, t);
                }
            }

            return result;
        } catch (Exception var9) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, Message message, Throwable t) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, message, t);
                }
            }

            return result;
        } catch (Exception var9) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o);
                }
            }

            return result;
        } catch (Exception var9) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2);
                }
            }

            return result;
        } catch (Exception var10) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3);
                }
            }

            return result;
        } catch (Exception var11) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4);
                }
            }

            return result;
        } catch (Exception var12) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5);
                }
            }

            return result;
        } catch (Exception var13) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6);
                }
            }

            return result;
        } catch (Exception var14) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7);
                }
            }

            return result;
        } catch (Exception var15) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8);
                }
            }

            return result;
        } catch (Exception var16) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9);
                }
            }

            return result;
        } catch (Exception var17) {
            return Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
        try {
            Iterator filters = logger.getFilters();
            Filter.Result result = Result.NEUTRAL;

            while(filters.hasNext()) {
                Filter filter = (Filter)filters.next();
                if (!(filter instanceof ConsoleFilter)) {
                    result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
                }
            }

            return result;
        } catch (Exception var18) {
            return Result.NEUTRAL;
        }
    }

    private String x(String s, Object... array) {
        if (array != null && array.length > 0) {
            String formattedMessage = s;

            try {
                formattedMessage = this.fd.newMessage(s, array).getFormattedMessage();
            } catch (Exception var5) {
                LogManager.getRootLogger().log(Level.WARN, "Bir hata oluştu!", var5);
            }

            return formattedMessage;
        } else {
            return s;
        }
    }

    private String x(String s, Object o, Object o2) {
        String formattedMessage = s;

        try {
            formattedMessage = this.fd.newMessage(s, o, o2).getFormattedMessage();
        } catch (Exception var6) {
            LogManager.getRootLogger().log(Level.WARN, "Bir hata oluştu!", var6);
        }

        return formattedMessage;
    }

    private void x(String s) {
    }
}
