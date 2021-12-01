package u_dataStructures.DataStructures;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
        
            if(value.compareTo(father.getObj()) >0){
                if(father.getRight() == null){
                    father.setRight(new MyTreeNodeMore<>(value));
                }else{
                    addingNode(value, father.getRight());
                }
            }else{
                if(value.compareTo(father.getObj()) <0){
                    if(father.getLeft() == null){
                        father.setLeft(new MyTreeNodeMore<>(value));
                    }else{
                        addingNode(value, father.getLeft());
                    }
                }
            }
        
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
    
    public void printInorderWithoutRecursion(){
        this.inorder2();
    }
/*
        1) Se crea un stack vacio
        2) inicializamos del nodo current como el root
        3) Push the current node to S and set current = current->left until current is NULL
        4) If current is NULL and stack is not empty then 
            a) Pop the top item from stack.
            b) Print the popped item, set current = popped_item->right 
            c) Go to step 3.
        5) If current is NULL and stack is empty then we are done.
        */
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
        root = removerByNodes( root, data);
    }
    
    private MyTreeNodeMore<T> removerByNodes(MyTreeNodeMore<T> current, T deleted){
        if(current == null){
            return current;
        }
        
        if(deleted.compareTo(current.getObj())  < 0){
            current.setLeft(removerByNodes(current.getLeft(), deleted));
            return current;
        }else{
            if(deleted.compareTo(current.getObj()) > 0){
                current.setRight(removerByNodes(current.getRight(), deleted));
                return current;
            }
        }
        if(current.getLeft() == null){
            return current.getRight();
        }else{ 
            if(current.getRight() == null){  
                return current.getLeft();
            }else{
                MyTreeNodeMore<T> father = current;
                MyTreeNodeMore<T> son = current.getRight();
                while(son.getLeft() != null){
                    father = son;
                    son = son.getLeft();
                }
                if(father != current){
                    father.setLeft(son.getRight());
                }else{
                    father.setRight(son.getRight());
                }
                son.setRight(current.getRight());
                son.setLeft(current.getLeft());
                return son;
            }
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
    public T maxValue(MyTreeNodeMore<T> father){
        T value = father.getObj();
        while(father.getRight() != null){
            value  = father.getRight().getObj();
            father = father.getRight();
        }
        return value;
    }
    public void print2(){
        this.printHorizontaly(root, 0);
    }
    private void printHorizontaly(MyTreeNodeMore<T> current, int spaces){
        if(current == null)
            return;
        spaces += 10;
        printHorizontaly(current.getRight(), spaces);
        System.out.print("\n");
        for(int i = 10; i< spaces; i++)
            System.out.print(" ");
        System.out.print(current.getObj() + "\n");
        printHorizontaly(current.getLeft(), spaces);
    }

    public int numberNodes(){
        return this.counterNodes(root);
    }
    private int counterNodes(MyTreeNodeMore<T> current){
        int counter = 1;
        
        if (current.getLeft() != null){
            counter += counterNodes(current.getLeft());
        }

        if(current.getRight() != null){
            counter += counterNodes(current.getRight());
        }

        return counter;
    }

    public int numberLeafs(){
        return this.counterLeafs(root);
    }
    private int counterLeafs(MyTreeNodeMore<T> current){
        int counter = 0;
        if(current.getLeft() == null && current.getRight() == null){
            counter++;
        }
        if(current.getLeft() != null){
            counter += counterLeafs(current.getLeft());
        }

        if(current.getRight() != null){
            counter += counterLeafs(current.getRight());
        }
        return counter;
    }

    public int height(){
        return this.height(root);
    }
    private int height(MyTreeNodeMore<T> current){
        if(current == null){
            return -1;
        }else{
            int left_t = height(current.getLeft());
            int right_t = height(current.getRight());
            if(left_t > right_t){
                return left_t + 1;
            }else{
                return right_t + 1;
            }
        }
    }
    public void printLevels(){
        this.levelOrder(root);
    }
    private void levelOrder(MyTreeNodeMore<T> current){
        // Mapear lo niveles
        Map<Integer, List<T>> map = new HashMap<>();

        preorderForLevel(current, 1, map);

        for (int i = 1; i <= map.size(); i++) {
            System.out.println("Nivel " + i + ": " + map.get(i));
        }
    }
    private void preorderForLevel(MyTreeNodeMore<T> root, int level, Map<Integer, List<T>> map)
    {

        if (root == null) {
            return;
        }
        // ponemos el nivel y la lista inicializado para los valores del nivel 
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.getObj());

        preorderForLevel(root.getLeft(), level + 1, map);
        preorderForLevel(root.getRight(), level + 1, map);
    }
    
}
