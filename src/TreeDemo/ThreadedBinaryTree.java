package TreeDemo;

import java.util.Scanner;

/**
 * @author songhuan
 * @date 2021/11/11 8:43
 */

//线索二叉树 自己实现 前序遍历创建树 因为这样第一个值是根节点 然后在根节点上加一个头节点 再中序线索化
public class ThreadedBinaryTree {
    private static int pos;
    //前序遍历创建树
    public static void createTBT(BiThrNode p,String string){
        if(pos < string.length()) {
            char ch = string.charAt(pos++);
            if (ch=='#')
                p.data = null;

            else
            {
                p.data = ch;
                p.lchild = new BiThrNode();
                createTBT(p.lchild,string);

                p.rchild = new BiThrNode();
                createTBT(p.rchild,string);
            }
        }


    }

    //中序遍历进行中序线索化
    static BiThrNode pre = new BiThrNode(Boolean.TRUE);//指向刚刚访问过的节点 为防止空指针异常 初始化一下
    public static void InThreading(BiThrNode p){

        if (p.data != null) { // 根据data来判断是否为空，而不是根据bitThrNode本身
            InThreading(p.lchild);
            //打印改成线索化
            if (p.lchild.data == null){//如果没有左孩子
                p.ltag = 1;     //设为前驱线索
                p.lchild = pre; //前驱赋值给左孩子
            }
            if(pre.rchild.data == null){//如果前驱没有右孩子
                pre.rtag = 1;   //前驱设为后驱线索
                pre.rchild = p;//前驱右孩子的指针指向后继p
            }
            pre = p; //当前节点赋值给pre
            InThreading(p.rchild);
        }

    }

    //中序遍历线索二叉树
    public static void InOrderTraverse(BiThrNode head){
        //T是加了一个头节点的二叉线索树
        //在二叉树线索链表上添加一个头节点
        // 头节点的lchild指向二叉树根节点 rchild指向二叉树中序遍历的最后节点
        // 反之 中序遍历的第一个节点的lchild、最后一个节点的rchild指向头节点
        BiThrNode p;
        p = head.lchild; // p 指向根节点
        while( p != head ){ //空树或遍历结束时 p==T
            while (p.ltag == 0 && p.data != null){ //p.ltag = 0 是中序遍历的第一个节点 第一个总输出null 过头了
                p = p.lchild; //让p一直往左找左孩子 直到p.tag=1 到左边的尽头了
            }
            System.out.println("data: " + p.data + " ltag: " + p.ltag
                    + " rtag: " + p.rtag);
            while(p.rtag == 1 && p.rchild != head){//左子树到头 开始打印后继
                p = p.rchild;
                System.out.println("data: " + p.data + " ltag: " + p.ltag
                        + " rtag: " + p.rtag);
            }
            p = p.rchild;
        }
    }

    //正常遍历二叉树
    public static void PreOrderNormalTraverse(BiThrNode node) {
        if (node != null) {
            if (node.data == null) {
                return;
            }
            System.out.println(node.data);
            System.out.print(node.lchild != null ? "-" + node.lchild.data : "无leftChild ");
            System.out.print(node.rchild != null ? "-" + node.rchild.data : "无rightChild");
            System.out.println();

            PreOrderNormalTraverse(node.lchild);

            PreOrderNormalTraverse(node.rchild);
        }
    }

    public static void main(String[] args) {
        String string = "AB#D##C##";
        pos = 0;
        BiThrNode p = new BiThrNode();
        createTBT(p,string);
        System.out.println("------正常遍历-------");
        //前序遍历返回根
        PreOrderNormalTraverse(p);
        //创建头节点
        BiThrNode head = new BiThrNode();
        getHeadNode(p,head);
        //在线索化之前创建 在原来的树根上加了一个头节点
        InThreading(p);

        head.ltag = 0;//头节点没有前驱
        head.lchild = p; //头节点左孩子是原来的根节点
        head.rchild.rtag = 1; //头节点有后驱节点（中序遍历的最后一个节点）
        head.rchild.rchild = head; //头节点后驱的后驱是他自己
        System.out.println("--------遍历线索二叉树-------");
        InOrderTraverse(head);


    }

    private static void getHeadNode(BiThrNode thrNode, BiThrNode head) {
        if (thrNode.data != null){
            //中序把二叉树和新建的头节点连上
            getHeadNode(thrNode.lchild, head);
            head.rchild = thrNode;
            getHeadNode(thrNode.rchild, head);
        }
    }

}

class BiThrNode{

    public Object data;
    BiThrNode lchild;
    BiThrNode rchild;
    //tag = 1 代表前驱后驱 tag = 0 代表左右孩子
    int ltag;
    int rtag;

    public BiThrNode() {
    }
    public BiThrNode(Boolean b) {
        data = null;
        ltag = 0;
        rtag = 0;
        lchild = new BiThrNode();
        rchild = new BiThrNode();
    }
}

