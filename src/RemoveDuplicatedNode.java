/**
 * Date: 2019/1/21
 * Created by Liuian
 */

/**
 * 去除重复的Node
 */
class RemoveDuplicatedNode {

    class Node {
        Node next;
        int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }


    /**
     * 遍历重复的，然后删去
     *
     * @param head
     * @return
     */
    public Node removeDuplicatedNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pHead = new Node(null, Integer.MIN_VALUE);
        pHead.next = head;
        Node last = pHead;
        Node curr = head;


        //去除多个重复的
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int value = curr.val;
                while (curr != null && curr.val == value) {
                    curr = curr.next;
                }

            } else {
                last = curr;
                curr = curr.next;
            }

            last.next = curr;
        }

        return last.next;
    }

}
