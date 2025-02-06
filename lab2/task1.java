import java.util.HashSet;
import java.util.Set;

public class LongestUnique {
    public static String Unique(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, maxLength = 0, maxStart = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // Если символ уже есть в множестве, перемещаем начало подстроки
            while (set.contains(currentChar)) {
                set.remove(s.charAt(start));
                start++;
            }
            
            // текущий символ в множество
            set.add(currentChar);
            
            
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }
        
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String input = "abcabcbbcads";
        String result = Unique(input);
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + result);
    }
}
