/*22. Создание скобок
* Для n пар скобок напишите функцию, которая генерирует все комбинации
* правильно оформленных скобок.*/

import java.util.*;
public class generateParentheses22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> current = new ArrayList<>();
            current.add("");
            for (int step = 0; step < 2 * n; step++) {
                List<String> next = new ArrayList<>();

                for (int i = 0; i < current.size(); i++) {
                    String s = current.get(i);
                    int openCount = 0;
                    int closeCount = 0;

                    for (int j = 0; j < s.length(); j++) {
                        char c = s.charAt(j);
                        if (c == '(') {
                            openCount++;
                        } else {
                            closeCount++;
                        }
                    }

                    if (openCount < n) {
                        next.add(s + "(");
                    }

                    if (closeCount < openCount) {
                        next.add(s + ")");
                    }
                }
                current = next;
            }
            return current;
        }
    }
}
