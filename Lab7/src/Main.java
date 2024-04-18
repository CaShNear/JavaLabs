import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Вариант 1 задание 6

        System.out.print("Input some text: ");
        String text = in.nextLine();
        System.out.print("Input substring to compare: ");
        String substring = in.nextLine();
        System.out.print("Input word to insert: ");
        String insertWord = in.nextLine();

        String[] words = text.split("\\s+");
        StringBuilder changedText = new StringBuilder();
        for (String word : words){
            changedText.append(word).append(" ");
            if (word.replaceAll("[^a-zA-Zа-яА-Я ]", "").endsWith(substring)){
                changedText.append(insertWord).append(" ");
            }
        }
        System.out.println("Sorted text by words: " + changedText);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        System.out.print("Input some text: ");
        text = in.nextLine();
        System.out.print("Input choice (0/1): ");
        int choice = Integer.parseInt(in.nextLine());

        if (choice == 0) {
            System.out.print("Input symbol: ");
            String symbol = in.nextLine();
            String newText = text.replaceAll(String.valueOf(symbol), "");
            System.out.println("Changed text: " + newText);
        } else if (choice == 1) {
            System.out.print("Input position: ");
            int pos = Integer.parseInt(in.nextLine());
            System.out.print("Input symbol: ");
            String symbol = in.nextLine();
            StringBuilder newText = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                newText.append(text.charAt(i));
                if ((i + 1) % pos == 0) {
                    newText.append(symbol);
                }
            }
            System.out.println("Changed text: " + newText);
        } else {
            System.out.println("Wrong choice. Text doesn't changed");
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        System.out.print("Input some text: ");
        text = in.nextLine();

        Set<String> uniqueWords = Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .filter(word -> word.length() > 1 && word.charAt(0) == word.charAt(word.length() - 1))
                .collect(Collectors.toSet());

        System.out.println("Unique words with the same first and last letter: " + uniqueWords);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        System.out.print("Input some text: ");
        text = in.nextLine();
        words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        int minLength = Arrays.stream(words)
                .mapToInt(String::length)
                .min()
                .orElse(0);

        String[] minLengthWords = Arrays.stream(words)
                .filter(word -> word.length() == minLength)
                .toArray(String[]::new);

        int maxLength = Arrays.stream(words)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        String[] maxLengthWords = Arrays.stream(words)
                .filter(word -> word.length() == maxLength)
                .toArray(String[]::new);

        System.out.println("Words with minimum length: " + Arrays.toString(minLengthWords));
        System.out.println("Words with maximum length: " + Arrays.toString(maxLengthWords));

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 6

        System.out.print("Input some text: ");
        text = in.nextLine();
        words = text.split("\\s+");
        String changedLine = String.join(" ", Arrays.copyOfRange(words, 1, words.length)) + " " + words[0];
        System.out.println("Changed text: " + changedLine);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 7

        System.out.print("Input some text: ");
        text = in.nextLine();
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i += 3) {
            encryptedText.append(text.charAt(i));
        }
        for (int i = 1; i < text.length(); i += 3) {
            encryptedText.append(text.charAt(i));
        }
        for (int i = 2; i < text.length(); i += 3) {
            encryptedText.append(text.charAt(i));
        }
        System.out.println("Encrypted text: " + encryptedText);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 6

        System.out.print("Input some text: ");
        text = in.nextLine();

        words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").toLowerCase().split("\\s+");
        Arrays.sort(words);
        System.out.println("Sorted text by words: " + String.join(" ", words));

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 7

        System.out.print("Input some text: ");
        text = in.nextLine();

        words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                count++;
            }
        }

        System.out.println("Count of words that starts with uppercase letter: " + count);

    }

}