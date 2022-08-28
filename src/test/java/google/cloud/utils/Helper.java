package google.cloud.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static String getTotalEstimatedCost(String text) {
        Pattern pattern = Pattern.compile("\\d*,?\\d+.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
