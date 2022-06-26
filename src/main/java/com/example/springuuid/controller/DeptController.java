package com.example.springuuid.controller;

import com.example.springuuid.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class DeptController {

    private final DeptService deptService;

    @RequestMapping("/")
    public String main(ModelMap modelMap) {

        log.debug("main 1");
        modelMap.addAttribute("deptList", deptService.deptList());
        log.debug("main 2");
        return "main";
    }
}
