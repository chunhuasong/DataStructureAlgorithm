package gaojileitexing;


    public final class FINAL{
        public static int totalNumber= 5 ;
        public final int id;
        public FINAL(){
            id = ++totalNumber;//只能在构造方法中给final变量赋值
        }
        public static void main(String[] args) {
            FINAL t = new FINAL();
            System.out.println(t.id);
            final int i = 10;
            final int j;
            j = 20;
            //j = 30; //非法
        }
    }


