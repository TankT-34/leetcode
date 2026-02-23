/*3. Самая длинная подстрока без повторяющихся символов
* Для заданной строки sнайдите длину самой длинной подстроки
* без повторяющихся символов.*/

import java.util.*;
public class longestSubstringWithoutRepeatingCharacters3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            char[] sChar = s.toCharArray();
            int count = 0;
            int left = 0;
            for (int right = 0; right < sChar.length; right++){
                char currentChar = sChar[right];
                if (map.containsKey(currentChar) && map.get(currentChar) >= left){
                    left = map.get(currentChar) + 1;
                }
                map.put(currentChar, right);
                count = Math.max(count, right - left + 1);
            }
            return count;
        }
    }
}
