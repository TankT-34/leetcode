/*2. Сложение двух чисел
* Вам даны два непустых связанных списка, представляющих два неотрицательных
* целых числа. Цифры в них расположены в обратном порядке, и каждый узел содержит
* одну цифру. Сложите два числа и верните сумму в виде связанного списка.
* Можно предположить, что в этих двух числах нет ведущих нулей, кроме самого числа 0.*/

public class addTwoNumbers2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode tail = null;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int digit1;
                if (l1 != null) digit1 = l1.val;
                else digit1 = 0;

                int digit2;
                if (l2 != null) digit2 = l2.val;
                else digit2 = 0;

                int sum = digit1 + digit2 + carry;
                int digit = sum % 10;
                carry = sum / 10;

                ListNode newNode = new ListNode(digit);

                if (result == null) {
                    result = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }

                if (l1 != null) l1 = l1.next;
                else l1 = null;

                if (l2 != null) l2 = l2.next;
                else l2 = null;
            }
            return result;
        }
    }
}
