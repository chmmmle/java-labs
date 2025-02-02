
import java.util.Scanner;

public class Treasure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод координат клада
        int xTreasure = scanner.nextInt();
        int yTreasure = scanner.nextInt();
        
        // Инициализация начальных координат
        int x = 0;
        int y = 0;
        
        // Переменная для подсчета минимальных шагов
        int steps = 0;
        
        // Массив для хранения всех команд
        String[] directions = new String[100];  // Будем хранить до 100 направлений
        int[] distances = new int[100];
        int commandCount = 0;
        
        // Чтение команд
        while (true) {
            String direction = scanner.next();
            
            if (direction.equals("стоп")) {
                break; // Выход из цикла, если команда "стоп"
            }
            
            int distance = scanner.nextInt();
            
            // Сохраняем команду в массив
            directions[commandCount] = direction;
            distances[commandCount] = distance;
            commandCount++;
        }
        
        // Пробуем выполнить команды и искать минимальное количество шагов для достижения клада
        for (int i = 0; i < commandCount; i++) {
            String direction = directions[i];
            int distance = distances[i];
            
            // В зависимости от направления обновляем координаты
            switch (direction) {
                case "север":
                    y += distance;
                    break;
                case "юг":
                    y -= distance;
                    break;
                case "запад":
                    x -= distance;
                    break;
                case "восток":
                    x += distance;
                    break;
            }
            
            // Если мы достигли нужных координат, выводим количество шагов
            if (x == xTreasure && y == yTreasure) {
                System.out.println(i + 1);
                return;
            }
        }

        // Если клад не найден по завершении всех команд
        System.out.println("Клад не найден!");
        
        scanner.close();
    }
}
