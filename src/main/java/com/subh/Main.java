package com.subh;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {




        /*if(student.getDepartment().toString().equals("IT")){
            System.out.println("Department matched");
        }

        System.out.println(student);
*/
        /*ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Get all thread IDs
        long[] threadIds = threadMXBean.getAllThreadIds();

        // Get thread information for each thread
        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);

        // Print thread information
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("my thread info :::: "+threadInfo);
        }*/

        Map<String,String> map = new LinkedHashMap<>();
        map.put("Subhash", "Gaya");
        map.put(null, "kolkata");
        map.put(null, "delhi");

        System.out.println(map);


        Student student = Student.builder()
                .id(1)
                .name("Subhash")
                .department(Department.IT)
                .subject(new Subject(111,"JAVA"))
                .build();
        student.setMemberId(123);
        Student student1 = Student.builder()
                .id(1)
                .name("Arnab")
                .department(Department.CSE)
                .subject(new Subject(111,"C++"))
                .build();
        student.setMemberId(123);
        Student studen2 = Student.builder()
                .id(1)
                .name("Chitti")
                .department(Department.IT)
                .subject(new Subject(111,"JAVA"))
                .build();
        student.setMemberId(123);



        /*System.out.println(student.getMemberId());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("subhash.txt"));
        objectOutputStream.writeObject(student);




        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("subhash.txt"));
        Student student1 = (Student) objectInputStream.readObject();
        System.out.println(student1.getMemberId());*/


        Student studentCloned = (Student) student.clone();

        System.out.println("CLONING.......");
        System.out.println("Cloned Object:: "+studentCloned);


        System.out.println(studentCloned==student);// false

        System.out.println(studentCloned.equals(student)); //true

        System.out.println(studentCloned.getClass() == student.getClass()); // true

        System.out.println(student instanceof Student); //
        System.out.println(studentCloned instanceof  Student); // true

        List<Student> students = Arrays.asList(student, student1, studen2);


        Map<Department, List<String>> departmentListMap1 =        students.stream().collect(Collectors.groupingBy(
                        Student::getDepartment, Collectors.mapping( t -> t.getName(), Collectors.toList())
                ))     ;

        System.out.println("departmentListMap1 :==== "+departmentListMap1);

        Map<Department, Long> departmentListMap = /*students.stream().collect(Collectors.groupingBy(Student::getDepartment));*/

                                                    students.stream().collect(Collectors.groupingBy(
                                                            Student::getDepartment, Collectors.mapping( t -> t.getName(), Collectors.counting())
                                                    ))     ;
        for(Map.Entry  entry: departmentListMap.entrySet()) {

            System.out.println(entry.getKey()+"====="+entry.getValue());

            String nonRepeatStr = "abcdabc";

            Optional<Map.Entry<Character, Long>>  characterLongMap = nonRepeatStr.chars()
                    .mapToObj( c-> Character.toLowerCase((char)c))
                    .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                            .entrySet().stream()
                            .filter(e -> e.getValue()==1L)
                    .findFirst();
            if(characterLongMap.isPresent()) {
                System.out.println(characterLongMap.get());
            }



            System.out.println(characterLongMap);
            System.out.println("for integers==========");






























            int[] numbers = {1,2,9,4,2,1,5,8,8,5};
            Map<Integer, Long> integerLongMap =  Arrays.stream(numbers).mapToObj(Integer::valueOf)
                    .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()));
            System.out.println(integerLongMap);

            /*Map.Entry<Integer, Long> firstNonrepeatableNumber = */integerLongMap.entrySet()
                    .stream()
                    .filter(e -> e.getValue()==1)
                    .findFirst().ifPresentOrElse(t-> System.out.println(t.getKey()), () -> System.out.println());
            //System.out.println(firstNonrepeatableNumber.getKey());























        }




    }
}