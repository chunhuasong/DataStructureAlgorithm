package JavaBasic.InterfaceDemo;

public class ComparableCircle extends Circle implements CompareObject {

    private double r;

//    public ComparableCircle(double r) {
//        //this.r = r;
//这么写就跟父类无关
//    }

    public ComparableCircle(double r) {
        super(r);
//super继承父类的方法
    }

    public double getR() {
        //test中赋值的r是传给父类，不是子类，这里r=0
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

//    @Override
//    public int compareTo(Object o) {
//        ComparableCircle c = (ComparableCircle)o;
//        if(this == o)
//            return 0;
//        else if(this.getR() < c.getR())
//            return -1;
//        else if(this.getR() > c.getR())
//            return 1;
//    }

//    public ComparableCircle(double r){
//        super(r);
//    }




    @Override
    public int compareTo(Object o) {
        if(this == o)
            return 0;

        if (o instanceof ComparableCircle){

            ComparableCircle c = (ComparableCircle)o;

            if(this.getRadius() > c.getRadius())
				return 1;
			else if(this.getRadius() < c.getRadius())
				return -1;
			else
			    return 0;
        }
        else
        {
            return 0;
            //throw new RuntimeException("传入类型不匹配");
        }
        //要注意if条件会出现某种情况并未出现 所以会没返回值

    }
}
