package AwesomeStreams;

import java.util.ArrayList;
import java.util.List;

public class Slicing {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Nissan");
        cars.add("Suzuki");
        cars.add("Suzuki");
        cars.add("Mercedes");
        cars.add("Jaguar");
        cars.add("Mercedes");

       //using limit and distinct
        cars.stream()
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        //using skip and distinct
        cars.stream()
                .distinct()
                .skip(2)
                .forEach(System.out::println);
    }
}
