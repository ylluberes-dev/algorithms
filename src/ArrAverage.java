public class ArrAverage {


    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int arrSize = salary.length - 2;
        double average = 0;
        for (int i = 0; i < salary.length; i++) {
            if(salary[i] > max){
                max = salary[i];
            }
            if(salary[i] < min){
                min = salary[i];
            }
            average+=salary[i];
        }
        average = average - (max+min);

         return average/arrSize;
    }


    public static void main(String[] args) {
        System.out.println("Output: "+new ArrAverage().average(new int []{4000,3000,1000,2000}));
    }
}
