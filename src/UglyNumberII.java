public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int ugly = 1;
        int counter = 0;
        while(counter != n /2) {
            if(isUgly(ugly)) {
                counter++;
               if(counter == n)
                   break;
            }
           ugly++;
        }

        System.out.println();
        while(counter != n ) {
            if(isUgly(ugly)) {
                counter++;
                if(counter == n)
                    break;
            }
            ugly++;
        }
        System.out.println();

        return ugly;
    }


        static boolean isUgly(int n) {
            while (n != 1) {
                boolean reduce = false;
                if (n % 5 == 0) {
                    n = n / 5;
                    reduce = true;
                }
                if (n % 3 == 0) {
                    n = n / 3;
                    reduce = true;
                }
                if (n % 2 == 0) {
                    n = n / 2;
                    reduce = true;
                }

                if(!reduce) return false;
            }
            return n == 1;
        }

    public static void main(String[] args) {
        //System.out.println(isUgly(7));
        System.out.println("Output: "+new UglyNumberII().nthUglyNumber(1690));
    }
}
