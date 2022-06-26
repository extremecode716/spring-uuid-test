package com.example.springuuid.core;

import com.example.springuuid.vo.LogScopeInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.springframework.web.context.request.RequestAttributes;
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

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        try {
            final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null)
                return;
            final HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request == null)
                return;
            final Object logScopeInfo = request.getSession().getAttribute("logScopeInfo");
            if (logScopeInfo == null)
                return;
            toAppendTo.append(((LogScopeInfo) logScopeInfo).getUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
