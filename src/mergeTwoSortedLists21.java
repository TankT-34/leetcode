/*21. Объединение двух отсортированных списков
* Вам даны головы двух отсортированных связанных списков list1 и list2.
* Объедините два списка в один отсортированный список. Список должен
* состоять из объединенных узлов первых двух списков.
* Верните голову объединенного связанного списка.*/

public class mergeTwoSortedLists21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            if (list1 != null) curr.next = list1;
            else curr.next = list2;
            return dummy.next;
        }
    }
}
