package days.day3.puzzle2;

import days.day3.puzzle1.Puzzle1;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle2 {

    public static boolean isStar(String letter) {
        return letter.replaceAll("\\*", "").isEmpty();
    }

    public static int getGearRatio(String text, int i) {
        int[] positions = Puzzle1.positions(text, i);
        List<Integer> numbers = new ArrayList<>();
        for (int pos : positions) {
            if (Puzzle1.isNumber(Puzzle1.letter(text, pos))) {
                numbers.add(Puzzle1.getNumber(text, pos));
                text = Puzzle1.removeNumber(text, pos);

            }
        }

        return numbers.size() == 2 ? numbers.get(0) * numbers.get(1) : -1;
    }

    public static List<Integer> gearRatios(String text) {

        List<Integer> gearRatios = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (isStar(Puzzle1.letter(text, i))) {
                int value = getGearRatio(text, i);
                if (value > 0) {
                    gearRatios.add(value);
                }
            }

        }

        return gearRatios;
    }


    public static void demo() {

        String text = FileUtils.demo(3);

        System.out.println(gearRatios(text).stream().reduce(Integer::sum).orElse(-1));
    }

    public static void solve() {

        String text = FileUtils.content(3);
        System.out.println(gearRatios(text).stream().reduce(Integer::sum).orElse(-1));


    }
}
