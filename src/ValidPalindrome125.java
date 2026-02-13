/*125. Правильный палиндром
* Фраза является палиндромом, если после замены всех прописных букв
* на строчные и удаления всех небуквенно-цифровых символов она читается
* одинаково как слева направо, так и справа налево. К буквенно-цифровым
* символам относятся буквы и цифры.
* Для заданной строки s верните true, если она является палиндромом,
* или false иначе.*/

public class ValidPalindrome125 {
    class Solution {
        public boolean isPalindrome(String s) {
            String str = s.toLowerCase();
            str = str.replaceAll("[^a-z0-9]", "");
            int l = 0;
            int r = str.length() - 1;
            while (l < r){
                if (str.charAt(l) == str.charAt(r)){
                    l++;
                    r--;
                }
                else return false;
            }
            return true;
        }
    }

}
