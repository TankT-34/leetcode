/*101. Симметричное дерево
* Для заданного root бинарного дерева проверьте, является
* ли оно зеркальным отражением самого себя (то есть симметричным относительно центра).*/

import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class symmetricTree101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root.left);
            queue.offer(root.right);

            while (!queue.isEmpty()) {
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();

                if (leftNode == null && rightNode == null) {
                    continue;
                }

                if (leftNode == null || rightNode == null) {
                    return false;
                }

                if (leftNode.val != rightNode.val) {
                    return false;
                }

                queue.offer(leftNode.left);
                queue.offer(rightNode.right);

                queue.offer(leftNode.right);
                queue.offer(rightNode.left);
            }
            return true;
        }
    }
}
