package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<int[], String> count = elements -> "Count = "
                                                    + elements.length;
        Function<int[], String> sum = elements -> "Sum = "
                                                  + Arrays.stream(elements).sum();

        int[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));

    }
}
