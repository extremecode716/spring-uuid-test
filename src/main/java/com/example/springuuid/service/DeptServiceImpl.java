package com.example.springuuid.service;

import com.example.springuuid.domain.Dept;
import com.example.springuuid.domain.DeptRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    @Override
    public List<Dept> deptList() {
        final List<Dept> list = new ArrayList<>();
        deptRepository.findAll().forEach(dept -> {
            log.debug("deptList");
            list.add(dept);
        });

        return list;
    }
}
