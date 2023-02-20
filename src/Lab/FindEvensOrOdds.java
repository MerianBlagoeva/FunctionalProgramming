package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] bounds = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = bounds[0];
        int end = bounds[1];

        String command = sc.nextLine();

        IntPredicate predicate = n -> command.equals("odd") == (n % 2 != 0);

        String output = IntStream.rangeClosed(begin, end)
                .filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
