/*283. Перемещение нулей
* Дан целочисленный массив nums. Переместите все 0 в конец массива,
* сохранив относительный порядок ненулевых элементов.
* Обратите внимание, что это нужно сделать на месте, без создания копии массива.*/

public class moveZeroes283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            int indexNumber = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != 0){
                    nums[indexNumber] = nums[i];
                    indexNumber++;
                }
            }
            for (int i = indexNumber; i < length; i++){
                nums[i] = 0;
            }
        }
    }
}
