/**
 * Date: 2019/1/2
 * Created by Liuian
 */

import java.util.Stack;

/**
 * 逆转链表
 */
class ReverseList {


    public static void main(String[] args){
        Node node5 =  new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3= new Node(3,node4);
        Node node2= new Node(2,node3);
        Node node1 = new Node(1,node2);
       //reverseList(node1);
       // reversePrint(node1);
        reversePrintByStack(node1);

    }

    /**
     * 链表的节点类
     */
    static class Node{
        int val;
        Node next;
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 头插法逆转链表
     * @param node
     * @return
     */
    private static Node reverseList(Node node){
        if (node == null){
            return null;
        }
        if(node.next ==null){
            System.out.print(node.val);
            return node;
        }

        Node p = node;
        Node q = p.next;
        Node r = null;
        while(q!= null){
            r = q.next;
            q.next = p;
            p = q;
            q= r;
        }

        node.next = null;
        node = p;

        Node t = node;
        while(t != null){
            System.out.print(t.val+" ");
            t = t.next;
        }

        return node;

    }

    /**
     * 递归法
     */
    private static void reversePrint(Node node){

        if (node == null){
            return;
        }
        if (node.next != null){
            reversePrint(node.next);
        }
        System.out.print(node.val+" ");


    }

    /**
     * 使用桟的方法实现逆序
     * @param node
     */
    private static void reversePrintByStack(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }

        while(!stack.isEmpty()){
            Node tempNode = stack.pop();
            System.out.print(tempNode.val+" ");
        }
    }




}
