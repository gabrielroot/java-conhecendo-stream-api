package streamsChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ChallengeConsole {
    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            ChallengeConsole.showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 0: break;
                case 1: ChallengeConsole.orderList(numbers); break;
                case 2: ChallengeConsole.pairsSum(numbers); break;
                case 3: ChallengeConsole.checkIfAllPositive(numbers); break;
                case 4: ChallengeConsole.removeOdd(numbers); break;
                case 5: ChallengeConsole.averageGtFive(numbers); break;
                case 6: ChallengeConsole.checkAnyGtTen(numbers); break;
                case 7: ChallengeConsole.findSecondGreater(numbers); break;
                case 8: ChallengeConsole.sumAllDigits(numbers); break;
                case 9: ChallengeConsole.checkIfAllAreDistinct(numbers); break;
                case 10: ChallengeConsole.groupedThreeOrFiveMultipleNumbers(numbers); break;
                case 11: ChallengeConsole.sumOfSquare(numbers); break;
                default: System.out.println("Opção inválida."); break;
            }
        }
    }

    private static void sumOfSquare(List<Integer> numbers) {
        int sum = numbers.stream()
            .reduce(0, (acc, number) -> acc + (number * number));

        System.out.printf("Soma dos quadrados = %d\n", sum);
    }

    private static void groupedThreeOrFiveMultipleNumbers(List<Integer> numbers) {
        List<Integer> groupedNumbers = numbers.stream()
            .filter(number -> number % 2 == 1 && (number % 3 == 0 || number % 5 == 0))
            .toList();

        ChallengeConsole.showFormatedNumbers(groupedNumbers);
    }

    private static void checkIfAllAreDistinct(List<Integer> numbers) {
        long distintValuesSum = numbers.stream()
            .distinct()
            .count();

        if (numbers.size() == distintValuesSum) {
            System.out.println("Sim, todos os números são distintos!");
        } else {
            System.out.println("Não, os números da lista não são distintos.");
        }
    }

    private static void sumAllDigits(List<Integer> numbers) {
        int total = numbers.stream()
            .reduce(0, (acc, number) -> {
                String digits = Integer.toString(number);
                int sumDigits = 0;
                for (char digit : digits.toCharArray()) {
                    sumDigits += Character.digit(digit, 10);
                }
                return acc + sumDigits;
            });

        System.out.printf("Soma = %d\n", total);
    }

    private static void findSecondGreater(List<Integer> numbers) {
        numbers.sort(Integer::compare);
        System.out.printf("Segundo maior = %d\n", numbers.get(numbers.size() - 2));
    }

    private static void checkAnyGtTen(List<Integer> numbers) {
        System.out.println("Verificando se há algum número maior que 10...");
        boolean anyGtTen = numbers.stream()
            .anyMatch(number -> number > 10);

        if (anyGtTen)
            System.out.println("Sim, há algum número maior que 10!");
        else
            System.out.println("Não, não há nenhum número maior que 10.");
    }

    private static void averageGtFive(List<Integer> numbers) {
        System.out.println("Média de números maiores que 5...");
        List<Integer> gtFiveNumbers = numbers.stream()
            .filter(number -> number > 5)
            .toList();

        int sum = gtFiveNumbers.stream()
            .reduce(0, Integer::sum);

        int avg = sum / gtFiveNumbers.size();

        System.out.printf("Média = %d\n", avg);
    }

    private static void removeOdd(List<Integer> numbers) {
        System.out.println("Removendo números ímpares...");
        List<Integer> pairNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        ChallengeConsole.showFormatedNumbers(pairNumbers);
    }

    private static void checkIfAllPositive(List<Integer> numbers) {
        System.out.println("Verificando se todos são positivos...");
        boolean allPositive = numbers.stream()
                .allMatch(number -> number >= 0);

        if (allPositive)
            System.out.println("Sim, todos os números são positivos!");
        else
            System.out.println("Não, nem todos são positivos.");
    }

    private static void pairsSum(List<Integer> numbers) {
        System.out.println("Somando os números pares...");
        int sum = numbers.stream()
            .filter(number -> number % 2 == 0)
            .reduce(0, Integer::sum);

        System.out.printf("Soma = %d", sum);
    }

    private static void orderList(List<Integer> numbers) {
        System.out.println("Ordenando a lista...");
        numbers.sort(Integer::compare);
        ChallengeConsole.showFormatedNumbers(numbers);
    }

    private static void showFormatedNumbers(List<Integer> numbers) {
        IntStream.range(0, numbers.size())
            .forEach(i -> {
                if (i == 0)
                    System.out.print('[');

                System.out.printf((i + 1 < numbers.size()) ? "%d, " : "%d", numbers.get(i));

                if (i + 1 == numbers.size())
                    System.out.println(']');
            }
        );
    }

    private static void showMenu() {
        System.out.println("==============================================");
        ChallengeConsole.showFormatedNumbers(ChallengeConsole.numbers);
        System.out.println("=--------------------------------------------=");
        System.out.println("= 1 - Ordenar lista()                        =");
        System.out.println("= 2 - Somar números pares()                  =");
        System.out.println("= 3 - Checar se todos são positivos()        =");
        System.out.println("= 4 - Remover números ímpares()              =");
        System.out.println("= 5 - Média de números maiores que 5()       =");
        System.out.println("= 6 - Checar se há algum maior que 10()      =");
        System.out.println("= 7 - Encontrar o segundo maior número()     =");
        System.out.println("= 8 - Somar dígitos dos números()            =");
        System.out.println("= 9 - Checar se todos são distintos()        =");
        System.out.println("= 10 - Agrupar múltiplos de 3 ou 5()         =");
        System.out.println("= 11 - Soma dos quadrados()                  =");
        System.out.println("= 0 - Encerrar()                             =");
        System.out.println("==============================================");
    }
}
