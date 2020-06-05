package PlayingWithLamdas;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        supplier();

    }
    static void supplier(){
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }
}
