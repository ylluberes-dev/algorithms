public class StrongPassword {

    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        final String SPECIAL_CHARS = "!@#$%^&*()-+";
        boolean oneLowerCase = false;
        boolean oneUpperCase = false;
        boolean oneDigit = false;
        boolean oneSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {

            char current = password.charAt(i);
            char prev = i > 0 ?  password.charAt(i-1) : ' ';
            if(current == prev) return false;

            if(Character.isDigit(current)) {
                oneDigit = true;
            }

            if(Character.isLowerCase(current)) {
                oneLowerCase = true;
            }

            if(Character.isUpperCase (current)) {
                oneUpperCase = true;
            }

            for (int j = 0; j < SPECIAL_CHARS.length(); j++ ) {
                if(current == SPECIAL_CHARS.charAt(j)) {
                    oneSpecialChar = true;
                    break;
                }
            }
        }

        if(oneLowerCase && oneUpperCase && oneDigit && oneSpecialChar) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new StrongPassword().strongPasswordCheckerII("IloveLe3tcode!"));
    }
}
