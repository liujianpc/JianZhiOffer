/**
 * Date: 2019/1/4
 * Created by Liuian
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树深度
 */
class BinTreeDepth {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
    }

    /**
     * 递归方式获取二叉树深度
     * @param root
     * @return
     */
    private int getDepth(TreeNode root){

        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;

    }

    /**
     * 队列实现BFS
     * @param root
     * @return
     */
    private int getDepthByLoop(TreeNode root){

        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int current = 0;
        int last;
        int depth = 0;
        while(!queue.isEmpty()){
            last = queue.size();
            while (current < last){
                current++;
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            current = 0;

            depth++;

        }

        return depth;


    }


}
