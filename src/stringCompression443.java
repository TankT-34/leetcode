/*443. Сжатие строк
* Дан массив символов chars, сжать его с помощью следующего алгоритма:
* Начните с пустой строки s. Для каждой группы последовательно повторяющихся
* символов в chars:
* Если длина группы равна 1, добавьте символ в s.
* В противном случае добавьте символ, а затем укажите длину группы.
* Сжатая строка s не должна возвращаться отдельно, вместо этого она должна
* сохраняться в массиве входных символов chars. Обратите внимание, что группы
* длиной 10 и более будут разделены на несколько символов в chars.
* После того как вы закончите изменять входной массив, верните новую длину массива.
* Вы должны написать алгоритм, использующий только постоянное дополнительное
* пространство.
* Примечание: символы в массиве, выходящие за пределы возвращаемой длины, не имеют
* значения и могут быть проигнорированы.*/

public class stringCompression443 {
    class Solution {
        public int compress(char[] chars) {
            int index = 0;
            char current = chars[0];
            int count = 1;
            for(int i = 1; i < chars.length; i++){
                if (chars[i] != current){
                    chars[index++] = current;
                    if (count > 1){
                        String countString = String.valueOf(count);
                        for (int j = 0; j < countString.length(); j++){
                            chars[index++] = countString.charAt(j);
                        }
                    }
                    count = 1;
                    current = chars[i];
                } else count++;
            }
            chars[index++] = current;
            if (count > 1){
                String countString = String.valueOf(count);
                for (int j = 0; j < countString.length(); j++){
                    chars[index++] = countString.charAt(j);
                }
            }
            return index;
        }
    }
}
