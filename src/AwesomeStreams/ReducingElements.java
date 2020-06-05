package AwesomeStreams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReducingElements {
    public static void main(String[] args) {

        long ans  = factorialof(4);
        System.out.println(ans);

    }

    static long factorialof(int n){
        return IntStream.rangeClosed(1,n).reduce(1,ReducingElements::multiply);
    }
    static int multiply(int p,int q){
        return p*q;
    }
}

/*
for example factorial of 4

we have an int stream like this : 1  2  3  4  thanks to ranged closed

we use Reduce to aggregrate the values from previous step, using a Binary Operator functional interface called accumulator.

steps are visualised as follows

1 * 2 3 4


2 * 3 4

6 * 4

24 --->answer

 */
