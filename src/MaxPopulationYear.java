import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPopulationYear {
    public int maximumPopulation(int[][] logs) {

        int max = 0;
        String range ="";
        Map<String,Integer> table = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int population = 1;
            int startYear = logs[i][0];
            if(startYear == 2001) {
                System.out.println("");
            }
            for  (int j = 0; j < logs.length;j++) {
                if (i != j) {
                    int init = logs[j][0];
                    int end = logs[j][1];
                    if (startYear >= init && startYear < end) {
                        population++;
                    }
                }
            }
            if(population >= max){
                max = population;
                range = logs[i][0]+","+logs[i][1];
                table.put(range,max);
            }
        }
        int min = Integer.MAX_VALUE;
        for (String ranges: table.keySet()){
            if(table.get(ranges) == max){
                int currentValue = Integer.parseInt(ranges.split(",")[0]);
                if(currentValue < min){
                    min = currentValue;
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {

        int testCase_1 [][] = {{1950,1961},{1960,1971},{1970,1981}};
        int testCase_2 [][] = new int[][]{
                {2017,2038},{2001,2013},{2032,2044},{1978,2031},{1950,1973},{2043,2045},
                {2028,2049},{1979,2042},{2037,2048},{2048,2049},{1980,2021},{2047,2050},
                {1985,2014},{2028,2031},{1989,2009},{1956,1966},{2014,2043},{1993,2029},
                {1970,2036},{2013,2044}};
        //int testCase_2 [][] =
        System.out.println(new MaxPopulationYear().maximumPopulation(testCase_1));

        //2001 -> 3, 7, 10, 12, 14,  17. 18
        //2028 -> 0, 3, 6, 7, 13, 16, 17, 18, 19


    }
}
