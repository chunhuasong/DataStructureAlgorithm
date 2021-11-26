package Algorithm.Searching;

/**
 * @author https://blog.csdn.net/weixin_46360473/article/details/105380241
 * @date 2021/11/16 16:33
 */

//这个删除有点问题
public class Balancedbinarytree {

    public static void main(String[] args) {
        int arr[]= {3,2,1,4,5,6,7,10,9,8};
        binarytree binary = new binarytree();
        for(int i=0;i<arr.length;i++) {
            binary.add(new Node(arr[i]));
        }
        System.out.println("----完成平衡二叉树的创建----");
        System.out.println("平衡二叉树的高度为："+binary.getRoot().height());
        System.out.println("平衡二叉树左子树的高度为："+binary.getRoot().leftheight());
        System.out.println("平衡二叉树右子树的高度为："+binary.getRoot().rightheight());
        System.out.println("中序排序结果为：");
        binary.infixorder();
        //binary.deleteNode(3);
        System.out.println("----删除平衡二叉树的结点----");
        binary.deleteNode(3);
        binary.deleteNode(1);
        binary.deleteNode(4);
        System.out.println("平衡二叉树的高度为："+binary.getRoot().height());
        System.out.println("平衡二叉树左子树的高度为："+binary.getRoot().leftheight());
        System.out.println("平衡二叉树右子树的高度为："+binary.getRoot().rightheight());
        System.out.println("前序遍历结果为：");
        binary.preorder();
        System.out.println("中序排序结果为：");
        binary.infixorder();

    }

}
class binarytree{
    private Node root;
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public void add(Node no) {//添加结点
        if(root==null) {
            root=no;
        }else {
            root.add(no);
        }
    }
    public void deleteNode(int data) {//删除结点
        if(root==null) {
            System.out.println("二叉排序树为空,无法删除结点！");
        }else {
            root.delete(root, data);

        }
    }
    public void preorder() {//前序遍历
        if(root==null) {
            System.out.println("平衡二叉树为空！");
        }else {
            this.root.preorder();
        }
        System.out.println();
    }
    public void infixorder() {//中序遍历
        if(root==null) {
            System.out.println("平衡二叉树为空！");
        }else {
            this.root.infixorder();
        }
        System.out.println();
    }

}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data=data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return data + " ";
    }

    public void add(Node no) {// 添加结点，构成二叉排序树
        if (no == null) {
            return;
        }
        if (no.data != this.data) {// 一些地方提到二叉平衡树中没有相同键值的结点，一些地方又允许存在
            if (no.data < this.data) {// 向左子树递归
                if (this.left == null) {
                    this.left = no;
                } else {
                    this.left.add(no);
                }
            } else {
                if (no.data > this.data) {// 向右子树递归
                    if (this.right == null) {
                        this.right = no;
                    } else {
                        this.right.add(no);
                    }
                }
            }
        }
        if (rightheight() - leftheight() > 1) {// 如果添加结点后，右子树高度-左子树高度>1
            if (right != null && right.leftheight() > right.rightheight()) {//新节点插在this右孩子的左子树上 双旋
                right.rightturn();//对this的右子树右旋
                leftturn();
            } else {//新节点插在this的右孩子的右子树上 单左旋
                leftturn();//对this左旋
            }
            return;
        }
        if (leftheight() - rightheight() > 1) {//如果添加结点后，左子树高度-右子树高度>1
            // 新节点插在this左孩子的右子树上 双旋
            if (left != null && left.rightheight() > left.leftheight()) {
                left.leftturn();//对this的左子树左旋
                rightturn();//对this右旋
            } else {//在左孩子左子树上 右旋
                rightturn();
            }
        }
    }
    public Node delete(Node root, int key) {//删除结点
        if (root == null)
        {
            return null;
        }
        if (key < root.getData()){// 向左子树进行删除
            root.setLeft(delete(root.getLeft(), key));
            if (rightheight() - leftheight() > 1) {// 如果添加结点后，右子树高度-左子树高度>1
                if (right != null && right.leftheight() > right.rightheight()) {
                    right.rightturn();
                    leftturn();
                } else {
                    leftturn();
                }
            }
            if (leftheight() - rightheight() > 1) {
                if (left != null && left.rightheight() > left.leftheight()) {
                    left.leftturn();
                    rightturn();
                } else {
                    rightturn();
                }
            }
            return root;
        }
        if (key > root.getData()){// 向右子树进行删除
            root.setRight(delete(root.getRight(), key));
            if (rightheight() - leftheight() > 1) {// 如果添加结点后，右子树高度-左子树高度>1
                if (right != null && right.leftheight() > right.rightheight()) {
                    right.rightturn();
                    leftturn();
                } else {
                    leftturn();
                }

            }
            if (leftheight() - rightheight() > 1) {
                if (left != null && left.rightheight() > left.leftheight()) {
                    left.leftturn();
                    rightturn();
                } else {
                    rightturn();
                }

            }
            return root;
        }
        if (root.getLeft() == null && root.getRight() == null){// 如果删除结点是叶子节点
            root = null;
            return root;
        }
        if (root.getLeft() == null && root.getRight() != null){// 如果删除结点只有右子树
            root = root.getRight();
            return root;
        }
        if (root.getRight() == null && root.getLeft() != null){// 如果删除结点只有左子树
            root = root.getLeft();
            return root;
        }
        if (root.getLeft() != null && root.getRight() != null){// 如果删除结点为父结点
            int val = findMaxInLeftTree(root.getLeft());// 让左子树中最大或者右子树中最小的结点替换当前节点，同时将置换结点置空
            root.setData(val);
            root.setLeft(delete(root.getLeft(),val));
            return root;
        }



        return root;

    }
    private static int findMaxInLeftTree(Node left) {// 找到左子树中最大的节点的值
        if (left == null)
        {
            return 0;
        }
        if (left.getRight() == null)
        {
            return left.getData();
        }
        if (left.getRight() == null && left.getLeft() == null)
        {
            return left.getData();
        }
        return findMaxInLeftTree(left.getRight());
    }
    public void preorder() {//前序遍历
        System.out.print(this);
        if(this.left!=null) {
            this.left.preorder();
        }
        if(this.right!=null) {
            this.right.preorder();
        }
    }
    public void infixorder() {//中序遍历
        if(this.left!=null) {
            this.left.infixorder();
        }
        System.out.println(this.data);
        System.out.print(this.left != null ? "-" + this.left.data : "无leftChild ");
        System.out.print(this.right != null ? "-" + this.right.data : "无rightChild");
        System.out.println();
        if(this.right!=null) {
            this.right.infixorder();
        }
    }
    public int leftheight() {//返回左子树高度
        if(left==null) {
            return 0;
        }
        return left.height();
    }
    public int rightheight() {//返回右子树高度
        if(right==null) {
            return 0;
        }
        return right.height();
    }
    public int height() {//返回高度
        return Math.max(left==null?0:left.height(), right==null?0:right.height())+1;
    }

    private void leftturn() {	//左旋转方法
        Node no = new Node(data);
        no.left = left;
        no.right = right.left;
        data = right.data;
        right = right.right;
        left = no;
    }

    private void rightturn() {//右旋转
        Node no=new Node(data);
        no.right=right;
        no.left=left.right;
        data=left.data;
        left=left.left;
        right=no;
    }
}


