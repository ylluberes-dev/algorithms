public class TestingValueReference {
    int a;
    int b;

    public TestingValueReference(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void modify (TestingValueReference obj){
        this.a = 50;
        this.b = 51;
    }

    @Override
    public String toString() {
        return "TestingValueReference{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {

        TestingValueReference t = new TestingValueReference(0,0);
        System.out.println(t);
        t.modify(t);
        System.out.println(t);
    }
}
