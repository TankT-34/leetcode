/* 567. Перестановка символов в строке
 * Для двух строк s1 и s2 верните true в случае, если s2 содержит перестановку s1,
 *  или false в противном случае.
 * Другими словами, верните true в случае, если одна из перестановок s1 является
 *  подстрокой s2.*/

import java.util.*;
public class permutationInString567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;

            Map<Character, Integer> s1Count = new HashMap<>();
            Map<Character, Integer> map = new HashMap<>();

            char[] s1Array = s1.toCharArray();
            for (int i = 0; i < s1Array.length; i++) {
                char c = s1Array[i];
                int сount = s1Count.getOrDefault(c, 0);
                сount++;
                s1Count.put(c, сount);
            }

            for (int i = 0; i < s1.length(); i++) {
                char c = s2.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (s1Count.equals(map)) return true;

            for (int i = s1.length(); i < s2.length(); i++) {
                char c = s2.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);

                char oldChar = s2.charAt(i - s1.length());
                map.put(oldChar, map.get(oldChar) - 1);
                if (map.get(oldChar) == 0) {
                    map.remove(oldChar);
                }

                if (s1Count.equals(map)) {
                    return true;
                }
            }
            return false;
        }
    }
}
