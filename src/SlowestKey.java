public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int releaseTime = 0;
        char candidate = ' ';
        int maxTime = -1;
        for (int i = 0; i < keysPressed.length(); i++){
            char current = keysPressed.charAt(i);
            if(i == 0){
                releaseTime = releaseTimes[0];
            }else {
                releaseTime = releaseTimes[i] - releaseTimes[i - 1];
            }
            System.out.println("Release time of -> "+current + ": "+releaseTime);
            if(releaseTime > maxTime){
                maxTime = releaseTime;
                candidate = current;
            }else if(releaseTime == maxTime){
                if(current > candidate){
                    candidate = current;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new SlowestKey().slowestKey(new int []{9,29,49,50}, "cbcd"));
    }
}
