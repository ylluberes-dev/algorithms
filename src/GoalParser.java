public class GoalParser {


    public String interpret(String command) {
        StringBuilder parsed = new StringBuilder();

        if(!command.contains("(")){
            return command;
        }

        for (int i = 0; i < command.length() - 1; i++){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == 'a'){
                    parsed.append("al");
                    i+=3;
                }else {
                    parsed.append("o");
                    i+=1;
                }
            }else {
                parsed.append("G");
            }
        }
        if(command.length()%2 ==0 && command.charAt(command.length()-1) == 'G'){
            parsed.append("G");
        }
        return parsed.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GoalParser().interpret("(al)G(al)()()G"));
    }
}
