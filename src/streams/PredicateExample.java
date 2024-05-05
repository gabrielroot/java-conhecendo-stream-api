package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "C#", "C++", "C", "C++", "C", "JavaScript", "Kotlin");

        Predicate<String> characterFilter = language -> language.length() > 3;

        List<String> languagesFiltered = languages.stream()
                .filter(characterFilter)
                .toList();

        languagesFiltered.forEach(System.out::println);
    }
}
