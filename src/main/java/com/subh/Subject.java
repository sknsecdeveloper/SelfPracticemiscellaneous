package com.subh;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Subject implements Serializable {

    private int id;
    private String name;
}
