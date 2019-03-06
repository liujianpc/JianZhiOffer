/**
 * Date: 2019/1/21
 * Created by Liuian
 */

/**
 * 倒数第k个节点
 * pre指针和behind指针
 * 1、pre指针先走k-1步
 */
class LastKNode {

    class Node {
        Node next;
        int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public Node getLastKNode(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }

        if (count < k) {
            return null;
        }


        Node pre = head;
        Node behind = head;
        int i = 0;
        while (i < k - 1) {
            pre = pre.next;
            i++;
        }
        while (pre.next != null) {
            pre = pre.next;
            behind = behind.next;
        }

        return behind;
    }
}
