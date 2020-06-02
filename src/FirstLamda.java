interface  Greeting{
    void greet();
}

class HindiGreeting implements Greeting{
    @Override
    public void greet() {
        System.out.println("namaste");
    }
}

class EnglishGreeting implements Greeting{
    @Override
    public void greet() {
        System.out.println("Hello");
    }
}

public class FirstLamda {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }
    public static void main(String[] args) {
        wish(new HindiGreeting());
        wish(new EnglishGreeting());
       //Do we need to create a class for each language, e.g., SpanishGreeting, FrenchGreeting, etc?

        //example of lamda
        wish(()-> System.out.println("wow"));

    }
}

/*
This is a classic object-oriented programming example. Now, what if we want our Firstlamda class to greet in all the languages available?

Isn’t it possible that we don’t create any class and just send a function to the wish(Greeting greeting) method?

Afcourse then we can use anonymous class. But still, the code will still look cumbersome.

we can use lamdas. Lambdas get wrapped inside new classes generated during runtime.
 */


