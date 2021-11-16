package u_dataStructures.Nodes;

public class MyGenericNode <D> {
    private D data;
    private MyGenericNode<D> next;

    public MyGenericNode(D data){
        this.next = null;
        this.data = data;
    }
    public D getData() {
        return data;
    }
    public void setData(D data) {
        this.data = data;
    }
    public MyGenericNode<D> getNext() {
        return next;
    }
    public void setNext(MyGenericNode<D> next) {
        this.next = next;
    }
}
