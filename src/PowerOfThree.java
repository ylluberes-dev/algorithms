public class PowerOfThree {


    public boolean powerOfThree (int n) {
        double val = Math.log10(n) / Math.log10(3);
        System.out.println(val);

        return (int) val ==  val;
    }


    public static void main(String[] args) {
       boolean isPowerOfThree =  new PowerOfThree().powerOfThree(59049);
        System.out.println("Is power of three: "+(isPowerOfThree?"Yes":"No"));
    }
}
