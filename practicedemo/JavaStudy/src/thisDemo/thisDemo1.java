package thisDemo;

public class thisDemo1 {
    //this:引用当前类的实例变量
     int no;
     String name;
     float fee;
//     public thisDemo1(int no,String name,float fee){
//         no = no;
//         name = name;
//         fee = fee;
//     }//参数(形式参数)和实例变量(no和name)是相同的。 所以要使用this关键字来区分局部变量和实例变量。//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/this-keyword.html
     public thisDemo1(int no,String name,float fee){
        this.no = no;
        this.name = name;
        this.fee = fee;
    }


    void display(){
         System.out.println(no + " " + name + " " + fee);
     }

    public static void main(String[] args) {
        thisDemo1 one = new thisDemo1(11,"bob",100f);
        one.display();
        //output：0 null 0.0(无this)

    }
}
