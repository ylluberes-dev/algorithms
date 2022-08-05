public class ExceptionPropagation {


    public void doSomething() {
        String myStr = null;

        int a = 5 / 0;

    }

    public void caller() throws Exception {
        try {
            doSomething();
        }catch (Exception e){
            throw(e);
        }

    }


    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("a").append("b");
        System.out.println(builder.toString());

    }
}
