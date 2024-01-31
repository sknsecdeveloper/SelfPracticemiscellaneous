package com.subh;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassRoom {

    private List<Student> students;

}
