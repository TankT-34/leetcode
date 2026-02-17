/*206. Обратный список
* Дан head односвязный список. Необходимо перевернуть его и вернуть
* перевернутый список.*/

import java.util.*;
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class reverseLinkedList206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode previous = null;
            ListNode current = head;

            while (current != null) {
                ListNode nextTemp = current.next;
                current.next = previous;
                previous = current;
                current = nextTemp;
            }
            return previous;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode reversed = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return reversed;
        }
    }
}
