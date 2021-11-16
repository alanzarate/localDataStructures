package u_dataStructures.Nodes;

import u_dataStructures.Interfaces.Comparable;

public class MyTreeNode<T extends Comparable>{
    private T obj;
    private MyTreeNode<T> left;
    private MyTreeNode<T> right;

    public MyTreeNode(T object){
        this.obj = object;
        this.left = this.right = null;
    }

    public MyTreeNode(T object, MyTreeNode<T> left, MyTreeNode<T> right){
        this.obj = object;
        this.left = left;
        this.right = right;
    }

    public void setLeft(MyTreeNode<T> left) {
        this.left = left;
    }
    public void setObj(T obj) {
        this.obj = obj;
    }
    public void setRight(MyTreeNode<T> right) {
        this.right = right;
    }
    public MyTreeNode<T> getLeft() {
        return left;
    }
    public T getObj() {
        return obj;
    }
    public MyTreeNode<T> getRight() {
        return right;
    }
    


    
}
