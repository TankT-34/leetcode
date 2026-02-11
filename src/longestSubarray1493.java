/*1493. Самый длинный подмассив из единиц после удаления одного элемента
* Дан бинарный массив nums. Вам нужно удалить из него один элемент.
* Верните размер самого длинного непустого подмассива, содержащего
* только 1's в результирующем массиве. Верните 0, если такого подмассива нет.*/

public class longestSubarray1493 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int[] countLeft = new int[nums.length];
            int[] countRight = new int[nums.length];
            int sum = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                countLeft[i] = sum;
                if (nums[i] == 1){
                    sum += 1;
                } else sum = 0;
            }

            sum = 0;

            for (int i = nums.length - 1; i >= 0; i--){
                countRight[i] = sum;
                if (nums[i] == 1){
                    sum += 1;
                } else sum = 0;
            }

            for (int i = 0; i < nums.length; i++){
                if (countLeft[i] + countRight[i] > result){
                    result = countLeft[i] +countRight[i];
                }
            }
            return result;
        }
    }
}
