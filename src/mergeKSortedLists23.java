/*23. Объединение k отсортированных списков
* Вам дан массив k связанных списков lists, каждый из которых отсортирован
*  в порядке возрастания.
* Объедините все связанные списки в один отсортированный список и верните его.*/

import java.util.*;
public class mergeKSortedLists23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> sortedList = new ArrayList<>();

            for (int i = 0; i < lists.length; i++) {
                ListNode current = lists[i];
                while (current != null) {
                    sortedList.add(current.val);
                    current = current.next;
                }
            }

            if (sortedList.isEmpty()) {
                return null;
            }

            quickSort(sortedList, 0, sortedList.size() - 1);

            ListNode head = new ListNode(sortedList.get(0));
            ListNode current = head;

            for (int i = 1; i < sortedList.size(); i++) {
                current.next = new ListNode(sortedList.get(i));
                current = current.next;
            }
            return head;
        }

        private void quickSort(List<Integer> list, int low, int high) {
            if (low < high) {
                int piv = partition(list, low, high);

                quickSort(list, low, piv - 1);
                quickSort(list, piv + 1, high);
            }
        }

        private int partition(List<Integer> list, int low, int high) {
            int pivot = list.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (list.get(j) < pivot) {
                    i++;

                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
            int temp = list.get(i + 1);
            list.set(i + 1, list.get(high));
            list.set(high, temp);

            return i + 1;
        }
    }
}
