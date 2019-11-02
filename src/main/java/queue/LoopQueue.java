package queue;

/**
 * @program: algorithms
 * @description: 循环队列
 * @author: 王小欢
 * @create: 2019-10-31 11:46
 **/
public class LoopQueue {

    private String[] items;    //定义数组items
    private int n;          //数组大小为n
    private int head=0;      //队列头下标
    private int tail=0;      //队列尾下标

    public LoopQueue(int arraySize){
        items=new String[arraySize];
        n=arraySize;
    }


    public boolean enqueue(String item){
        //如果(tail + 1) % n == head 表示队列已满
        if((tail + 1) % n == head){
            System.out.print("队列以满");
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    public String duqueue(){
        //如果队头下标head==tail,表示队列为空
        if(head==tail){
            System.out.print("队列为空");
            return null;
        }
        String ret=items[head];
        head = (head + 1) % n;
        return ret;
    }


    public static void main(String[] args) {
        LoopQueue loopQueue=new LoopQueue(3);
        //入队
        loopQueue.enqueue("a");
        loopQueue.enqueue("b");
        loopQueue.enqueue("c");
        //出队
        loopQueue.duqueue();
        loopQueue.duqueue();
        loopQueue.duqueue();
        //入队
        loopQueue.enqueue("d");

        //出队
        loopQueue.duqueue();
        loopQueue.duqueue();
        //入队
        loopQueue.enqueue("e");
        loopQueue.enqueue("f");
        loopQueue.enqueue("g");
    }
}
