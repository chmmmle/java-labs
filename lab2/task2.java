import java.util.Arrays;

public class Sorted {
    public static int[] SortedArrays(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;
        
        int[] mergedArray = new int[n + m];  // массив для хранения результата
        int i = 0, j = 0, k = 0;  // Индексы для массивов
        
        // Пока один из массивов не завершился
        while (i < n && j < m) {
            if (array1[i] < array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }
        
        // Копируем оставшиеся элементы из первого массива, если они есть
        while (i < n) {
            mergedArray[k++] = array1[i++];
        }
        
        // Копируем оставшиеся элементы из второго массива, если они есть
        while (j < m) {
            mergedArray[k++] = array2[j++];
        }
        
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 6};
        int[] array2 = {2, 4, 7, 8};
        
        int[] mergedArray = SortedArrays(array1, array2);
        
        // Вывод объединенный массив
        System.out.println(Arrays.toString(mergedArray));
    }
}
