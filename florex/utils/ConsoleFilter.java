/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.utils;

import java.util.Iterator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.FormattedMessageFactory;
import org.apache.logging.log4j.message.Message;

public class ConsoleFilter
implements Filter {
    private FormattedMessageFactory fd = new FormattedMessageFactory();
    private boolean fz = false;

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        if (logEvent != null && logEvent.getMessage() != null) {
            this.x(logEvent.getMessage().getFormattedMessage());
        }
        return this.x(logEvent);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object ... array) {
        if (s != null) {
            this.x(this.x(s, array));
        }
        return this.x(logger, level, marker, s, array);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object o, Throwable t) {
        if (o != null) {
            this.x(o.toString());
        }
        return this.x(logger, level, marker, o, t);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable t) {
        if (message != null) {
            this.x(message.getFormattedMessage());
        }
        return this.x(logger, level, marker, message, t);
    }

    @Override
    public LifeCycle.State getState() {
        return this.fz ? LifeCycle.State.STARTED : LifeCycle.State.STOPPED;
    }

    @Override
    public void initialize() {
    }

    @Override
    public boolean isStarted() {
        return this.fz;
    }

    @Override
    public boolean isStopped() {
        return !this.fz;
    }

    @Override
    public void start() {
        this.fz = true;
    }

    @Override
    public void stop() {
        this.fz = false;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o) {
        return this.x(logger, level, marker, s, o);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2) {
        if (s != null) {
            this.x(this.x(s, o, o2));
        }
        return this.x(logger, level, marker, s, o, o2);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3) {
        return this.x(logger, level, marker, s, o, o2, o3);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4) {
        return this.x(logger, level, marker, s, o, o2, o3, o4);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
        return this.x(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
    }

    @Override
    public Filter.Result getOnMatch() {
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result getOnMismatch() {
        return Filter.Result.NEUTRAL;
    }

    private Filter.Result x(LogEvent logEvent) {
        try {
            Iterator<Filter> filters = ((Logger)LogManager.getLogger(logEvent.getLoggerName())).getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logEvent);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object ... array) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, array);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, Object o, Throwable t) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, o, t);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, Message message, Throwable t) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, message, t);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private Filter.Result x(Logger logger, Level level, Marker marker, String s, Object o, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
        try {
            Iterator<Filter> filters = logger.getFilters();
            Filter.Result result = Filter.Result.NEUTRAL;
            while (filters.hasNext()) {
                Filter filter = filters.next();
                if (filter instanceof ConsoleFilter) continue;
                result = filter.filter(logger, level, marker, s, o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
            }
            return result;
        } catch (Exception ex) {
            return Filter.Result.NEUTRAL;
        }
    }

    private String x(String s, Object ... array) {
        if (array == null || array.length <= 0) {
            return s;
        }
        String formattedMessage = s;
        try {
            formattedMessage = this.fd.newMessage(s, array).getFormattedMessage();
        } catch (Exception ex) {
            LogManager.getRootLogger().log(Level.WARN, "Bir hata olu\u015ftu!", (Throwable)ex);
        }
        return formattedMessage;
    }

    private String x(String s, Object o, Object o2) {
        String formattedMessage = s;
        try {
            formattedMessage = this.fd.newMessage(s, o, o2).getFormattedMessage();
        } catch (Exception ex) {
            LogManager.getRootLogger().log(Level.WARN, "Bir hata olu\u015ftu!", (Throwable)ex);
        }
        return formattedMessage;
    }

    private void x(String s) {
    }
}

