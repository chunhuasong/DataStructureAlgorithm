package Algorithm.Searching;

/**
 * @author songhuan
 * @date 2021/11/15 16:50
 */

//平衡二叉树 有问题
public class AVL {
    AVLNode root;
    public AVL() {
        root = new AVLNode();
    }

    public static void main(String[] args) {
        //int[] a ={3,2,1};
        //int[] a = {4,7,9};
        int[] a = {3,2,1,4,5,6,7,10,9,8};
        AVL T = new AVL();

        // 创建二叉排序树，就是一直插入的过程
        for (int i = 0; i < a.length; i++) {
            //T.root.InsertAVL(a[i]);
            T.root.add(a[i]);
        }
        System.out.println("中序遍历--------");
        // 中序遍历即可得到升序
        TraverseTree(T.root);

    }

    static AVLNode R_Rotate(AVLNode P){
        //顺时针旋转
        AVLNode L = null;
        L= P.lchild; //P的左子树给L
        P.lchild = L.rchild;//L的右子树给P的左子树
        L.rchild = P;//P做L的右子树
        P = L; //l换到P原来的位置
        return P;
    }

    static AVLNode L_Rotate(AVLNode P){
        AVLNode R = null;
        R = P.rchild;//R指向P的右子树根节点
        P.rchild = R.lchild;//r的左子树给P的右子树
        R.lchild = P;//P指向R的左子树
        P = R;//R指向P
        return P;
    }

    private static void TraverseTree(AVLNode root) {
        //中序遍历
        if(root == null){
            return;
        }
        else{
            if(root.data!= 0){
                TraverseTree(root.lchild);
                System.out.println(root.data);
                System.out.print(root.lchild != null ? "-" + root.lchild.data : "无leftChild ");
                System.out.print(root.rchild != null ? "-" + root.rchild.data : "无rightChild");
                System.out.println();
                TraverseTree(root.rchild);
            }
        }

    }

    //static int LH = 1,EH = 0,RH = -1;//分别为左高，等高，右高


//左平衡旋转处理 前提是树不平衡，左子树大于右子树
    static AVLNode LeftBalance(AVLNode t){
        AVLNode L,Lr;
        L = t.lchild;
        switch (L.bf){//检查T的左子树的平衡度
            //新节点插在T的左孩子的左子树上 单右旋
            case 1://左边高 和根节点BF相同
                t.bf = L.bf = 0;//bf都改为0
                t = R_Rotate(t);//右旋
                //return t;
                break;
            //新节点插在T左孩子的右子树上 双旋
            case -1:
                Lr = L.rchild;
                switch (Lr.bf){//对L的右子树bf做判断
                    case 1:
                        t.bf = -1;
                        L.bf = 0;
                        break;
                    case 0:
                        t.bf = L.bf = 0;
                        break;
                    case -1:
                        t.bf = 0;
                        L.bf = 1;
                        break;
                }
                Lr.bf = 0;
                t = L_Rotate(t.lchild);//对T的左子树左旋
                t = R_Rotate(t);//对T右旋
        }
        return t;
    }
    
    //右平衡旋转处理 前提是树不平衡，右子树大于左子树
    static AVLNode RightBalance(AVLNode t){
        AVLNode R,Rl;
        R = t.rchild;
        switch (R.bf){//检查T的右子树的平衡度
            //新节点插在T的右孩子的右子树上 单左旋
            case -1://左边高 和根节点BF相同
                t.bf = R.bf = 0;//bf都改为0
                t = L_Rotate(t);//左旋
                //return t;
                break;
            //新节点插在T右孩子的左子树上 双旋
            case 1:
                Rl = R.lchild;
                switch (Rl.bf){//对R的左子树bf做判断
                    case 1:
                        t.bf = 0;
                        R.bf = -1;
                        break;
                    case 0:
                        t.bf = R.bf = 0;
                        break;
                    case -1:
                        t.bf = 1;
                        R.bf = 0;
                        break;
                }
                Rl.bf = 0;
                t = R_Rotate(t.rchild);//对T的右子树右旋
                t = L_Rotate(t);//对T左旋
        }
        return t;
    }

    //二叉平衡树 插入操作返回根节点
    // 看是不是破坏平衡 失去平衡做平衡旋转处理
    // taller 判断长高与否
    static AVLNode InsertAVL(AVLNode t, int e, boolean taller){
        if(t == null){
            t = new AVLNode();
            t.data = e;
            taller = true;
        }

        if(t !=null && t.data == 0){
            t.data = e;
            t.lchild = t.rchild = null;
            t.bf = 0;
            taller = true;
        }
        else {
            if(e == t.data){
                taller = false;
                System.out.println("已经存在该值");

            }
            if(e < t.data){
                if(t == InsertAVL(t.lchild,e,taller)){
                    System.out.println("已经存在该值");
                }
                if(taller){//插到T的左子树且左子树长高
                    switch (t.bf){
                        case 1://左比右高 左平衡处理
                            t = LeftBalance(t);
                            taller = false;
                            break;
                        case 0://左右等高 左子树增高
                            t.bf = 1;
                            taller = true;
                            break;
                        case -1://右比左高 现在左右等高
                            t.bf = 0;
                            taller = false;
                            break;
                    }
                }
            }
            else {
                //在右子树搜索
                if(t == InsertAVL(t.rchild,e,taller)){
                    System.out.println("已经存在该值");
                }
                if(taller){
                    switch (t.bf){
                        case 1://原本左比右高 现在等高
                            t.bf = 0;
                            taller = false;
                            break;
                        case 0://原本等高 现在右比左高
                            t.bf = -1;
                            taller = true;
                            break;
                        case -1://原本右高 现在需要右平衡
                            t = RightBalance(t);
                            taller = false;
                            break;
                    }
                }
            }
        }
        return t;
    }





}

