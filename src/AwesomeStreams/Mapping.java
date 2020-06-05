package AwesomeStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapping {

    public static void main(String[] args) {
        ArrayList<FilteringData.Student> students = new ArrayList<>();
        students.add(new FilteringData.Student("Tarun",10));
        students.add(new FilteringData.Student("Rohan",20));
        students.add(new FilteringData.Student("karthik",25));
        students.add(new FilteringData.Student("Reni",30));
        students.add(new FilteringData.Student("Dara",40));
        students.add(new FilteringData.Student("Koro",50));

        students.stream().map(s->s.getName().toUpperCase()).forEach(System.out::println);


        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));

        //intermediate methods such as filter() and distinct() do not work on streams of Collection
        //So, we need to flatten our stream before using these intermediate functions
        list.stream()
                .flatMap(s -> s.stream())
                .filter(x -> "a".equals(x))
                .forEach(System.out::println);
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

        public void setName(String name) {
            this.name = name;
        }
    }
}
