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


    public ArrayStack(int n){
        this.items=new String[n];
        this.n=n;
        this.count=0;
    }


    //入栈操作
    public boolean push(String item){
        if(count==n){
            return  false;
        }
        items[count]=item;
        count=count+1;
        return true;
    }

    //出栈操作
    public String pop(){
        if(count==0){
            return  null;
        }
        String tem=items[count-1];
        count=count-1;
        return  tem;
    }
}
