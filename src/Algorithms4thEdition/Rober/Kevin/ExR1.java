package Algorithms4thEdition.Rober.Kevin;

public class ExR1 {


    static void fun(int x)
    {
        if(x > 0)
        {
            fun(--x);
            System.out.print(x + " ");
            fun(--x);
        }
    }


    static int funA (int x, int y) {
        if( x == 0 )
            return y;
        else
            return funA(x -1, x + y);
    }
    static int fun(int a[],int n)
    {
        int x;
        if(n == 1)
            return a[0];
        else
            x = fun(a, n - 1);
        if(x > a[n - 1])
            return x;
        else
            return a[n - 1];
    }
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        System.out.println(n);
        return exR1(n-3) + n + exR1(n-2) + n; //6 6


    }

    public static void main (String [] args ) {
        fun(4);
        System.exit(0);
        System.out.println(funA(3,2));
        System.exit(0);
        System.out.println(fun(new int []{12,10,30,50,100},5));
    }
}
