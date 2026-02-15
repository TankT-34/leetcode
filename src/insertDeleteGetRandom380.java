/*380. Вставка, удаление, получение случайного числа O(1)
* Реализовать класс RandomizedSet:

* RandomizedSet() Инициализирует RandomizedSet объект.
* bool insert(int val) Вставляет элемент val в набор, если он отсутствует.
* Возвращает, true если элемент отсутствовал, false в противном случае.
* bool remove(int val) Удаляет элемент val из набора, если он присутствует.
* Возвращает, true если элемент присутствовал, false в противном случае.
* int getRandom() Возвращает случайный элемент из текущего набора элементов
* (гарантируется, что при вызове этого метода существует хотя бы один элемент).
* Каждый элемент должен иметь одинаковую вероятность возврата.
* Вы должны реализовать функции класса таким образом, чтобы каждая из них работала
* за среднее O(1) время.*/

import java.util.*;
public class insertDeleteGetRandom380 {
    class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);

            list.set(index, lastElement);
            map.put(lastElement, index);

            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
