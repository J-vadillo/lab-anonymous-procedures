package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import labs.lambdas.Person;

/**
 * JTLambdaExperiments.java
 *
 * A variety of experiments for working with lambdas, based on the
 * Java Tutorial on lambda expressions, available at
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author Samuel A. Rebelsky
 * @author Jana Vadillo
 * @author Princess Alexander
 */
public class JTLambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    List<Person> roster = Person.createRoster();

    System.out.println("Method 1.");
    printPersonsOlderThan(roster, 30);
    System.out.println("Method 2.");
    printPersonsWithinAgeRange(roster, 30, 40);

    // printPersons(
    // roster, new CheckPersonEligibleForSelectiveService());

  } // main(String[])

  public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
      if (p.getAge() >= age) {
        p.printPerson();
      }
    }
  }

  public static void printPersonsWithinAgeRange(
      List<Person> roster, int low, int high) {
    for (Person p : roster) {
      if (low <= p.getAge() && p.getAge() < high) {
        p.printPerson();
      }
    }
  }

  interface CheckPerson {
    boolean test(Person p);
  }

  public static void printPersons(
      List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
      if (tester.test(p)) {
        p.printPerson();
      }
    }
  }

  class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}

  // +--------------------------------+------------------------------
  // | Methods from the Java Tutorial |
  // +--------------------------------+

} // class JTLambdaExperiments
