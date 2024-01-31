package com.subh;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student extends Member implements Cloneable/*Serializable*/ {

    private int id;
    private String name;
    private Department department;
    private Subject subject;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
