package days.day1.puzzle2;

import days.day1.puzzle1.Puzzle1;
import utils.FileUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle2 {


    public static Map<String, String> map = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"

    );

    public static boolean isPossibleKey(String key) {
        return map.keySet().stream().anyMatch(keyMap -> keyMap.startsWith(key));

    }

    public static boolean isNumber(String letter) {
        return (letter).replaceAll("\\d", "").isEmpty();
    }


    public static String convertTextToNumber(String text) {


        return Arrays.stream(text.split("\n"))
                .map(code -> {
                    StringBuilder newCode = new StringBuilder();
                    String regex = "(" + map.keySet().stream()
                            .reduce((acc, key) -> acc + "|" + key).orElse("") + "|[1-9])";

                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(code);
                    while (matcher.find()){
                        String key = matcher.group();
                        String resguard = "";
                        if (isNumber(key)) {
                            newCode.append(key);
                        } else {
                            //TODO esto seguro se puede hacer mejor
                            resguard = key.substring(key.length()-2 >0? key.length()-2:key.length()-1);
                            newCode.append(map.get(key));
                        }
                        code = code.replaceFirst(key,resguard);
                        matcher = pattern.matcher(code);
                    }
                    return newCode.toString();
                })
                .reduce((acc, code) -> acc + "\n" + code)
                .orElse(text);

    }

    public static void solve() {
        String text = FileUtils.content(1, 2);

        text = convertTextToNumber(text);
        System.out.println(text);

        System.out.println("-----------------------------");
        System.out.println(Puzzle1.getTotal(text));


    }
}
