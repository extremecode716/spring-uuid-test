package com.example.springuuid.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept")
public class Dept {
    @Id
    private Integer deptNo;
    private String dName;
    private String loc;
}
