package u_dataStructures.DataStructures;

import u_dataStructures.Interfaces.Comparable;
import u_dataStructures.Nodes.MyMapNode;

public class MyHashMap <K,V extends Comparable> {
    private MyMapNode<K,V> first;
    private MyMapNode<K,V> last;
    private int size;

    public MyHashMap(){
        this.size = 0;
        this.first =this.last =  null;
    }
    public void print(){
        if(first != null){
            System.out.println("Key\t\tValue\n==========================");
            for(MyMapNode<K,V> current = first; current != null; current = current.getNext() ){
                System.out.println("Key:  "+current.getKey() +"\t\tValue: "+ current.getValue() + "");
            }
            System.out.println("==========================================");
        }else{
            System.out.println("No hay nada");
        }
    }
    public int size(){
        return size;
    }
    public void Anotherput(K key, V value){
        MyMapNode<K,V> newNode = new MyMapNode<>(key, value);
        if(first == null){
            first = newNode;
            size++;
        }else{

            for(MyMapNode<K,V> current = first; current != null; current = current.getNext()){
                if(current.getKey().equals(key)){
                    current.setValue(value);
                    break;
                }else{
                    if(current.getNext() == null){
                        current.setNext(newNode);
                        size++;
                        break;
                    }
                }
            }
        }
    }

    public void put(K key, V value){
        if(key != null && value != null ){
            if(!value.hasNullAtributtes()){
                MyMapNode<K,V> newNode = new MyMapNode<>(key, value);
                if(first == null){
                    first = last = newNode;
                    size++;
                }else{
                    MyMapNode<K,V> node = nodeByKey(key);
                    if(node != null){
                        node.setValue(value);
                    }else{
                        last.setNext(newNode);
                        last = newNode;
                        size++;
                    }
                }
            }  
        }
    }
    public V get(K key){
        MyMapNode<K,V> value = nodeByKey(key);
        if(value != null){
            return value.getValue();
        }
        return null;
    }
    public V anotherget(K key){
        if(first != null){
            V returned  =  null;
            MyMapNode<K,V> current = first;
            while(current != null){
                if(current.getKey().equals(key)){
                    returned = current.getValue();
                    break;
                }
                current = current.getNext();
            }

            if(returned == null){
                throw new RuntimeException("LO sentimos, no se pudo encontrar la llave");
            }else{
                return returned;
            }
        }else{
            throw new RuntimeException("Esta vacio");
        }
    }
    public void clear(){
        size = 0;
        first = null;
    }
    public void removeByKey(K key){
        MyMapNode<K,V> aux = null;
        for(MyMapNode<K,V> current = first; current!= null; current = current.getNext()){
            if(current.getKey().equals(key)){
                if(aux == null){
                    first = first.getNext();
                    size--;
                }else{
                    aux.setNext(current.getNext());
                    size--;
                }
            }
            aux = current;
        }
    }
    public MyMapNode<K,V> nodeByKey(K key){
        MyMapNode<K,V> returnNode = null;
        if(first != null){
            for(MyMapNode<K,V> current = first ; current!=null; current = current.getNext()){
                if(current.getKey().equals(key)){
                    returnNode = current;
                    break;
                }
            }
        }
        return returnNode;
    }
}