class AVLNode{
    int data;
    int bf;
    AVLNode lchild,rchild;
    //boolean taller;

    public AVLNode() {
        data = 0;
        lchild = null;
        rchild = null;
    }

    //按序添加二叉查找树的节点
    void add(int key){
        if(this.data == 0){
            this.data = key;
        }
        else{
            if(key <= this.data){
                if(this.lchild == null ){
                    this.lchild = new AVLNode();
                }
                this.lchild.add(key);
            }else {
                if(this.rchild == null ){
                    this.rchild = new AVLNode();
                }
                this.rchild.add(key);
            }
        }
    }

    void R_Rotate(){
        //顺时针旋转
        AVLNode L = null;
        L= this.lchild; //this的左子树给L
        this.lchild = L.rchild;//L的右子树给this的左子树
        L.rchild = this;//this做L的右子树
        this.equal(L); //l换到this原来的位置
    }

    void L_Rotate(){
        AVLNode R = null;
        R = this.rchild;//R指向this的右子树根节点
        this.rchild = R.lchild;//r的左子树给this的右子树
        R.lchild = this;//this指向R的左子树
        this.equal(R);//R指向this
    }

    void equal(AVLNode t){
        if (t == null) {
            t = new AVLNode();
        }
        this.data = t.data;
        this.lchild = t.lchild;
        this.rchild = t.rchild;

    }

    //左平衡旋转处理 前提是树不平衡，左子树大于右子树
    void LeftBalance(){
        AVLNode L,Lr;
        L = this.lchild;
        switch (L.bf){//检查this的左子树的平衡度
            //新节点插在this的左孩子的左子树上 单右旋
            case 1://左边高 和根节点BF相同
                this.bf = L.bf = 0;//bf都改为0
                this.R_Rotate();//右旋
                break;
            //新节点插在this左孩子的右子树上 双旋
            case -1:
                Lr = L.rchild;
                switch (Lr.bf){//对L的右子树bf做判断
                    case 1:
                        this.bf = -1;
                        L.bf = 0;
                        break;
                    case 0:
                        this.bf = L.bf = 0;
                        break;
                    case -1:
                        this.bf = 0;
                        L.bf = 1;
                        break;
                }
                Lr.bf = 0;
                this.lchild.L_Rotate();//对this的左子树左旋
                this.R_Rotate();//对this右旋
        }
        
    }

    //右平衡旋转处理 前提是树不平衡，右子树大于左子树
    void RightBalance(){
        AVLNode R,Rl;
        R = this.rchild;
        switch (R.bf){//检查this的右子树的平衡度
            //新节点插在this的右孩子的右子树上 单左旋
            case -1://左边高 和根节点BF相同
                this.bf = R.bf = 0;//bf都改为0
                this.L_Rotate();//左旋
                //rethisurn this;
                break;
            //新节点插在this右孩子的左子树上 双旋
            case 1:
                Rl = R.lchild;
                switch (Rl.bf){//对R的左子树bf做判断
                    case 1:
                        this.bf = 0;
                        R.bf = -1;
                        break;
                    case 0:
                        this.bf = R.bf = 0;
                        break;
                    case -1:
                        this.bf = 1;
                        R.bf = 0;
                        break;
                }
                Rl.bf = 0;
                this.rchild.R_Rotate();//对this的右子树右旋
                this.L_Rotate();//对this左旋
        }
        
    }

    //二叉平衡树 插入操作返回根节点
    // 看是不是破坏平衡 失去平衡做平衡旋转处理
    // taller 判断长高与否
    boolean InsertAVL(int e){

        AVLNode t = new AVLNode();

        if(this.data == 0){
            this.data = e;
            this.lchild = this.rchild = null;
            this.bf = 0;

        }
        else {
            if(e == this.data){

                System.out.println("已经存在该值");
                return false;
            }
            if(e < this.data){
                if (this.lchild != null) {
                    if(!this.lchild.InsertAVL(e) ){
                        System.out.println("已经存在该值");
                        return false;
                    }

                }
                else{
                    this.lchild = t;
                    this.lchild.data = e;
                    this.bf++;


                }
                if(leftheight() - rightheight() > 1){//插到T的左子树且左子树长高
                    switch (this.bf){
                        case 1://左比右高 左平衡处理
                            this.LeftBalance();

                            break;
                        case 0://左右等高 左子树增高
                            this.bf = 1;

                            break;
                        case -1://右比左高 现在左右等高
                            this.bf = 0;

                            break;
                    }
                }
            }
            else {
                //在右子树搜索
                if (this.rchild != null) {
                    if(!this.rchild.InsertAVL(e)){
                        System.out.println("已经存在该值");
                        return false;
                    }
                }
                else {
                    this.rchild = t;
                    this.rchild.data = e;
                    this.bf--;

                }
                if(rightheight() - leftheight() > 1){
                    switch (this.bf){
                        case 1://原本左比右高 现在等高
                            this.bf = 0;

                            break;
                        case 0://原本等高 现在右比左高
                            this.bf = -1;

                            break;
                        case -1://原本右高 现在需要右平衡
                            this.RightBalance();

                            break;
                    }
                }
            }
        }
        return true;
    }

    public int leftheight() {//返回左子树高度
        if(lchild==null) {
            return 0;
        }
        return lchild.height();
    }
    public int rightheight() {//返回右子树高度
        if(rchild==null) {
            return 0;
        }
        return rchild.height();
    }
    public int height() {//返回高度
        return Math.max(lchild==null?0:lchild.height(), rchild==null?0:rchild.height())+1;
    }


}
