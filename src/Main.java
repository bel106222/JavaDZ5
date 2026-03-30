import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/*
Задание 1
Пользователь вводит с клавиатуры набор чисел. Полученные числа
необходимо сохранить в список. После чего нужно показать меню,
в котором предложить пользователю набор пунктов:
1. Добавить элемент в список;
2. Удалить элемент из списка;
3. Показать содержимое списка;
4. Проверить есть ли значение в списке;
5. Заменить значение в списке.
В зависимости от выбора пользователя выполняется
действие, после чего меню отображается снова.
Для решения задачи используйте подходящий класс
из Java Collections Framework.
Задание 2
Создайте и вызовите следующие лямбда-выражения:
■ Максимум из двух;
■ Минимум из двух;
■ Факториал числа;
■ Проверка простое число или нет.
Задание 3
Создайте и вызовите следующие лямбда-выражения.
Обязательно использовать лямбду, как параметр метода. Метод
находит сумму элементов массива, которые соответствуют
условию лямбда-выражения. Варианты лямбда-выражений:
■ Проверка на четность;
■ Проверка на нечетность;
■ Число находится в диапазоне от A до B;
■ Проверка на кратность параметру A.
Задание 4
Создайте и вызовите следующие лямбда-выражения:
Проверка является ли год високосным;
Подсчет количества дней между двумя датами;
Подсчёт количества полных недель между двумя датами;
Подсчет дня недели по полученной дате. Например,
20 июля 1969 года — воскресенье.
Задание 5
Создайте и вызовите следующие лямбда-выражения:
■ Сумма двух дробей;
■ Разница двух дробей;
■ Произведение двух дробей;
■ Деление двух дробей.
Задание 6
Создайте и вызовите следующие лямбда-выражения.
Обязательно использовать шаблоны:
■ Максимум из четырех;
■ Минимум из четырёх.
Задание 7
Создайте и вызовите следующие лямбда-выражения.
Обязательно использовать лямбду, как параметр метода.
Метод находит сумму элементов массива, которые соответствуют условию
лямбда-выражения. Варианты лямбда-выражений:
Проверка на равенство конкретному числу;
Число не находится в диапазоне от А до В;
Проверка на положительность числа;
Проверка на отрицательность числа.
*/
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("ДОМАШНЕЕ ЗАДАНИЕ №5\n");

        for (int i = 1; i <= 12; i++) {
            System.out.println("Задание №" + i);
            switch(i)
            {
                case 1:
                    //listManager();
                    break;
                case 2:
                    lambdaExpressions();
                    break;
                case 3:
                    lambdaParameter();
                    break;
                case 4:
                    //sixDigitNumber();
                    break;
                case 5:
                    //showSeason();
                    break;
                case 6:
                    //lengths();
                    break;
                case 7:
                    //showOdd();
                    break;
                case 8:
                    //showTable();
                    break;
                case 9:
                    //analysisArray();
                    break;
                case 10:
                    //createArray();
                    break;
                case 11:
                    //lines();
                    break;
                case 12:
                    //sort();
                    break;
            }
        }
    }

    private static void listManager() {
        ArrayList<Integer> list = createIntList ();

        int choise = -1;
        while (choise != 0) {
            System.out.print("Ваш список: " + list);
            choise = menu();
            if (choise < 0 || choise > 5) {
                System.out.println("Некорректный ввод!");
            }
            switch(choise) {
                case 1:
                    System.out.print("Введите число для добавления:>");
                    list.add(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Введите индекс для удаления: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < list.size()) {
                        list.remove(index);
                    } else {
                        System.out.println("Некорректный индекс!");
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Текущий список: " + list);
                    break;
                case 4:
                    System.out.print("Введите число для поиска:>");
                    int value = scanner.nextInt();
                    System.out.println(list.contains(value)
                            ? "Число " + value + " есть в этом списке."
                            : "Числа " + value + " нет в этом списке.");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Введите индекс для замены:>");
                    int idx = scanner.nextInt();
                    System.out.print("Введите новое значение:>");
                    int newValue = scanner.nextInt();
                    if (idx >= 0 && idx < list.size()) {
                        list.set(idx, newValue);
                    } else {
                        System.out.println("Некорректный индекс!");
                    }
                    scanner.nextLine();
                    break;
            }
        }
        System.out.println("Выход...");
    }

    private static void lambdaExpressions() {
        // Больше - меньше
        @FunctionalInterface
        interface MinMaxFunction {
            int minMax(int a, int b);
        }
        MinMaxFunction min = (a, b) -> (a < b) ? a : b;
        MinMaxFunction max = (a, b) -> (a > b) ? a : b;
        System.out.println("Минимум: " + min.minMax(1, 2));
        System.out.println("Максимум: " + max.minMax(1, 2));

        // Факториал числа
        Function<Integer, Long> factorial = n -> {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Факториал 5: " + factorial.apply(5));

        // Проверка на простое число
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println("7 — простое? " + isPrime.test(7));
        System.out.println("10 — простое? " + isPrime.test(10));
    }

    private static void lambdaParameter() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Массив: " + Arrays.toString(array));

        // 1. Сумма четных чисел
        int evenSum = sumWithCondition(array, n -> n % 2 == 0);
        System.out.println("Сумма четных: " + evenSum);

        // 2. Сумма нечетных чисел
        int oddSum = sumWithCondition(array, n -> n % 2 != 0);
        System.out.println("Сумма нечетных: " + oddSum);

        // 3. Сумма чисел в диапазоне от A до B
        int a = 3;
        int b = 7;
        int rangeSum = sumWithCondition(array, n -> n >= a && n <= b);
        System.out.println("Сумма в диапазоне от " + a + " до " + b + " равна: " + rangeSum);

        // 4. Сумма чисел, кратных A
        int k = 3;
        int multipleSum = sumWithCondition(array, n -> n % k == 0);
        System.out.println("Сумма чисел, кратных " + k + ": " + multipleSum);

    }

    public static int sumWithCondition(int[] numbers, Predicate<Integer> condition) {
        int sum = 0;
        for (int num : numbers) {
            // Если элемент удовлетворяет условию, добавляем его к сумме
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    private static int menu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить элемент в список");
        System.out.println("2. Удалить элемент из списка");
        System.out.println("3. Показать содержимое списка");
        System.out.println("4. Проверить есть ли значение в списке");
        System.out.println("5. Заменить значение в списке");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор:>");
        int inputInt = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return inputInt;
    }

    private static ArrayList<Integer> createIntList () {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Введите несколько чисел через пробел:");
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            try {
                list.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Пропущен некорректный ввод: " + s);
            }
        }
        return list;
    }
}

