/**
 * Date: 2019/1/20
 * Created by Liuian
 */

/**
 * 1、合并有序数组
 * 2、合并有序的链表
 */
class MergeList {

    /**
     * 合并两个有序序列
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    private static int[] mergeArray(int[] leftArray, int[] rightArray) {

        int[] newArray = new int[leftArray.length + rightArray.length];

        for (int i = 0, index = 0, j = 0; index < newArray.length; index++) {

            if (i > leftArray.length - 1) {
                newArray[index] = rightArray[j++];

            } else if (j > rightArray.length - 1) {
                newArray[index] = leftArray[i++];

            } else if (leftArray[i] > rightArray[j]) {
                newArray[index] = rightArray[j++];
            } else {
                newArray[index] = leftArray[i++];
            }

        }
        return newArray;
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        if (b == null || a.length == 0) {
            return a;
        }

        int i = 0;
        int j = 0;
        int len_a = a.length;
        int len_b = b.length;
        int k = 0;
        int[] c = new int[len_a + len_b];
        while (i <= len_a - 1 && j < len_b - 1 && k <= len_a + len_b - 1) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < len_a - 1) {
            c[++k] = a[i];
            i++;
        }
        while (j < len_b - 1) {
            c[++k] = b[j];
            j++;
        }

        return c;
    }


    class LinkNode {
        LinkNode next;
        int val;

        public LinkNode(LinkNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    /**
     * 1、递归方式合并链表
     *
     * @return
     */
    public LinkNode mergeByRecursive(LinkNode aNode, LinkNode bNode) {
        if (aNode == null) return bNode;
        if (bNode == null) return aNode;

        LinkNode head = null;

        if (aNode.val >= bNode.val) {
            head = bNode;
            mergeByRecursive(aNode, bNode.next);

        } else {
            head = aNode;
            mergeByRecursive(aNode.next, bNode);
        }

        return head;
    }

    /**
     * 循环方式实现合并有序的链表
     */

    public LinkNode mergeByLoop(LinkNode aNode, LinkNode bNode) {
        if (aNode == null) return bNode;
        if (bNode == null) {
            return aNode;
        }

        LinkNode head = new LinkNode(null, 0);
        LinkNode p = head;

        while (aNode != null && bNode != null) {
            if (aNode.val < bNode.val) {
                p.next = aNode;
                aNode = aNode.next;
            } else {
                p.next = bNode;
                bNode = bNode.next;
            }

            p = p.next;
        }

        if (aNode != null) {
            p.next = aNode;
        }

        if (bNode != null) {
            p.next = bNode;
        }

        return head.next;
    }


}
