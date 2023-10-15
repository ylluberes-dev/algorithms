import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {

        List<String> fractions = new ArrayList<>();
        for (int i = 1; i < n; i ++) { //Numerators
            for (int j = 2; j <= n; j++) { // Denominators
                if (j > n) break;
                if (i / j < 1) {
                    // if(i > j) break;
                    String fraction = i + "/" + j;
                    String simplified = simplify(fraction);
                    if (!"1".equals(simplified)) {
                        if (!fractions.contains(simplified)) {
                            fractions.add(simplified);
                        }
                    }
                }
            }
        }
        return fractions;
    }

    private static String simplify (String fraction) {
        if ("4/8".equals(fraction)) {
            System.out.println("");
        }
        String[] separated = fraction.split("/");
        int numerator = Integer.parseInt(separated[0]);
        int denominator = Integer.parseInt(separated[1]);
        int max = Math.max(denominator, numerator);
        int base = 2;
        while (true) {
            if(base == max) break;
            if (numerator % base == 0 && denominator % base == 0) {
                numerator /= base;
                denominator /= base;
            } else {
                base++;
            }
        }

        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }


    private static void printFractions (List<String> fractions) {
        fractions.stream().forEach(
                x ->{
                    System.out.println(x);
                }
        );
    }
    public static void main(String[] args) {
        System.out.println("Testing simplification method: ");
        String noSimplified = "4/3";
        String simplified = simplify(noSimplified);
        System.out.println("Simplified: "+simplified);
        List<String> result = new SimplifiedFractions().simplifiedFractions(8);
        printFractions(result);

    }
}
