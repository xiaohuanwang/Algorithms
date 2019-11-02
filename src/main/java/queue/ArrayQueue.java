package queue;

/**
 * @program: algorithms
 * @description: 数组实现的顺序队列
 * @author: 王小欢
 * @create: 2019-10-31 14:41
 **/
public class ArrayQueue {
    private String[] items;    //定义数组items
    private int n;          //数组大小为n
    private int head=0;      //队列头下标
    private int tail=0;      //队列尾下标

    public ArrayQueue(int arraySize){
        items=new String[arraySize];
        n=arraySize;
    }


    public boolean enqueue(String item){
        //如果队尾下标tail==n 表示队列已满
        if(tail==n){
            System.out.print("队列以满");
            return false;
        }
        items[tail]=item;
        ++tail;
        return true;
    }


    public String duqueue(){
        //如果队头下标head==tail,表示队列为空
        if(head==tail){
            System.out.print("队列为空");
            return null;
        }
        String ret=items[head];
        ++head;
        return ret;
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(10);
        //入队
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");
        //出队
        arrayQueue.duqueue();
        //入队
        arrayQueue.enqueue("e");
        arrayQueue.enqueue("f");
        //出队
        arrayQueue.duqueue();
        //入队
        arrayQueue.enqueue("g");

    }
}
