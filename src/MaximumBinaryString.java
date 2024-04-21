public class MaximumBinaryString {

    public String maximumBinaryString(String binary) {

        while(true){
            if(!(binary.contains("10"))){
                break;
            }
            binary = apply10(binary);
        }
        //binary = apply00(binary);

        while(true){
            if(!(binary.contains("00"))){
                break;
            }
            binary = apply00(binary);
        }

        return binary;
    }

    private static  String apply10 (String binary){
        return binary.replace("10","01");
    }

    private static String apply00 (String binary) {
        for (int i = 0; i < binary.length() -2 ; i++){
            String sub = binary.substring(i,i+2);
            if("00".equals(sub)){
                String ret = binary.substring(0,i) + "10"+binary.substring(i+2,binary.length());
                return ret;
            }
        }
        return binary;
    }
    public static void main(String[] args) {
        System.out.println("Getting max consecutive 0");
        System.out.println(new MaximumBinaryString().maximumBinaryString("1100"));
    }
}
