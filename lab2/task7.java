public class Main {
    public static int[] findMaxInRow(int[][] array) {
        int[] result = new int[array.length]; 
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0]; 
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j]; 
                }
            }
            result[i] = max; 
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {
            {1, 3, 2, 4},
            {10, 5, 8, 7}
        };

        int[] maxValues = findMaxInRow(array);

        
        for (int max : maxValues) {
            System.out.print(max + " ");
        }
    }
}
