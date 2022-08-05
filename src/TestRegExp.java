import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public   class TestRegExp {

    public TestRegExp (){

    }
    String message = "AGSUE:IMSI=370020238417679;";
    void doSomething () {
        System.out.println("Making a sound");
    }
    public static void main(String[] args) {
        String subNo = "";
        String imsi = "";
        String message = "AGSUE:IMSI=370020238417679;";
        Pattern pattern = Pattern.compile("(?<=Msisdn=|Imsi=|Imsis=)(\\d{11,15})", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            subNo = matcher.group(1);
        }

        Pattern nimsiPattern = Pattern.compile("(?<=NIMSI=)(\\d{1,15})", Pattern.CASE_INSENSITIVE);
        Matcher matchex = nimsiPattern.matcher(message);
        if (matchex.find()) {
            imsi = matchex.group(0);
        }

           String s_reqname = "NOVALUE";
           String mensaje = message.replaceAll(subNo, "");

        //Workaround to replace EKI
        if (mensaje.contains("EKI=")) {
            Pattern tempPattern = Pattern.compile("(?<=EKI=)(\\w{0,40})",
                    Pattern.CASE_INSENSITIVE);

            Matcher tempMatcher = tempPattern.matcher(mensaje);
            if (tempMatcher.find()) {
                mensaje = mensaje.replace("EKI=" + tempMatcher.group(0), "EKI=");
            }
        }

        if ((mensaje.indexOf("OICK-") > -1)
                || (mensaje.indexOf("FNUM=") > -1)
                || (mensaje.indexOf("PDPCP-") > -1)
                || (mensaje.indexOf("EQOSID=") > -1)
                || (mensaje.indexOf("APNID=") > -1)
                || (mensaje.indexOf("PDPID=") > -1)
                || (mensaje.indexOf("SCHAR-") > -1)
                || (mensaje.indexOf("INDEX=") > -1)
                || (mensaje.indexOf("PROFILE=") > -1)
                || (mensaje.indexOf("EKI=") > -1)
                || (mensaje.indexOf("KIND=") > -1)
                || (mensaje.indexOf("FSETIND=") > -1)
                || (mensaje.indexOf("A3A8IND=") > -1)
                || (mensaje.indexOf("TICK-") > -1)
                || (mensaje.indexOf("CSP-") > -1)
                || (mensaje.indexOf("SOSDCF-") > -1)
                || (mensaje.indexOf("REGSER-") > -1)
                || (mensaje.indexOf("NIMSI=") > -1)
                || (mensaje.indexOf("STYPE-") > -1)
                || (mensaje.indexOf("SS=") > -1)) {
            //mensaje = mensaje.replaceAll("[0-9]", "");
            mensaje = mensaje.replaceAll("[0-9|.]", "");

            //FIX A3A8IND parameter name
            if(mensaje.contains("AAIND="))
                mensaje = mensaje.replace("AAIND=", "A3A8IND=");
        }

        System.out.println("subNo: "+subNo);
        System.out.println("imsi: "+imsi);
        System.out.println("mensaje: "+mensaje);
        System.out.println("message: "+message);
        new TestRegExp().executeCommand("","IMSI");




    }

    public  void executeCommand(String path, String... patterns)  {
        //Hold paramters values in the same order
        List<String> stringValues = new ArrayList<String>();
        String parameterPlaceHolderString = "?";

        //Iterate all patterns to extract values and make procedure call string
        for (String patternString : patterns) {
            Pattern pattern = null;

            //TODO: Refactor this regex to make this validation with one expression
            if (patternString.contains("PDPADD")) {
                pattern = Pattern.compile("(?<=PDPADD=)(\\d{11,15}|[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})", Pattern.CASE_INSENSITIVE);
            } else if (patternString.contains("EKI")) {
                pattern = Pattern.compile("(?<=EKI=)(\\w{0,40})", Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile("(?<=" + patternString + "=|" + patternString + "-)(\\d{1,15})", Pattern.CASE_INSENSITIVE);
            }

            Matcher matchex = pattern.matcher(message);

            if (matchex.find()) {
                String value = matchex.group(0);
                stringValues.add(value);
                parameterPlaceHolderString = parameterPlaceHolderString + ",?";
            }
        }
       String value = "{call HuaweiPck.get"+ ""+("HLR_DEL_KI")+("(" + parameterPlaceHolderString + ")}");

        System.out.println(value);
    }
}
