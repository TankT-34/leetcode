/*1. Сумма двух
* Дан массив целых чисел nums и целое число target, верните индексы
* двух чисел, сумма которых равна target.
* Можно предположить, что для каждого набора входных данных существует
* ровноодно решение, и вы не можете использовать один и тот же элемент дважды.
* Вы можете возвращать ответ в любом порядке.*/

import java.util.*;
public class twoSum1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int position = 0; position < nums.length; position++) {
                int currentNumber = nums[position];
                int neededNumber = target - currentNumber;

                if (map.containsKey(neededNumber)) {
                    int firstIndex = map.get(neededNumber);
                    int secondIndex = position;

                    int[] answer = new int[2];
                    answer[0] = firstIndex;
                    answer[1] = secondIndex;

                    return answer;
                }

                map.put(currentNumber, position);
            }

            return new int[]{-1, -1};
        }
    }
}
