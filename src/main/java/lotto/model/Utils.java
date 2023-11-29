package lotto.model;

import java.text.DecimalFormat;
import java.util.List;
public class Utils {
    public static DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static String listToString (List<Integer> list) {
        String result = "[";
        for(int i = 0; i < list.size(); i++) {
            result+=list.get(i);
            if(i != list.size()-1) {
                result+=", ";
            }
        }
        result+="]";
        return result;
    }

    public static String numberFormat (int number) {
        return decimalFormat.format(number);
    }

}
