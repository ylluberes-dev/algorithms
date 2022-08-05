import java.util.function.IntConsumer;

class FizzBuzz {


    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        printFizz = () -> System.out.println("fizz");
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        printBuzz = () -> System.out.println("buzz");
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        printFizzBuzz = () -> System.out.println("fizzbuzz");
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(n);
    }

    public static void main(String[] args) {

    }
}