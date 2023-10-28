import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task A: Create an array with the values (1, 2, 3, 4, 5, 6, 7) and shuffle it.
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        shuffleArray(numbers);

        System.out.print("Shuffled array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Task B: Enter a Roman Number as input and convert it to an integer.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine();
        int integerValue = romanToInteger(romanNumeral);
        System.out.println("Integer equivalent: " + integerValue);

        // Task C: Check if the input is a pangram or not.
        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();
        boolean isPangram = isPangram(inputSentence);
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }

        scanner.close();
    }

    public static void shuffleArray(int[] arr) {
        Random random = new Random();
        int n = arr.length;

        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int romanToInteger(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = romanValue(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }

    public static int romanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static boolean isPangram(String sentence) {
        String lowercaseSentence = sentence.toLowerCase();
        boolean[] alphabet = new boolean[26]; // Using an array to track letter occurrences

        for (int i = 0; i < lowercaseSentence.length(); i++) {
            char c = lowercaseSentence.charAt(i);
            if (c >= 'a' && c <= 'z') {
                alphabet[c - 'a'] = true;
            }
        }

        for (boolean letter : alphabet) {
            if (!letter) {
                return false;
            }
        }

        return true;
    }
}
