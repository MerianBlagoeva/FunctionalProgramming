package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split("\\s+");

        Predicate<String> isStartingWithUppercase =
                w -> Character.isUpperCase(w.charAt(0));

        ArrayDeque<String> stackOfQueue = new ArrayDeque<>();

        Arrays.stream(words)
                .filter(isStartingWithUppercase)
                .forEach(stackOfQueue::offer);

        System.out.println(stackOfQueue.size());

        while (!stackOfQueue.isEmpty()) {
            System.out.println(stackOfQueue.poll());
        }

    }
}
