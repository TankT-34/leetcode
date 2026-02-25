/*232. Реализация очереди с использованием стеков
* Реализуйте очередь FIFO (first in first out, «первым пришёл — первым вышел»),
* используя только два стека. Реализованная очередь должна поддерживать все функции
* обычной очереди (push, peek, pop, и empty).
* Реализовать класс MyQueue:
* void push(int x)Добавляет элемент x в конец очереди.
* int pop()Удаляет элемент из начала очереди и возвращает его.
* int peek()Возвращает элемент в начале очереди.
* boolean empty() Возвращает true, если очередь пуста, false в противном случае.
* Примечания:
* Вы должны использовать только стандартные операции со стеком, то есть допустимы
* только операции push to top, peek/pop from top, size и is empty.
* В зависимости от языка программирования стек может не поддерживаться изначально.
* Вы можете имитировать стек с помощью списка или двухсторонней очереди (деки),
* если используете только стандартные операции со стеком.*/

import java.util.*;
public class implementQueueUsingStacks232 {
    class MyQueue {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.empty())
                while (!stack1.empty())
                    stack2.push(stack1.pop());
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }
}
