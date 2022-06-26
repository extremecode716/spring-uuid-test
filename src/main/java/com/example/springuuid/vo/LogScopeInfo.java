package com.example.springuuid.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class LogScopeInfo {

    private final String UUID;
    private String id;
    private String userName;
    private String requestIP;
    private String requestDateTime;

    public LogScopeInfo() {
        this.UUID = java.util.UUID.randomUUID().toString();
        this.id = null;
        this.userName = null;
        this.requestIP = null;
        this.requestDateTime = null;
    }

    public LogScopeInfo(LogScopeInfo other) {
        this.UUID = other.UUID;
        this.id = other.id;
        this.userName = other.userName;
        this.requestIP = other.requestIP;
        this.requestDateTime = other.requestDateTime;
    }

}
