public class MaxSum {
    public static int[] findMax(int[] nums) {
        // Если массив пуст, возвращаем пустой массив
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int maxSum = nums[0];  // Начальная максимальная сумма
        int currentSum = nums[0];  // Текущая сумма
        int start = 0;  // Начало подмассива с максимальной суммой
        int end = 0;  // Конец подмассива с максимальной суммой
        int tempStart = 0;  // Временный индекс для начала подмассива

        for (int i = 1; i < nums.length; i++) {
            // Если текущая сумма больше нуля, прибавляем к ней элемент массива
            // Иначе начинаем новый подмассив с текущего элемента
            if (currentSum + nums[i] > nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
                tempStart = i;
            }

            // Если текущая сумма больше максимальной суммы, обновляем значения
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Создаем массив с подмассивом, который дает максимальную сумму
        int[] resultSubarray = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            resultSubarray[i - start] = nums[i];
        }

        System.out.println("Максимальная сумма подмассива: " + maxSum);
        System.out.print("Сам подмассив: ");
        for (int num : resultSubarray) {
            System.out.print(num + " ");
        }

        return resultSubarray;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 10};
        findMax(nums);
    }
}
