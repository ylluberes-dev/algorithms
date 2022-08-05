public class LogFolder {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log: logs){
            if("../".equals(log)){
                if(depth == 0)// I`m currently in the parent folder
                    continue;
                else
                    depth--;
            }else if ("./".equals(log)) {
                continue;
            }else {
                depth++;
            }

        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new LogFolder().minOperations(new String []{"d1/","../","../","../"}));
    }
}
