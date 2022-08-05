public class IncrementalMemoryLeak {

    public int[] memLeak(int memory1, int memory2) {

        int bits = 1;
        int crashedM1 = memory1;
        int crashedM2 = memory2;
        while (true) {
            if(bits == 36) {
                System.out.println("");
            }
            if(memory1 > memory2) {
                crashedM1 = memory1 - bits;
            }else if (memory2 > memory1){
                crashedM2 = memory2 - bits;
            }else {
                crashedM1 = memory1 - bits;
            }
            if (crashedM1 < 0 ) {
                crashedM1+= bits;
                break;
            }else if (crashedM2 < 0){
                crashedM2 += bits;
                break;
            }

            if (memory1 > memory2) {
                memory1 -= bits;
            } else if (memory2 > memory1) {
                memory2 -= bits;
            } else {
                memory1 -= bits;
            }
            bits++;
        }

        return new int[]{bits, crashedM1, crashedM2};
    }


    private static void printArr(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (i == (values.length - 1)) {
                System.out.println(values[i]);
            } else {
                System.out.print(values[i] + ", ");
            }
        }
    }

    public static void main(String[] args) {
        printArr(new IncrementalMemoryLeak().memLeak(8, 11));
    }
}
