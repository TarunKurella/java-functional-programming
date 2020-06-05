package AwesomeStreams;

import java.util.ArrayList;
import java.util.Arrays;

public class FilteringData {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Tarun",10));
        students.add(new Student("Rohan",20));
        students.add(new Student("karthik",25));
        students.add(new Student("Reni",30));
        students.add(new Student("Dara",40));
        students.add(new Student("Koro",50));

        //chaining Filter operation. A Filter accepts a Predicate functional interface.
        //the below set of operations filter for students of age between 20 and 40
        students.stream().filter((s)->s.age>=20).filter((s)->s.age<=40).forEach(System.out::println);


        //notice even after performing such operations, the original datastructure remains intact
        System.out.println(students);


    }


    static class Student{
        private int age =  0;
        private String name;
        Student(String name,int age){
            this.age=age;
            this.name=name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
