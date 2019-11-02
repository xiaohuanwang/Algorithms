package stack;

/**
 * @program: algorithms
 * @description: 基于数组实现的顺序栈
 * @author: 王小欢
 * @create: 2019-10-23 16:56
 **/
public class ArrayStack {
    private String[] items;    //数组
    private int count;       //栈中元素的个数
    private int n;          //栈的大小


    //初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n){
        this.items=new String[n];
        this.n=n;
        this.count=0;
    }


    //入栈操作
    public boolean push(String item){
        //数组空间满了，入栈失败
        if(count==n){
            return  false;
        }
        //将item放到下标为count的位置，并且count加一
        items[count]=item;
        count=count+1;
        return true;
    }

    //出栈操作
    public String pop(){
        //数组里面无数据，栈为空，则直接返回null
        if(count==0){
            return  null;
        }
        //返回下标为count-1的数组元素，并且栈中元素个数count减一
        String tem=items[count-1];
        count=count-1;
        return  tem;
    }
}
