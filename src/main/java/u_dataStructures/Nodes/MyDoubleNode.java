package u_dataStructures.Nodes;

public class MyDoubleNode<V> {
    private V value;
    private MyDoubleNode<V> previous;
    private MyDoubleNode<V> next;
    public MyDoubleNode(V value){
        this.value = value;
        this.previous = this.next = null;
    }

    public V getValue() {
        return value;
    }
    public MyDoubleNode<V> getNext() {
        return next;
    }
    public MyDoubleNode<V> getPrevious() {
        return previous;
    }
    public void setNext(MyDoubleNode<V> next) {
        this.next = next;
    }
    public void setPrevious(MyDoubleNode<V> previous) {
        this.previous = previous;
    }
    public void setValue(V value) {
        this.value = value;
    }
}
