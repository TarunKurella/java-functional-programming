package PlayingWithLamdas;

import java.util.ArrayList;
import java.util.Collections;

class Person{
    int age ;
    String name;
    Person(int age,String name){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "PlayingWithLamdas.Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ByeComparator {


    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(23,"boro"));
        persons.add(new Person(28,"hara"));
        persons.add(new Person(20,"bebo"));

         //before

//        Collections.sort(persons, new Comparator<PlayingWithLamdas.Person>() {
//            @Override
//            public int compare(PlayingWithLamdas.Person o1, PlayingWithLamdas.Person o2) {
//                return Integer.compare(o1.age,o2.age);
//            }
//        });

        //now thnx to lamdas

        Collections.sort(persons,(o1,o2)->Integer.compare(o1.age,o2.age));

        System.out.println(persons);
    }
}
