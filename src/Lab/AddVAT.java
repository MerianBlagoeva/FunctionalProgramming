package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "1.38, 2.56, 4.4";

        double[] prices = Arrays.stream(input.split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVat = p -> p * 1.20;
        Consumer<double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(addVat)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };
        printPrices.accept(prices);
    }
}
