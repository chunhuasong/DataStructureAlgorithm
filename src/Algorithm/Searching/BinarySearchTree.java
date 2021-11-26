package Algorithm.Searching;

/**
 * @author songhuan
 * @date 2021/11/15 8:48
 */
public class BinarySearchTree {
    BiTNode root;
    public BinarySearchTree(){
        root = new BiTNode();
    }
    static BiTNode p = null;

    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        BinarySearchTree T = new BinarySearchTree();
        // 创建二叉排序树，就是一直插入的过程
        for (int i = 0; i < a.length ; i++) {
             T.root.add(a[i]);
        }
        System.out.println("中序遍历--------");
        // 中序遍历即可得到升序
        TraverseTree(T.root);
        int key = 5;

        System.out.println("查找:" + key + " result：" + SearchBST(T.root,key,null,p));
        int del = 88;
        System.out.println("删除节点：" + del );
        DeleteBST(T.root,del);
        System.out.println("删除后中序遍历--------");
        // 中序遍历即可得到升序
        TraverseTree(T.root);

    }

    static boolean DeleteBST(BiTNode root,int del){
        if(!SearchBST(root,del,null,p)){
            return false;
        }
        else {
            if(del == root.getData()){
                return root.Delete(del);
            }
            else if(del < root.getData() ){
                return DeleteBST(root.lchild,del);
            }
            else {
                return DeleteBST(root.rchild,del);
            }
        }
    }

    private static void TraverseTree(BiTNode root) {
        //中序遍历
            if(root == null){
                return;
            }
            else{
                if(root.getData()!= 0){
                    TraverseTree(root.lchild);
                    System.out.println(root.getData());
                    TraverseTree(root.rchild);
                }
            }

    }

    static boolean InsertBST(BinarySearchTree T, int key){
        BiTNode p = null,s;
        if(!SearchBST(T.root,key,null,p)){
            s = new BiTNode(key);
            if(p == null){
                T.root = s;
            }
            else if(key < p.getData()){
                p.lchild = s;
            }
            else {
                p.rchild =s;
            }
            return true;
        }
        else
            return false;
    }




    static boolean SearchBST(BiTNode root, int key, BiTNode f, BiTNode p){
        //f 是双亲节点 p是查找过程中最后的节点
        if(root == null){
            p = f;
            return false;
        }
        else if(key == root.getData()){
            p = root;
            return true;
        }
        else if(key < root.getData()){
            return SearchBST(root.lchild,key,root,p);
        }
        else{
            return SearchBST(root.rchild,key,root,p);
        }
    }




}

class BiTNode
{
    private int data;
    public BiTNode lchild, rchild;

    public BiTNode() {
        lchild = null;
        rchild = null;
    }

    public BiTNode(int data) {
        this.data = data;
        lchild = null;
        rchild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    //按序添加二叉查找树的节点
    void add(int key){
        if(this.data == 0){
            this.data = key;
        }
        else{
            if(key <= this.data){
                if(this.lchild == null ){
                    this.lchild = new BiTNode();
                }
                this.lchild.add(key);
            }else {
                if(this.rchild == null ){
                    this.rchild = new BiTNode();
                }
                this.rchild.add(key);
            }
        }
    }

    void equal(BiTNode t){
        if (t == null) {
            t = new BiTNode();
        }
        this.data = t.getData();
        this.lchild = t.lchild;
        this.rchild = t.rchild;

    }

    boolean Delete(int del){
        if(this.lchild == null && this.rchild == null){
            this.equal(null);
        }
        if(this.rchild == null){//右子树为空重接它的左子树
            this.equal(this.lchild);
        }
        else if(this.lchild == null){//左子树为空重接它的右子树
            this.equal(this.rchild);
        }
        else
        {
            BiTNode q = this;//前驱
            BiTNode s = this.lchild;
            while (s.rchild != null){//向右到尽头
                q = s;
                s = s.rchild;
            }
            this.data = s.data;   //s的值给要删除的节点
            if(q != this){//要删除的节点和q不一样 证明删除的节点有右子树 把s的左子树接到q的右子树
                //q.rchild.equal(s.lchild);
                q.rchild = s.lchild;
            }
            else {//当前节点没有右子树，s的左子树都接到当前节点左边
                q.lchild = s.lchild; //让地址相同？
            }

        }
        return true;
    }


}
