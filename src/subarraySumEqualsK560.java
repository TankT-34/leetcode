/*560. Сумма элементов подмассива равна K
* Учитывая массив целых чисел nums и целое число k, верните общее количество
* подмассивов, сумма которых равна k.
*Подмассив - это непрерывная непустая последовательность элементов в массиве.*/

import java.util.*;
public class subarraySumEqualsK560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int currentSum = 0;
            HashMap<Integer, Integer> sumMap = new HashMap<>();
            sumMap.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
                int target = currentSum - k;

                if (sumMap.containsKey(target)) {
                    count += sumMap.get(target);
                }
                sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
            }

            return count;
        }
    }
}
