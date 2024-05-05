package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer, Integer> dobrar = number -> number * 2;

        List<Integer> doubledNumbers = numeros.stream()
                .map(number -> number * 2)
                .toList();

        doubledNumbers.forEach(System.out::println);
    }
}
