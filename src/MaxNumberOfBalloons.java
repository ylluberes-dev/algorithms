import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {


    public int maxNumberOfBalloons(String text) {
        final Map<Character, Integer> freqDictionary = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char value = text.charAt(i);
            if (value == 'b' || value == 'a' || value == 'l' || value == 'o' || value == 'n') {
                if (freqDictionary.containsKey(value)) {
                    freqDictionary.put(value, freqDictionary.get(value) + 1);
                } else {
                    freqDictionary.put(value, 1);
                }
            }
        }

        if(freqDictionary.keySet().size() < 5) return 0;

        int noOfL = freqDictionary.get('l');
        int noOfO = freqDictionary.get('o');
        int min = 0;

        if(noOfL < noOfO) {
            min = noOfL / 2;
        }else {
            min = noOfO / 2;
        }
        for (Character value : freqDictionary.keySet()) {
            int frequency = freqDictionary.get(value);
            if (min > frequency) {
                min = frequency;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
    }
}
