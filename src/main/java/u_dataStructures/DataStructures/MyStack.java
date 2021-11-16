package u_dataStructures.DataStructures;

import u_dataStructures.Nodes.MyGenericNode;

public class MyStack<T> {
    private MyGenericNode<T> first;
    private int size;
    public MyStack(){
        this.first = null;
        this.size =0;
    }
    
    public void push(T data){
        if(data != null){
            MyGenericNode<T> newNode = new MyGenericNode<>(data);
            if(first == null){
                first = newNode;
                size++;
            }else{
                newNode.setNext(first);
                first = newNode;
                size++;
            }
        }
    }
    public T pop(){
        T returned = null;
        if(first != null){
            returned = first.getData();
            first = first.getNext();
            size--;
        }
        return returned;
    } 
    public int size(){
        return size;
    }

}
