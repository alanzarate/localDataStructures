package u_dataStructures.DataStructures;

import u_dataStructures.Nodes.MyDoubleNode;

public class MyDoubleList<V> {
    private MyDoubleNode<V> first;
    private MyDoubleNode<V> last;
    private int size;
    public MyDoubleList(){
        this.first = this.last = null;
        this.size =0;
    }
    public void add(V value){
        if(value != null){
            MyDoubleNode<V> newNode = new MyDoubleNode<>(value);
            if(first == null){
                first = last = newNode;
                size++;
            }else{
                last.setNext(newNode);
                newNode.setPrevious(last);
                last= newNode;
                size++;
            }
        }
    }

    public void printForward(){
        String output = "";
        if(first != null){
            for(MyDoubleNode<V> current = first; current != null; current = current.getNext()){
                output += current.getValue() + " -> ";
            }
        }
        System.out.println(output + "  ]:");
    }
    public void printBackward(){
        String output ="";
        if(last != null){
            for(MyDoubleNode<V> current = last; current!= null; current = current.getPrevious()){
                output += current.getValue() + " -> ";
            }
        }
        System.out.println(output + " ]:");
    }
    public void removeForward(int position){
        if(position >=0 && position <size){
            
            while(position>0){

            }
        }
    }
}
