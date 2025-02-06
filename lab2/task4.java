public class Rotate {
    public static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;  // количество строк
        int m = matrix[0].length;  // количество столбцов
        
        // Создаем новый массив для результата
        int[][] rotatedMatrix = new int[m][n];
        
        // Заполняем новый массив поворачивая элементы исходного
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        
        return rotatedMatrix;
    }

    // Метод для вывода
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {1, 3, 7}
        };

        System.out.println("Исходный массив:");
        printMatrix(matrix);

        // Поворот массива
        int[][] rotatedMatrix = rotateMatrix(matrix);
        
        System.out.println("\nМассив после поворота:");
        printMatrix(rotatedMatrix);
    }
}
