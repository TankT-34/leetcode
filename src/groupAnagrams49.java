/*49. Групповые анаграммы
* Дан массив строк strs, сгруппируйте анаграммы вместе.
* Вы можете вернуть ответ в любом порядке.*/

import java.util.*;
public class groupAnagrams49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagrams = new HashMap<>();
            for (int i = 0; i < strs.length; i++){
                String word = strs[i];
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (!anagrams.containsKey(key)){
                    anagrams.put(key, new ArrayList<>());
                }
                anagrams.get(key).add(word);
            }
            return new ArrayList<>(anagrams.values());
        }
    }
}
