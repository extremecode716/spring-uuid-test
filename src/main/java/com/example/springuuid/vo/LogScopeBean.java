package com.example.springuuid.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

/**
 * 로그 스코프 빈<p>
 * Scope 어노테이션에 따라서 로그의 UUID Scope 차이가 생김<p>
 * session trace: @SessionScope<p>
 * request trace: @RequestScope
 *
 * @author extremecode716
 */
@Getter
@ToString
@Component
@SessionScope
public class LogScopeBean implements Serializable {
    private static final long serialVersionUID = -7192885664152078297L;

    private LogScopeInfo logScopeInfo;

    public LogScopeBean() {
        logScopeInfo = new LogScopeInfo();
    }

    public LogScopeInfo clone() {
        return new LogScopeInfo(logScopeInfo);
    }

}
