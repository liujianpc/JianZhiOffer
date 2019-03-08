/**
 * Date: 2019/1/4
 * Created by Liuian
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉樹的遍歷
 * 1、前序遍歷
 * 2、中序遍歷
 * 3、后序遍历
 * 4、bfs深度优先遍历
 * 5、DFS广度优先遍历
 */
class TraversalBinTree {

    class TreeNode<T> {
        T val;
        TreeNode left;
        TreeNode right;

    }

    /**
     * 递归方式先序遍历
     *
     * @param root
     */
    private void preTravel(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val);
        preTravel(root.left);
        preTravel(root.right);
    }

    /**
     * 循环方式先序遍历,擴展性不好，但是簡單這也是DFS
     *
     * @param root
     */
    private void preTravelLoop(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val);

            if (top.right != null) {
                stack.push(top.right);
            }

            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    /**
     * 拓展性好的循環實現先序遍歷，先把左子樹壓入棧
     *
     * @param root
     */
    private void preTravelsalLoop2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                System.out.print(root.val);
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                stack.push(root.right);
            }
        }
    }


    /**
     * 递归实现中序遍历
     *
     * @param root
     */
    private void midTravelsal(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            midTravelsal(root.left);
        }

        System.out.print(root.val);

        if (root.right != null) {
            midTravelsal(root.right);
        }
    }

    /**
     * 循环实现中序遍历,先把左子樹壓入棧
     */

    private void midTravelByLoop(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.print(root.val);
            root = root.right;


        }
    }


    /**
     * 遞歸實現後續遍歷
     */

    private void postOrderTravelsal(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrderTravelsal(root.left);
        }

        if (root.right != null) {
            postOrderTravelsal(root.right);
        }

        System.out.print(root.val);
    }


    /**
     * 非遞歸實現後序遍歷,與先序對稱，使用兩個桟即可實現
     */

    private void postOrderTravelsalLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }

            if (root.right != null) {
                stack1.push(root.right);
            }


        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val);
        }
    }


    /**
     * BFS 队列实现
     */

    private void bfsTravelsal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    /**
     * DFS  桟實現  先序、中序、后序
     */

    private void dfsTravelsal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val);
            if (current.right != null)
                stack.push(current.right);

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }


    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int last = queue.size();
            int index = 0;
            while (index < last) {
                TreeNode current = queue.poll();
                if (current != null) {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                index++;

            }
            depth++;

        }
        return depth;
    }

}
