package u_dataStructures.DataStructures;

 
import u_dataStructures.Nodes.MyTreeNodeMore;

public class MyBinaryTree <T extends Comparable<T>> {
    private MyTreeNodeMore<T> root;
    
    
    
    public MyBinaryTree(){
        this.root = null;
    }

    public void add(T value){
        if(value != null){
            if(root == null){
                    root = new MyTreeNodeMore<>(value);
            }else{
                addingNode(value, root);
            }
        }
    }



    public void addingNode(T value, MyTreeNodeMore<T> father){
        //if(value.compareTo(father.getObj()) != 0){
            if(value.compareTo(father.getObj()) >0){
                if(father.getRight() == null){
                    father.setRight(new MyTreeNodeMore<>(value));
                }else{
                    addingNode(value, father.getRight());
                }
            }else{
                if(father.getLeft() == null){
                    father.setLeft(new MyTreeNodeMore<>(value));
                }else{
                    addingNode(value, father.getLeft());
                }
            }
        //}
        
    }

    public boolean contains(T valueSearch){
        return contains(root, valueSearch);
    }
    private boolean contains(MyTreeNodeMore<T> father, T value){
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
    private void preorder(MyTreeNodeMore<T> node){
        if(node != null){
            System.out.print(node.getObj()+" ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void postorder(){
        this.postorder(root);
    }
    private void postorder(MyTreeNodeMore<T> node){
        if(node!= null){
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getObj()+" ");
        }
    }

    public void inorder(){
        this.inorder(root);
    }

    private void inorder(MyTreeNodeMore<T> node){
        if(node != null){
            inorder(node.getLeft());
            System.out.print(node.getObj()+" ");
            inorder(node.getRight());
        }
    }
    public void printLayers(){
        this.printByLayers(root);
    }
    private void printByLayers(MyTreeNodeMore<T> node){
        if(node !=null){
            System.out.print(node.getObj());
            printByLayers(node.getLeft());
            printByLayers(node.getRight());
            System.out.print(" ");
        }
    }
    public void printInorderWithoutRecursion(){
        this.inorder2();
    }
    private void inorder2(){
        if(root == null){
            return;
        }

        MyStack<MyTreeNodeMore<T>> s = new MyStack<>();
        MyTreeNodeMore<T> current = root;

        while(current !=null || s.size()>0){
            while(current != null){
                s.push(current);
                current = current.getLeft();
            }
            current = s.pop();
            System.out.println(current.getObj()+" ");
            current = current.getRight();
        }

    }
    public void remove(T data){
        root = remover2( root, data);
    }
    // private MyTreeNodeMore<T> remover(T data, MyTreeNodeMore<T> father){
    //     if(father == null){
    //         return father;
    //     }

    //     if( data.compareTo(father.getObj()) < 0 ){
    //         father.setLeft(remover(data, father.getLeft()));
    //     }else if (data.compareTo(father.getObj()) > 0){
    //         father.setRight(remover(data, father.getRight()));
    //     }else{
    //         if(father.getLeft() == null){
    //             return father.getRight();
    //         }else if (father.getRight() == null){
    //             return father.getLeft();
    //         }
    //         father.setObj(minValue(father.getRight()));

    //         father.setRight(remover(father.getObj(), father.getRight()));

    //     }
    // }
    public MyTreeNodeMore<T> remover2(MyTreeNodeMore<T> current, T deleted){
        if(current == null)
            return current;
        
        if(current.getObj().compareTo(deleted) > 0){
            current.setLeft(remover2(current.getLeft(), deleted));
            return current;
        }
        else if (current.getObj().compareTo(deleted) <0){
            current.setRight(remover2(current.getRight(), deleted));
            return current;
        }
        // node Deleted
        if(current.getLeft() == null){
            MyTreeNodeMore<T> aux = current.getRight();
            return aux;
        }else if(current.getRight() == null){
            MyTreeNodeMore<T> aux = current.getLeft();
            return aux;
        }
        // dos ratas abajo
        else{
            MyTreeNodeMore<T> father = current;
            MyTreeNodeMore<T> son = current.getRight();
            while(son.getLeft() != null){
                father = son;
                son = son.getLeft();
            }
            if(father != current)
                father.setLeft(son.getRight());
            else
                father.setRight(son.getRight());

            current.setObj(son.getObj());
            return current;
        }
    }
    public T minValue(MyTreeNodeMore<T> father){
        T value = father.getObj();
        while(father.getLeft()!= null){
            value = father.getLeft().getObj();
            father = father.getLeft();
        }
        return value;
    }
    public void print2(){
        this.print22(root, 0);
    }
    private void print22(MyTreeNodeMore<T> current, int spaces){
        if(current == null)
            return;
        spaces += 10;
        print22(current.getRight(), spaces);
        System.out.print("\n");
        for(int i = 10; i< spaces; i++)
            System.out.print(" ");
        System.out.print(current.getObj() + "\n");
        print22(current.getLeft(), spaces);
    }

    
}
