public class CourseScheduleII {

    //[[1,0],[2,0],[3,1],[3,2]]
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ret = new int [numCourses];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numCourses; i++) {

            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            boolean found = true;
           for (int j = 0; i < numCourses; j++) {
               if (i != j) {
                   int a1 = prerequisites[i][0];
                   int b2 = prerequisites[i][1];

                 //  if(b ==)
               }
           }
        }
        return null;
    }


}
