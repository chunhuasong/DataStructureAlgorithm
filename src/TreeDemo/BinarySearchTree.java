package TreeDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author songhuan

 */

//这个二叉树输入顺序是按照正常的从左到右的顺序输入 排序也是通过左右子树写的
public class BinarySearchTree<T> {
    public Node<T> getRoot() {
        return root;
    }

    private Node<T> root;//根节点
    private T[] dataSource;//树中数据
    private int depth ;

    public int log(double value, double base) {
        //logx(y) =loge(y) / loge(x)，换底公式
        return (int) (Math.log(value) / Math.log(base));
    }


    public BinarySearchTree(T[] dataSource) {
        this.dataSource = dataSource;
        this.root = new Node<>();
        this.root.setIndex(0);
        //this.depth = log(dataSource.length,2) + 1;
    }

    public void generateRoot(Node<T> node){
        if(node.getIndex() < dataSource.length){
            node.setData(dataSource[node.getIndex()]);
            System.out.println("数组中索引地址：" + node.getIndex() + "  节点值："
                    + node.getData());
            node.setLeftChild(createLeft(node));
            node.setRightChild(createRight(node));
        }
    }

    private Node<T> createLeft(Node<T> node) {
        if(node != null){
            if (2*node.getIndex()+1 < dataSource.length && node.getData() != null) {
                node.setLeftChild(new Node());
                node.getLeftChild().setIndex(2*node.getIndex()+1);
                generateRoot(node.getLeftChild());
            }
        }
        return node.getLeftChild();
    }
    private Node<T> createRight(Node<T> node) {
        if(node != null){
            if (2*node.getIndex()+2 < dataSource.length && node.getData() != null ) {
                node.setRightChild(new Node());
                node.getRightChild().setIndex(2*node.getIndex()+2);
                generateRoot(node.getRightChild());
            }


        }
        return node.getRightChild();
    }


    //前序插入二叉树中节点的值
//    public void CreateBiTree(Node<T> node){
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("a");
//        arrayList.add("b");
//        arrayList.add("c");
//        arrayList.add("d");
//        arrayList.add("e");
//        arrayList.add("f");
//        arrayList.add("g");
//
//        T data = null;
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            data = (T) iterator.next();
//            if(node == null){
//
//                //assert node != null;
//
//            }
//            else{
//                Node<T> newNode = new Node<T>(data);
//                CreateBiTree(newNode.getLeftChild());
//                CreateBiTree(newNode.getRightChild());
//
//            }
//        }
//
//    }

    //前序插入二叉树中节点的值
//    public void CreateBiTree(Node<String> node){
//        System.out.print("请输入树的节点值：" );
//        Scanner scan = new Scanner(System.in);
//        String data = null;
//        if(scan.hasNext()){
//            data =  scan.next();
//            System.out.println("输入的节点值：" + data);
//        }
//        scan.close();
//        if(node == null){
//            node.setData(data);
//        }
//        else{
//            Node<String> newNode = new Node<String>(data);
//            CreateBiTree(newNode.getLeftChild1());
//            CreateBiTree(newNode.getRightChild1());
//
//        }
//
//    }

    public void preOrderWideTranverse(Node node) {
        if (node != null) {
            if (node.getData() == null) {
                return;
            }
            System.out.println(node.getData());
            System.out.print(node.getLeftChild() != null ? "-" + node.getLeftChild().getData() : "无leftChild ");
            System.out.print(node.getRightChild() != null ? "-" + node.getRightChild().getData() : "无rightChild");
            System.out.println();
            preOrderWideTranverse(node.getLeftChild());
            preOrderWideTranverse(node.getRightChild());
        }
    }


    public static void main(String[] args) {
        //Integer[] dataSource = {1,2,3,4,5,6,7,8};
        //正常顺序
        Integer[] dataSource = {5,4,8,11,null,13,4,7,2,null,null,null,null,null,1};
        //Integer[] dataSource = {5,4,null,3,null};

/*
用于测试的树
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
 */


        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree(dataSource);
        //test不可以有参数构造
        //System.out.println(binarySearchTree.depth);
        binarySearchTree.generateRoot(binarySearchTree.root);
        //binarySearchTree.preOrderWideTranverse(binarySearchTree.root);//最后一行的输出有问题
        System.out.println("--------------前序：");
        binarySearchTree.PreOrderTraverse(binarySearchTree.root);//5 4 11 7 2 8 13 4 1
        System.out.println("--------------中序：");
        binarySearchTree.InOrderTraverse(binarySearchTree.root);
        System.out.println("--------------后序：");
        binarySearchTree.PostOrderTraverse(binarySearchTree.root);
    }






    //查找节点
    public Node<T> find(int key){
        return null;
    }

    //删除节点
    public Node<T> delete(int id){
        return null;
    }

    //前序遍历
    public void PreOrderTraverse(Node<T> rootNode){
        //node是每个二叉树子树的根节点
        if(rootNode == null){
            return;
        }
        else{
            System.out.println(rootNode.getData());
            PreOrderTraverse(rootNode.getLeftChild());
            PreOrderTraverse(rootNode.getRightChild());
        }
    }

    //中序遍历
    public void InOrderTraverse(Node<T> rootNode){
        //node是每个二叉树子树的根节点
        if(rootNode == null){
            return;
        }
        else{
            InOrderTraverse(rootNode.getLeftChild());
            System.out.println(rootNode.getData());
            InOrderTraverse(rootNode.getRightChild());
        }

    }

    //后序遍历
    public void PostOrderTraverse(Node<T> rootNode){
        //node是每个二叉树子树的根节点
        if(rootNode == null){
            return;
        }
        else{
            PostOrderTraverse(rootNode.getLeftChild());
            PostOrderTraverse(rootNode.getRightChild());
            System.out.println(rootNode.getData());
        }

    }




}

class Node<T>{
    private T data;
    private Integer index;//角标
    private Node leftChild;
    private Node rightChild;

    public Node(T data, Integer index) {
        this.data = data;
        this.index = index;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Node getLeftChild() {
        return leftChild;
    }
    public Node<String> getLeftChild1() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    public Node<String> getRightChild1() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
