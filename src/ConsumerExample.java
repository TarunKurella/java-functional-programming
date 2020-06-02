import java.util.Arrays;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {


    public static void main(String[] args) {
        Consumer<String> print = s-> System.out.println(s);
        print.accept("Hello");

        BiConsumer<String,Integer> printWithAge = (s,i)->System.out.println(s+" age is "+i );
        printWithAge.accept("Tarun",20);


        //example for using andThen
        capitaliseStrings();
    }

    public static void capitaliseStrings(){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };

        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }
}
