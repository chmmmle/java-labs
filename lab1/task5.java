import java.util.Scanner;

public class Number{
public static void main(String[] args) {
        // входное число
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();

        // Проверка на трехзначность
        if (number < 100 || number > 999) {
            System.out.println("Ошибка: введено не трехзначное число.");
            return;
        }
        

        // Получаем цифры числа
        int hundreds = number / 100; // Сотни
        int tens = (number / 10) % 10; // Десятки
        int ones = number % 10; // Единицы

        // Проверяем, что сумма цифр четная
        int sum = hundreds + tens + ones;
        boolean isSumEven = sum % 2 == 0;

        // Проверяем, что произведение цифр четное
        int product = hundreds * tens * ones;
        boolean isProductEven = product % 2 == 0;

        // Проверяем, является ли число "дважды четным"
        if (isSumEven && isProductEven) {
            System.out.println("Число является 'дважды четным'");
        } else {
            System.out.println("Число не является 'дважды четным'");
        }
        scanner.close();
    }
}
