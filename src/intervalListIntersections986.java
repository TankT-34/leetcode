/*986. Пересечения интервальных списков
* Вам даны два списка закрытых интервалов firstList и secondList, где
* firstList[i] = [starti, endi] и secondList[j] = [startj, endj].
* Каждый список интервалов попарно непересекающиеся и упорядочены.
* Верните пересечение этих двух списков интервалов.
* Замкнутый интервал [a, b] (с a <= b) обозначает множество действительных
* чисел x с a <= x <= b.
* Пересечение двух замкнутых интервалов — это множество действительных чисел,
* которое либо пусто, либо представляет собой замкнутый интервал. Например,
* пересечением [1, 3] и [2, 4] является [2, 3].*/

import java.util.*;
public class intervalListIntersections986 {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            List<int[]> answer =  new ArrayList<>();
            int i = 0 ;
            int j = 0 ;

            while(i < firstList.length && j < secondList.length){
                if(secondList[j][0] <= firstList[i][1] && secondList[j][1] >= firstList[i][0]){
                    int start = Math.max(firstList[i][0],secondList[j][0]);
                    int end = Math.min(firstList[i][1],secondList[j][1]);
                    answer.add(new int[] {start,end});
                }

                if(firstList[i][1] < secondList[j][1]) i++;
                else j++;
            }
            return answer.toArray(new int[answer.size()][]);
        }
    }
}
