/*849. Максимально увеличить расстояние до ближайшего человека
* Вам дан массив, представляющий собой строку из seats, где
* seats[i] = 1 обозначает человека, сидящего на ith-м месте, а
* seats[i] = 0 обозначает, что ith-е место свободно (нумерация начинается с 0).
* Есть как минимум одно свободное место и как минимум один человек, который уже сидит.
* Алекс хочет сесть так, чтобы расстояние между ним и ближайшим к нему человеком
* было максимальным.
* Верните максимальное расстояние до ближайшего человека*/

import java.util.*;
public class maximizeDistanceToClosestPerson849 {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int n = seats.length;
            int maxDist = 0;
            int lastPerson = -1;

            for (int i = 0; i < n; i++) {
                if (seats[i] == 1) {
                    if (lastPerson == -1) {
                        maxDist = i;
                    } else maxDist = Math.max(maxDist, (i - lastPerson) / 2);
                    lastPerson = i;
                }
            }
            maxDist = Math.max(maxDist, n - 1 - lastPerson);
            return maxDist;
        }
    }
}
