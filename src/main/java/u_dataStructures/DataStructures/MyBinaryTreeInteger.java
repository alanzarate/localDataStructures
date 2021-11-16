package u_dataStructures.DataStructures;

import u_dataStructures.Interfaces.Comparable;
import u_dataStructures.Nodes.MyMapNode;
import u_dataStructures.Nodes.MyTreeNode;

public class MyBinaryTreeInteger<T extends Comparable> {
    private MyTreeNode<T> root;
    public MyBinaryTreeInteger(){
        this.root = null;
    }

    public void add(T value){
        
            if(root == null){
                    root = new MyTreeNode<T>(value);
            }else{
                
                addingNode(value, root);
            }
        
    }



    public void addingNode(T value, MyTreeNode<T> upper){
        //if(value != father.getObj()){
            if(value.compareTo(upper.getObj()) >=0){
                if(upper.getRight() == null){
                    upper.setRight(new MyTreeNode<>(value));
                }else{
                    addingNode(value, upper.getRight());
                }
            }else{
                if(upper.getLeft() == null){
                    upper.setLeft(new MyTreeNode<>(value));
                }else{
                    addingNode(value, upper.getLeft());
                }
            }
        //}
        
    }

    public boolean contains(T  valueSearch){
        return contains(root, valueSearch);
    }
    private boolean contains(MyTreeNode<T> father, T  value){
        if(father == null){
            return false;
        }
        if(father.getObj().equals(value)){
            return true;
        }else{
           if(father.getObj().compareTo(value) >= 0) {
               return contains(father.getLeft(), value);
           }else{
               return contains(father.getRight(), value);
           }
        }
    }


    public void preorder(){
        this.preorder(root);
    }
    private void preorder(MyTreeNode<T> father){
        if(father != null){
            System.out.print(father.getObj()+" ");
            preorder(father.getLeft());
            preorder(father.getRight());
        }
    }

    public void postorder(){
        this.postorder(root);
    }
    private void postorder(MyTreeNode<T> father){
        if(father!= null){
            postorder(father.getLeft());
            postorder(father.getRight());
            System.out.print(father.getObj()+" ");
        }
    }

    public void inorder(){
        this.inorder(root);
    }

    private void inorder(MyTreeNode<T> father){
        if(father != null){
            inorder(father.getLeft());
            System.out.print(father.getObj()+" ");
            inorder(father.getRight());
        }
    }
}
