package com.example.springuuid.core;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Plugin(name = "TraceIdConverter", category = "Converter")
@ConverterKeys({"traceId"})
public class TraceIdConverter extends LogEventPatternConverter {

    protected TraceIdConverter(String name, String style) {
        super(name, style);
    }

    public static TraceIdConverter newInstance(String[] options) {
        return new TraceIdConverter("traceId", "traceId");
    }

    // 로그를 찍을때 마다 가져온다.
    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        log.info("{}", event.getMessage());
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
