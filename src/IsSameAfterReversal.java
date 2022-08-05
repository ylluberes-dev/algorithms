public class IsSameAfterReversal {

    public boolean isSameAfterReversals(int num) {
        final String value = String.valueOf(num);
        if(value.length() == 1 && value == "0") return true;
        if(value.charAt(value.length() - 1 ) == '0') return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
