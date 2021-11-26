package TreeDemo;

/**
 * @author songhuan
 * @date 2021/11/10 15:38
 */

import java.util.Scanner;

public class dahuaCreateTree {

     private  static int pos;
    public static void main(String[] args) {
        String string = "AB#D##C##";
        //BiThrNode biThrNode = new BiThrNode();
        pos = 0;
        BitNode p = new BitNode();
        create(p,string);
        show(p);
    }

    private static void create(BitNode bitNode,String str){
        //这个是按照前序遍历输入的
        if(pos < str.length()) {
            char ch = str.charAt(pos++);
            if (ch == '#')
                bitNode.data = null;
            else {
                bitNode.data = ch;
                bitNode.lchild = new BitNode();

                // 前序遍历法，会顺着左孩子一直向下，当到头的时候，会处理右孩子
                // 处理完了之后在往上一层，处理上一层的右孩子
                create(bitNode.lchild,str);
                bitNode.rchild = new BitNode();
                create(bitNode.rchild,str);
            }
        }
    }

    private static void show(BitNode bitNode){
        if(bitNode.data != null){
            // 前序遍历
            System.out.println(bitNode.data);
            show(bitNode.lchild);
            show(bitNode.rchild);

        }

    }
}

class BitNode
{
    public Object data;
    public BitNode lchild, rchild;
    public BitNode() {

    }
}

