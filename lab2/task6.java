public class Main {
    public static int sumOfElements(int[][] array) {
        int sum = 0; 
        for (int i = 0; i < array.length; i++) { 
            for (int j = 0; j < array[i].length; j++) { 
                sum += array[i][j]; 
            }
        }
        return sum; 
    }

    public static void main(String[] args) {
        
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, 4,9}
        };

        
        int result = sumOfElements(array);
        System.out.println("Сумма всех элементов в массиве: " + result);
    }
}

