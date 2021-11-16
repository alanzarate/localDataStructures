package u_dataStructures.DataStructures;

import u_dataStructures.Nodes.MyGenericNode;

public class MySimpleList <T> {
    private MyGenericNode<T> first, last;
    private int size;

    public MySimpleList() {
        this.size = 0;
        this.first = this.last = null;
    }
    public void add(T value){
        if(value != null){
            MyGenericNode<T> newNode = new MyGenericNode<>(value);
            if(first == null){
                first = last = newNode;
                size ++;
            }else{
                last.setNext(newNode);
                last = newNode;
                size++;
            }
        }
    }

    public void print(){
        if(first != null){
            for(MyGenericNode<T> current = first ; current!=null ; current = current.getNext()){
                System.out.print(current.getData() + " -> ");
            }
            System.out.print(" }:\n");
        }
    }

    public void remove(T deletedValue){
        if(first != null){
            
            MyGenericNode<T> aux = null;
            for(MyGenericNode<T> current = first; current != null; current = current.getNext()){
                if(current.getData().equals(deletedValue)){
                    if(aux == null){
                        first = first.getNext(); 
                    }else{
                        if(current.getNext() ==null){
                            last = aux;
                            last.setNext(null);
                        }else{
                            aux.setNext(current.getNext());
                        }

                    }
                    size--;
                    break;
                }
                aux = current;
            }
        }
    } 
    public void testingfirstAndLast(){
        if(first != null){
            for(MyGenericNode<T> current = first; current != null; current = current.getNext()){
                if(current.equals(first)){
                    System.out.println("Se encontro el primero: " + current.getData());
                }
                if(current.equals(last)){
                    System.out.println("Se encontro el ultimo: " + current.getData());
                }
            }
        }
    }
}
