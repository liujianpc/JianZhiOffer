/**
 * Date: 2019/1/2
 * Created by Liuian
 */

import java.util.Stack;

/**
 * 使用兩個桟實現一個隊列
 * 桟是先进后出，队列是先进先出
 */
class StackBuildQueue<T> {

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    //enqueue\dequeue\add\remove

    private void enqueue(T t){
       stack1.push(t);
    }

    private void dequeue(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()){
            throw new IllegalArgumentException("null stack");
        }
        stack2.pop();
    }

}
