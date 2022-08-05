import java.util.HashMap;
import java.util.Map;

public class DetectPattern {

    static class Range {
        int start;
        int end;
        private int count;

        public Range(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }


    //2 2 2 2

    //[0,1]
    //[1,2]
    public boolean containsPattern(int[] arr, int m, int k) {

        if(m == 1 && k ==2){
            for (int i = 0 ; i < arr.length -1; i++) {
                if(arr[i] == arr[i+1]){
                    return true;
                }
            }
        }
        Map<String, Range> patternCount = new HashMap<>();
        StringBuilder patternBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i + m > arr.length) break;
                int p = 0;
                for (int j = i; p < m; j++) {
                    patternBuilder.append(arr[j]);
                    p++;
                }
            String patternValue = patternBuilder.toString();
            if (patternCount.containsKey(patternValue)) {
                 Range current = patternCount.get(patternValue);
                 if(current.start == (i-m) && current.end == i) {
                     current.setCount(current.count + 1);
                 }
                current.start = i;
                current.end = i + m;


            } else {
                patternCount.put(patternValue, new Range(i,i+m,1));
            }
            patternBuilder.delete(0,patternValue.length());
        }
        System.out.println();
        for (String key: patternCount.keySet()){

            if(patternCount.get(key).count >= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * [3,2,1,3,3,2,1,3,3,1,2,3,3,2,1,3,2,1,1]
         * 1
         * 2
         */
        System.out.println(new DetectPattern().containsPattern(new int[]{2,1,2,2,2,2,2,2}, 2, 2));
    }
}
