package days.day3.puzzle1;

import utils.FileUtils;
import utils.WriteUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle1 {


    public static boolean isSymbol(String letter) {
        return !letter.replaceAll("(\\.|\\d|\\s)", "").isEmpty();
    }

    public static boolean isNumber(String letter) {
        return letter.replaceAll("\\d", "").isEmpty();
    }


    public static int getNumber(String text, int initPos) {

        StringBuilder numberText = new StringBuilder(text.charAt(initPos) + "");
        //Hacia delante
        int i = initPos + 1;
        while (isValidPos(text, i) && isNumber(text.charAt(i) + "")) {
            numberText.append(text.charAt(i));
            i = right(i);
        }

        //Hacia atras
        i = initPos - 1;
        while (isValidPos(text, i) && isNumber(text.charAt(i) + "")) {
            numberText.insert(0, text.charAt(i));
            i = left(i);
        }

        return WriteUtils.toInt(numberText.toString());
    }

    public static boolean isValidPos(String text, int pos) {
        return pos >= 0 && pos < text.length();
    }

    public static String removeNumber(String text, int initPos) {

        StringBuilder dotes = new StringBuilder(".");
        //Hacia delante
        int r = initPos + 1;
        while (isValidPos(text, r) && isNumber(text.charAt(r) + "")) {
            r = right(r);
            dotes.append(".");
        }

        //Hacia atras
        int l = initPos - 1;
        while (isValidPos(text, l) && isNumber(text.charAt(l) + "")) {
            l = left(l);
            dotes.append(".");
        }
        return text.substring(0, Math.max(l+1, 0)) + dotes + text.substring(Math.min(r, text.length()));
    }


    public static int top(String text, int pos) {
        int length = text.split("\n")[0].length() + 1;
        return pos - length;
    }

    public static int bottom(String text, int pos) {
        int length = text.split("\n")[0].length() + 1;
        return pos + length;
    }

    public static int left(int pos) {
        return pos - 1;
    }

    public static int right(int pos) {
        return pos + 1;
    }

    public static int topLeft(String text, int pos) {
        return left(top(text, pos));
    }

    public static int topRight(String text, int pos) {
        return right(top(text, pos));
    }

    public static int bottomLeft(String text, int pos) {
        return left(bottom(text, pos));
    }

    public static int bottomRight(String text, int pos) {
        return right(bottom(text, pos));
    }

    public static String letter(String text, int pos) {
        return text.charAt(pos) + "";
    }

    public static int[] positions(String text, int initPos) {

        return Arrays.stream(new int[]{top(text, initPos), bottom(text, initPos), left(initPos),
                        right(initPos), topLeft(text, initPos), topRight(text, initPos),
                        bottomLeft(text, initPos), bottomRight(text, initPos)})
                .filter(pos -> isValidPos(text, pos)).toArray();
    }

    public static int numberPos(String text, int initPos) {

        int[] positions = positions(text, initPos);

        for (int pos : positions) {
            if (isNumber(letter(text, pos))) {
                return pos;
            }
        }

        return initPos;

    }


    public static List<Integer> code(String text) {
        List<Integer> code = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {

            if (isSymbol(letter(text, i))) {
                int pos = numberPos(text, i);
                while (pos != i) {
                    code.add(getNumber(text, pos));
                    text = removeNumber(text, pos);
                    pos = numberPos(text, i);
                }
            }

        }

        return code;

    }


    public static void demo() {

        String text = FileUtils.demo(3, 1);

        List<Integer> code = code(text);

        code.forEach(System.out::println);
        System.out.println(
                code.stream().reduce(Integer::sum).orElse(-1)
        );
    }

    public  static void solve(){

        String text = FileUtils.content(3,1);
        System.out.println(
                code(text).stream().reduce(Integer::sum).orElse(-1)
        );
    }
}
