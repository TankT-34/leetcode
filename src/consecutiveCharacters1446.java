/*1446. Последовательные символы
* Степень строки - это максимальная длина непустой подстроки, содержащей только
* один уникальный символ.
* Учитывая строку s, верните степень из s.*/

import java.util.*;
public class consecutiveCharacters1446 {
    class Solution {
        public int maxPower(String s) {
            if (s == null){
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            char[] sChar = s.toCharArray();
            map.put(sChar[0], 1);
            int count = 1;
            for (int i = 1; i < sChar.length; i++){
                if (!map.containsKey(sChar[i])){
                    map.clear();
                    map.put(sChar[i], 1);
                }
                else {
                    map.put(sChar[i], map.get(sChar[i])+1);
                    if (map.get(sChar[i]) > count){
                        count = map.get(sChar[i]);
                    }
                }
            }
            return count;
        }
    }
}
