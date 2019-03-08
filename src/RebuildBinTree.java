/**
 * Date: 2019/1/2
 * Created by Liuian
 */

/**
 * 由先序和后序来重建二叉树
 * 先序第一个是root节点
 * 找到root节点后，去中序中找左右子树
 * 分割中序的列表后，得出左右子树的长度
 * 再去先序中递归
 */
class RebuildBinTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }

    private static TreeNode rebuildBinTree(int[] preArray, int[] midArray) {
        if (preArray == null || midArray == null) {
            return null;
        }
        if (preArray.length == 1 && midArray.length == 1) {
            return new TreeNode(preArray[0], null, null);
        }

        if (preArray.length != midArray.length) {
            throw new IllegalArgumentException("输入的参数错误");
        }


        return rebuildBinTreeCore(preArray, 0, preArray.length, midArray, 0, preArray.length);

    }

    /**
     * 第一种
     *
     * @param preArray 先序序列
     * @param preStart 先序开始index
     * @param preEnd   先序结束index
     * @param midArray 中序序列
     * @param midStart 中序开始index
     * @param midEnd   中序结束index
     * @return
     */
    private static TreeNode rebuildBinTreeCore(int[] preArray, int preStart, int preEnd,
                                               int[] midArray, int midStart, int midEnd) {
        int index = 0;
        int rootval = preArray[preStart];
        while (midArray[index] != rootval) {
            index++;
        }


        TreeNode root = new TreeNode();
        root.val = rootval;
        int leftLen = index - preStart + 1;
        int rightLen = preArray.length - 1 - index;

        if (leftLen > 0) {
            root.left = rebuildBinTreeCore(preArray, preStart + 1, preStart + leftLen,
                    midArray, midStart, midStart + leftLen - 1);

            root.right = rebuildBinTreeCore(preArray, preStart + leftLen + 1, preEnd,
                    midArray, midStart + leftLen + 1, midEnd);
        }


        return root;


    }



/*
   private static TreeNode rebuildeBinTreeCore(int[] preArray, int[] midArray){

       int index = 0;
       while (midArray[index] != preArray[0]){
           index++;
       }
       TreeNode root = new TreeNode();
       root.val = preArray[0];
       root.left = rebuildeBinTreeCore(Arrays.copyOfRange(preArray,1,index),Arrays.copyOfRange(midArray,index+1,midArray.length));
       root.right = rebuildeBinTreeCore(Arrays.copyOfRange(preArray,index+1,preArray.length),Arrays.copyOfRange(midArray,index+1,midArray.length));
       return root;
   }
*/


}
