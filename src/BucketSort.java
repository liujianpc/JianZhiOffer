/**
 * Date: 2019/4/7
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 桶排序：
 * 1、先确定桶数目
 * 2、将元素按大小放进对应的桶
 * 3、桶里的元素在按插入排序进行排序
 * 4、这是分而治之的思想
 */
class BucketSort {

    //桶数目
    private static final int BUCKET_SIZE = 5;
    //每个桶的间隔大小
    private static final int INTERVAL = 10;

    static  class Node{
        int val;
        Node next;

        public Node(int mVal, Node mNext) {
            val = mVal;
            next = mNext;
        }
    }


    void bucketSort(int[] array){

        Node[] buckets = new Node[BUCKET_SIZE];

        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = null;

        }

        /**
         * 将元素放进桶，每个桶都是一个链表，最新放进的元素都位于表头
         */
        for (int i = 0; i < array.length; i++) {
            int position = getPosition(array[i]);
            Node current = new Node(array[i],buckets[position]);
            buckets[position] = current;
        }

        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = insertSort(buckets[i]);
        }


/**
 * 排序后重新放回array
 */
        for (int i = 0, j = 0; i < BUCKET_SIZE; i++) {
            Node node = buckets[i];
            while (node != null){
                array[j++] = node.val;
                node = node.next;
            }
        }


    }

    /**
     * 链表插入排序
     * @param node
     * @return
     */
    private Node insertSort(Node node) {



        return null;
    }

    /**
     * 拿到每个元素应该放进哪个桶
     * @param element
     * @return
     */
    private int getPosition(int element) {
        return element/INTERVAL;
    }
}
