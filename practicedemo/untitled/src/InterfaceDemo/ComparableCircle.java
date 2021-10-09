package InterfaceDemo;

public class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle(int i) {
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }

//    public ComparableCircle(double r){
//        super(r);
//    }




   // @Override
//    public int compareTo(Object o) {
//        if(this==o)
//        return 0;
//        if (o instanceof ComparableCircle){
//            ComparableCircle c=(ComparableCircle)o;
//
//            if(this.getRadius() > c.getRadius()) {
//				return 1;
//			}else if(this.getRadius() < c.getRadius()) {
//				return -1;
//			}else {
//				return 0;
//			}
//        }
//    }
}
