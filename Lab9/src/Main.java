import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Вариант 1 задание 6

        List<String> stringList = Arrays.asList("Some", "kind", "of", "text");
        String combinedString = stringList.stream()
                        .collect(Collectors.joining(":"));
        System.out.println("Combined string: " + combinedString);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        stringList = Arrays.asList("yeah", "yeah", "and", "I'm", "back", "and", "I'm", "back", "again");
        stringList.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        List<Integer> integerList = Arrays.asList(10, 25, 30, 45, 50);
        int sumOfEvenNumbers = integerList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        double averageOfNumbersMinusTen = integerList.stream()
                .map(num -> num - 10)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("Average of numbers minus ten from each number: " + averageOfNumbersMinusTen);

    }

}