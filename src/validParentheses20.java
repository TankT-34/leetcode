/*20. Правильные скобки
* Дано слово s, содержащее только символы '(', ')', '{', '}', '[' и ']',
* определите, является ли оно корректным.
* Слово является корректным, если:
* 1. Открытые скобки должны быть закрыты скобками того же типа.
* 2. Открытые скобки должны быть закрыты в правильном порядке.
* 3. Каждой закрывающей скобке соответствует открывающая скобка того же типа.*/

import java.util.*;
public class validParentheses20 {
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char currentChar = chars[i];

                if (map.containsValue(currentChar)) {
                    deque.push(currentChar);
                } else if (map.containsKey(currentChar)) {
                    if (deque.isEmpty() || map.get(currentChar) != deque.pop()) {
                        return false;
                    }
                }
            }
            return deque.isEmpty();
        }
    }
}
