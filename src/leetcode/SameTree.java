package leetcode;

/**
 * Date: 2019/3/8
 * Created by LiuJian
 *
 * @author LiuJian
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 比较两个树是否是一样的树
 */
class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int mVal, TreeNode mLeft, TreeNode mRight) {
            val = mVal;
            left = mLeft;
            right = mRight;
        }
    }

    /**
     * 递归方式
     *
     * @return
     */
    private boolean isSameTree(TreeNode treeA, TreeNode treeB) {
        if (treeA == null && treeB == null) {
            return true;
        }

        if (treeA == null || treeB == null) {
            return false;
        }

        if (treeA.val == treeB.val) {
            return isSameTree(treeA.left, treeB.left) && isSameTree(treeA.right, treeB.right);
        }

        return false;

    }

    /**
     * 递推循环实现.
     * 使用BFS遍历两个树实现遍历对比
     *
     * @param treeA
     * @param treeB
     * @return
     */
    private boolean isSameTree2(TreeNode treeA, TreeNode treeB) {
        if (!check(treeA, treeB)) {
            return false;
        }


        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();

        queueA.offer(treeA);
        queueB.offer(treeB);
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            TreeNode p = queueA.poll();
            TreeNode q = queueB.poll();
            if (!check(p.left, q.left)) {
                return false;
            }

            if (p.left != null && q.left != null) {
                queueA.offer(p.left);
                queueB.offer(q.left);
            }

            if (!check(p.right, q.right)) {
                return false;
            }

            if (p.right != null && q.right != null) {
                queueA.offer(p.right);
                queueB.offer(p.right);
            }

        }
        return true;

    }

    private boolean check(TreeNode treeA, TreeNode treeB) {
        if (treeA == null && treeB == null) {
            return true;
        }

        if (treeA == null || treeB == null) {
            return false;
        }

        if (treeA.val != treeB.val) {
            return false;
        }
        return true;
    }
}
