import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вводим число n
        int n = scanner.nextInt();
        
        int steps = 0; // Счётчик шагов

        // Выполняем итерации до тех пор, пока n не станет равным 1
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2; // Если число чётное, делим на 2
            } else {
                n = 3 * n + 1; // Если число нечётное, умножаем на 3 и прибавляем 1
            }
            steps++; // Увеличиваем счётчик шагов
        }

        // Выводим количество шагов
        System.out.println(steps);
        scanner.close();
    }
}
