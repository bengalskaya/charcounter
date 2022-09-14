package ua.com.foxminded.charcounter;

import java.util.Map;

public class CharCountFormatter {

    private static final String LEFT_SIDE = "\"";
    private static final String RIGHT_SIDE = "\" - ";

    public String formatResult(Map<Character, Integer> resultCharAmount) {
        StringBuilder formattedCharAmount = new StringBuilder();
        resultCharAmount.forEach((k, v) -> formattedCharAmount.append(LEFT_SIDE)
                                                                .append(k)
                                                                .append(RIGHT_SIDE)
                                                                .append(v).append(System.lineSeparator()));
        return formattedCharAmount.toString();
    }

}
