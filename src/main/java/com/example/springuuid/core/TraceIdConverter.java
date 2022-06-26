package com.example.springuuid.core;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Plugin(name = "TraceIdConverter", category = "Converter")
@ConverterKeys({"traceId"})
public class TraceIdConverter extends LogEventPatternConverter {

    protected TraceIdConverter(String name, String style) {
        super(name, style);
    }

    public static TraceIdConverter newInstance(String[] options) {
        return new TraceIdConverter("traceId", "traceId");
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        String traceId = null;
        try {
            final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (request != null)
                traceId = (String) request.getSession().getAttribute("traceId");
        } catch (Exception e) {

        }
        toAppendTo.append(traceId == null ? "" : traceId);
    }
}
