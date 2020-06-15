package AwesomeStreams;

import java.util.*;

/*
Questions:
1.  Find all transactions in the year 2011 and sort them by value (small to high).
2.  What are all the unique cities where the traders work?
3.  Find all traders from Cambridge and sort them by name.
4.  Return a string of all traders’ names sorted alphabetically.
5.  Are any traders based in Milan?
6.  Print all transactions’ values from the traders living in Cambridge.
7.  What’s the highest value of all the transactions?
8.  Find the transaction with the smallest value.
 */

import java.util.List;
import java.util.stream.Stream;

public class ExcerciseOnStreams {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1
        transactions.stream().filter(t->t.year==2011).sorted((t1,t2)->Integer.compare(t1.value,t2.value)).forEach(System.out::print);
        //2
        System.out.println("2nd ans:");
       transactions.stream().map(transaction -> transaction.trader.city).distinct().forEach(System.out::println);

        System.out.println("3rd ans:");
        transactions.stream().filter(transaction -> transaction.trader.city.equals("Cambridge")).map(transaction -> transaction.trader.name).sorted().forEach(System.out::println);

        System.out.println("4th ans:");
        transactions.stream().map(transaction -> transaction.trader.name).distinct().sorted().forEach(System.out::println);

        System.out.println( "5th ans: "+transactions.stream().anyMatch(transaction -> transaction.trader.city.equals("Milan")));

        System.out.println("6th ans:");
        transactions.stream().filter(transaction -> transaction.trader.city.equals("Cambridge")).map(transaction -> transaction.value).forEach(System.out::println);

        System.out.println("7th ans:");
        System.out.println(transactions.stream().mapToInt(transaction -> transaction.value).max());

        System.out.println("8th ans:");
        System.out.println(transactions.stream().reduce((t1,t2)->t1.value<t2.value?t1:t2).get().toString());

    }

    static class Trader{

        private final String name;
        private final String city;

        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName(){
            return this.name;
        }

        public String getCity(){
            return this.city;
        }

        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

   static class Transaction{

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader(){
            return this.trader;
        }

        public int getYear(){
            return this.year;
        }

        public int getValue(){
            return this.value;
        }

        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }
}
