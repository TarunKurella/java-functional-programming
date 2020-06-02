import java.util.function.BiPredicate;


/*
The Predicate<T> takes only one parameter and returns the result.
Now suppose we have a requirement where we need to send two parameters (i.e person object and min age to vote)
and then return the result. Here, we can use BiPredicate<T, T>.
 */
class Usingpredicate {

    static boolean isPersonEligibleForVoting(
            Person2 person, Integer minAge, BiPredicate<Person2, Integer> predicate) {
        return predicate.test(person, minAge);
    }

    public static void main(String args[]) {
        Person2 person = new Person2("Alex", 23);
        boolean eligible =
                isPersonEligibleForVoting(
                        person,
                        18,
                        (p, minAge) -> {
                            return p.age > minAge;
                        });
        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age){
        this.name = name;
        this.age = age;
    }
}