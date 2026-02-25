/*98. Проверка бинарного дерева поиска
* Для заданного root бинарного дерева определите, является ли оно корректным
* бинарным деревом поиска (БДП).
* Корректное БДП определяется следующим образом:
* Левое поддерево узла содержит только узлы с ключами, строго меньшими, чем ключ узла.
* Правое поддерево узла содержит только узлы с ключами, строго большими, чем ключ узла.
* И левое, и правое поддеревья также должны быть деревьями двоичного поиска.*/

public class validateBinarySearchTree98 {
    class Solution {
        public boolean isValidBST(TreeNode root){
            return isBST(root, null, null);
        }
        private boolean isBST(TreeNode root,TreeNode min,TreeNode max){
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            return isBST(root.left, min, root) && isBST(root.right, root, max);
        }
    }
}
