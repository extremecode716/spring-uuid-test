package com.example.springuuid.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice("com")
public class ControllerException {

    @ExceptionHandler
    public String exception(ModelMap modelMap, Exception e) {
        modelMap.addAttribute("message", e.getMessage());

        return "error";
    }
}
