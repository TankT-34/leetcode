/*42. Сбор дождевой воды
* Даны n неотрицательных целых чисел, представляющих карту высот,
* где ширина каждой полосы равна 1, вычислите, сколько воды может задержаться
* на ней после дождя.*/

import java.util.*;
public class trappingRainWater42 {
    class Solution {
        public int trap(int[] height) {
            int maxHeightIndex = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > height[maxHeightIndex]) {
                    maxHeightIndex = i;
                }
            }

            int answer = 0;
            int currentHeight = 0;

            for (int i = 0; i < maxHeightIndex; i++) {
                if (height[i] > currentHeight) {
                    currentHeight = height[i];
                }
                answer += currentHeight - height[i];
            }

            currentHeight = 0;

            for (int i = height.length - 1; i > maxHeightIndex; i--) {
                if (height[i] > currentHeight) {
                    currentHeight = height[i];
                }
                answer += currentHeight - height[i];
            }
            return answer;
        }
    }
}
