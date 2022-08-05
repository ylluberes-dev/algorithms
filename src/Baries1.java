public class Baries1 {

    public static void main(String[] args) {

        int count = 0;
        for(int i = 1; i <= 1536; i++) {
            String a = String.valueOf(i);
            for(int j = 0; j < a.length(); j++) {
                if(Integer.parseInt(String.valueOf(a.charAt(j))) == 6) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
