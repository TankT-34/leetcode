/*56. Объединение интервалов
* Дан массив intervals где intervals[i] = [starti, endi],
* объедините все перекрывающиеся интервалы и верните массив непересекающихся
* интервалов, охватывающих все интервалы из входных данных.*/

import java.util.*;
public class mergeIntervals56 {
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                int[] last = result.getLast();
                int[] current = intervals[i];

                if (last[1] >= current[0]) {
                    last[1] = Math.max(last[1], current[1]);
                } else {
                    result.add(current);
                }
            }
            return result.toArray(new int[0][]);
        }
    }
}
