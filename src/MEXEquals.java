import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MEXEquals {

    /**
     * [1][2]
     * [2][3]
     *
     * @param courses
     * @param prerequisites
     * @return start at ith course (1)
     * check the prerequisite to take ith + 1
     */
    private static int completable(int courses, int[][] prerequisites) {

        for(int i = 1; i <= courses; i++) {
            boolean exists = false;
            for (int j = 0; j < prerequisites.length; j++){
                int course = prerequisites[j][1];
                if(i == course){
                    exists = true;
                    break;
                }
            }
            if(!exists) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] baseTestCase = scanner.nextLine().split(" ");
            int courses = Integer.parseInt(baseTestCase[0]);
            int preCount = Integer.parseInt(baseTestCase[1]);
            int[][] mat = new int[preCount][2];
            for (int j = 0; j < preCount; j++) {
                String[] pair = scanner.nextLine().split(" ");
                int preReq = Integer.parseInt(pair[0]);
                int course = Integer.parseInt(pair[1]);
                mat[j][0] = preReq;
                mat[j][1] = course;
              //  System.out.println("{preReq: " + preReq + " course: " + course + " }");
            }
            int result = completable(courses, mat);
            System.out.println(result);
        }

    }
}
