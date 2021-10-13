package Exception;


public class Test{
    public static void main(String[] args)    {
        String friends[]={"lisa","bily","kessy"};
        try {
            for(int i=0;i<5;i++) {
                System.out.println(friends[i]);
            }
        }
//        catch(ArrayIndexOutOfBoundsException e)  {
//            System.out.println("index err");
//        }
        catch(Exception e)  {
            System.out.println("index err");
        }
        finally {
            System.out.println("\nthis is the end");
        }


    }
}

