public class TestExceptionHandling {

    public void doSomething () throws Exception {
        String a = null;
        try {
            System.out.println(a.length());
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }


    Object a = new Object();

    public void byValue (Object a) {
        a = null;
    }



    public static void main(String[] args) throws  Exception{
        new TestExceptionHandling().byValue(new TestExceptionHandling().a);
        System.out.println(new TestExceptionHandling().a);
    }
}
