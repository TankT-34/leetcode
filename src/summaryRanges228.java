/*228. Сводные диапазоны
* Вам дан упорядоченный по возрастанию целочисленный массив nums.
* Диапазон [a,b] — это множество всех целых чисел от a до b (включительно).
* Верните самый маленький отсортированный список диапазонов, которые полностью
* покрывают все числа в массиве. То есть каждый элемент nums покрывается ровно одним диапазоном,
* и не существует целого числа x, такого что x входит в один из диапазонов,
* но не входит в nums.
( Каждый диапазон [a,b] в списке должен быть выведен следующим образом:
* "a->b" если a != b
* "a" если a == b*/

import java.util.*;
public class summaryRanges228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<String>();
            int left = 0;
            int right = 0;
            if (nums.length == 0){
                return result;
            }
            for(int i = 1; i < nums.length; i++){
                if (nums[i] != nums[i-1] + 1){
                    if (left == i-1){
                        result.add(nums[left]+"");
                    } else result.add(nums[left] + "->" + nums[i-1]);
                    left = i;
                }
            }
            if (left == nums.length - 1){
                result.add(nums[left]+"");
            } else result.add(nums[left] + "->" + nums[nums.length - 1]);
            return result;
        }
    }
}
