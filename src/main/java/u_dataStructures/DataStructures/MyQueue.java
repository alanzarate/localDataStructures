package u_dataStructures.DataStructures;

import u_dataStructures.Interfaces.Comparable;
import u_dataStructures.Nodes.MyGenericNode;

public class MyQueue <T extends Comparable>{
    private MyGenericNode<T> front;
    private MyGenericNode<T> back;
    private int size;

    public MyQueue(){
        this.front = this.back = null;
        size =0;
    }
    public int size(){
        return size;
    }
    public void add(T dataIn){
        if(dataIn != null){
            if(!dataIn.hasNullAtributtes()){
                if(!isInLine(dataIn)){
                    MyGenericNode<T> newNode = new MyGenericNode<>(dataIn);
                    if(front == null){
                        front = back = newNode;
                    }else{
                        back.setNext(newNode);
                        back = newNode;
                    }
                    size++;
                }
            }
        }
    }

    public boolean isInLine(T dataIn){
        boolean result = false;
        if(size>0){
            for(MyGenericNode<T> current = front;
                current != null;
                current = current.getNext()){
                    if(current.getData().equals(dataIn)){
                        result = true;
                        break;
                    }
                }
        }
        return result;
    }
    public T getOut(){
        T returned = null;
        if(front !=null){
            returned = front.getData();
            front = front.getNext();
            size--; 
        }
        return returned;
    }
    public void print(){
        String infoOut = "";
        if(size>0){
            for(MyGenericNode<T> current = front;
                current != null;
                current = current.getNext()){
                    infoOut += current.getData() + " -> ";
                }
        }
        System.out.println(infoOut + " ]: ");
    }
    public T peekFront(){
        if(front != null){
            return front.getData();
        }else{
            return null;
        }
    }
    public boolean isEmpty(){
        return size<=0;
    }
}
