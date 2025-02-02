import java.util.Scanner;


public class Roads {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int maxHeight = -1; // минимальная высота
        int bestRoad = -1;  // Номер дороги минимальной высотой
        
        // Перебор всех дорог
        for (int roadNumber = 1; roadNumber <= n; roadNumber++) {
            // Чтение количества туннелей на текущей дороге
            int m = scanner.nextInt();
            
            int minHeight = Integer.MAX_VALUE; 
            
            // Чтение высот туннелей
            for (int i = 0; i < m; i++) {
                int tunnelHeight = scanner.nextInt();
                if (tunnelHeight < minHeight) {
                    minHeight = tunnelHeight; // Находим минимальную высоту на этой дороге
                }
            }
            
            // Если минимальная высота на текущей дороге больше, чем на предыдущей, обновляем результат
            if (minHeight > maxHeight) {
                maxHeight = minHeight;
                bestRoad = roadNumber;
            }
        }
        
        // Выводим номер дороги и максимальную минимальную высоту
        System.out.println(bestRoad + " " + maxHeight);
        scanner.close();
    }
}
