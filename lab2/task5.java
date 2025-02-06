import java.util.HashSet;

public class PairSum {
    public static int[] findPair(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            
            int complement = target - num;
            if (seen.contains(complement)) {
                return new int[] {complement, num};  
            }
            
            seen.add(num);
        }

        
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 14;

        int[] result = findPair(arr, target);

        if (result != null) {
            System.out.println("Пара элементов: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пара с суммой " + target + " не найдена.");
        }
    }
}

