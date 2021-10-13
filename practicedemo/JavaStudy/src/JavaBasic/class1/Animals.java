package JavaBasic.class1;

public class Animals {
    private int legs;
    public void eat(){
        System.out.println("Eating");
    }
    public Animals(){
        legs=4;
    }
    public int getLegs()
    {return legs;}
    public void setLegs(int legs)
    {
        this.legs=legs;
    }

    public static void main(String[] args) {
        Animals dogs=new Animals();
        System.out.println(dogs.getLegs());
    }
}
