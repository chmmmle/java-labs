import java.util.Scanner;

public class AlternatingSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вводим количество чисел
        int n = scanner.nextInt();

        int sum = 0;

        // Читаем числа и вычисляем знакочередующуюся сумму
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            
            // Если индекс четный (начинаем с 0), прибавляем число, если нечетный - вычитаем
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        // Выводим результат
        System.out.println(sum);

        // Закрываем scanner
        scanner.close();
    }
}
