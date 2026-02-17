/*146. Кэш LRU
* Разработайте структуру данных, соответствующую ограничениям кэша
*  с вытеснением по давности использования (Least Recently Used, LRU).
* Реализуйте LRUCache класс:
*LRUCache(int capacity) Инициализируйте кэш LRU с положительным размером capacity.
* int get(int key) Верните значение key, если ключ существует, в противном случае верните -1.
* void put(int key, int value) Обновите значение key, если key оно существует.
* В противном случае добавьте key-value пару в кэш. Если количество ключей превышает
* capacity из этой операции, удалите наименее недавно использованный ключ.
* Функции get и put должны выполняться со средней временной сложностью O(1)*/

import java.util.*;
public class lRUCache146 {
    class LRUCache {
        Node head = new Node(1, 1);
        Node tail = head;
        int cap;
        HashMap<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node resNode = map.get(key);
                int ans = resNode.val;

                map.remove(key);
                deleteNode(resNode);
                addNode(resNode);

                map.put(key, head.next);
                return ans;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node curr = map.get(key);
                map.remove(key);
                deleteNode(curr);
            }

            if (map.size() == cap) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }

            addNode(new Node(key, value));
            map.put(key, head.next);
        }

        private void addNode(Node newnode) {
            Node temp = head.next;

            newnode.next = temp;
            newnode.prev = head;

            head.next = newnode;
            temp.prev = newnode;
        }

        private void deleteNode(Node delnode) {
            Node prevv = delnode.prev;
            Node nextt = delnode.next;

            prevv.next = nextt;
            nextt.prev = prevv;
        }

        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
