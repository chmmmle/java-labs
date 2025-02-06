public class Rotation {
    public static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // новый массив для результата
        int[][] rotatedMatrix = new int[cols][rows];
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[cols - j - 1][i] = matrix[i][j];
            }
        }
        
        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Исходный массив:");
        printMatrix(matrix);

        int[][] rotatedMatrix = rotateMatrix(matrix);

        System.out.println("\nМассив после поворота на 90 градусов против часовой стрелки:");
        printMatrix(rotatedMatrix);
    }
}

