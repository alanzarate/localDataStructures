package u_dataStructures.DataStructures;

import u_dataStructures.Interfaces.Comparable;
import u_dataStructures.Nodes.MyGenericNode;

public class MySortedSet <T extends Comparable>{
    private MyGenericNode<T> first;
    private MyGenericNode<T> last;
    private int size;

    public MySortedSet(){
        this.first = this.last = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }
    public void add(T data){
        if(data !=  null){
            if(!data.hasNullAtributtes()){
                MyGenericNode<T> newNode = new MyGenericNode<>(data);
                if(first == null){
                    first = last = newNode;
                    size++;
                }else{
                    if(last.getData().compareTo(data) < 1){
                        if(!last.getData().equals(data)){
                            last.setNext(newNode);
                            last = newNode;
                            size++;
                        }
                    }else{
                        MyGenericNode<T> previous = null;
                        for( MyGenericNode<T> current = first ; 
                        current != null;
                        current = current.getNext()){
                            if(current.getData().compareTo(data) >=1){
                                if(previous == null){
                                    if(!first.getData().equals(data)){
                                        newNode.setNext(first);
                                        first = newNode;
                                        size++;
                                    }
                                }else{
                                    if(!current.getData().equals(data)){
                                        previous.setNext(newNode);
                                        newNode.setNext(current);
                                        size++;
                                    }
                                }
                                break;
                            }
                            previous = current;
                        }
                    }
                }
            }
        }
    }
    public void print(){
        String output = "";
        for(MyGenericNode<T> current = first;
        current != null;
        current = current.getNext()){
            output += current.getData() + " -> ";
        }
        System.out.println(output + " |: ");
    }
    public void delete(T d){
        MyGenericNode<T> aux = null;
        if(d != null){
            for(MyGenericNode<T> current = first;
            current != null;
            current = current.getNext()){
                if(current.getData().equals(d)){
                    if(aux == null){
                        first = first.getNext();
                    }else{
                        aux.setNext(current.getNext());
                    }
                    size--;
                    break; 
                }
                aux = current;
            }
        }
    }
    
    public T get(int index){
        T aux = null;
        if(index<size && index >= 0){
            MyGenericNode<T> current = first;
            while(index > 0){
                current = current.getNext();
                index--;
            }
            aux = current.getData();
            return aux;
        }else{
            throw new RuntimeException("Hola te olvidaste que no puedes hacer eso tamaño = "+size );
        }
    }
    public void delete(int position){
        
        if(position >=0  && position < size){
            if(position == 0){
                first = first.getNext();
            }else{
                MyGenericNode<T> aux = first;
                while(position > 1){
                    aux = aux.getNext();
                    position--;
                }
                aux.setNext(aux.getNext().getNext());
            }
            size--;
        }
    }
    public boolean isEmpty(){
        return size <=0;
    }
}
