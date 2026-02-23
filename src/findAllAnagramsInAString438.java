/*438. Найдите все анаграммы в строке
* Учитывая две строки s и p, верните массив всех
* начальных индексов p's anagrams в s. Вы можете вернуть
* ответ в любом порядке.*/

import java.util.*;
public class findAllAnagramsInAString438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();

            Map<Character, Integer> map = new HashMap<>();
            char[] pArray = p.toCharArray();
            for (int i = 0; i < pArray.length; i++) {
                char c = pArray[i];
                int сount = map.getOrDefault(c, 0);
                сount++;
                map.put(c, сount);
            }

            int counter = map.size();
            int begin = 0;
            int end = 0;
            int head = 0;
            int len = Integer.MAX_VALUE;

            while(end < s.length()){
                char c = s.charAt(end);
                if( map.containsKey(c) ){
                    map.put(c, map.get(c)-1);
                    if(map.get(c) == 0) counter--;
                }
                end++;

                while(counter == 0){
                    char tempc = s.charAt(begin);
                    if(map.containsKey(tempc)){
                        map.put(tempc, map.get(tempc) + 1);
                        if(map.get(tempc) > 0){
                            counter++;
                        }
                    }
                    if(end-begin == p.length()){
                        result.add(begin);
                    }
                    begin++;
                }

            }
            return result;
        }
    }
}
