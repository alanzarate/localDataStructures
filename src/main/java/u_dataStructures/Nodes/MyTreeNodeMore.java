package u_dataStructures.Nodes;

public class MyTreeNodeMore <T extends Comparable<T>>{
    private T obj;
    private MyTreeNodeMore<T> left;
    private MyTreeNodeMore<T> right;

    public MyTreeNodeMore(T object){
        this.obj = object;
        this.left = this.right = null;
    }

    public MyTreeNodeMore(T object, MyTreeNodeMore<T> left, MyTreeNodeMore<T> right){
        this.obj = object;
        this.left = left;
        this.right = right;
    }

    public void setLeft(MyTreeNodeMore<T> left) {
        this.left = left;
    }
    public void setObj(T obj) {
        this.obj = obj;
    }
    public void setRight(MyTreeNodeMore<T> right) {
        this.right = right;
    }
    public MyTreeNodeMore<T> getLeft() {
        return left;
    }
    public T getObj() {
        return obj;
    }
    public MyTreeNodeMore<T> getRight() {
        return right;
    }
}
