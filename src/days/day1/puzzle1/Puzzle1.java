package days.day1.puzzle1;


import utils.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle1 {


    public static int  getTotal(String text){

         String regex = "[A-z]";

        return Arrays.stream(text.replaceAll(regex,"")
                                .split("\n"))
                        .map( number -> {
                            String newNumber = "";
                            List<String> numbers = List.of(number.split(""));
                            newNumber = numbers.getFirst()+numbers.getLast();
                            return Integer.parseInt(newNumber);
                        })
                        .reduce(Integer::sum).orElse(-1);

    }
    public  static void  solve(){

        String text = FileUtils.content(1,1);


        System.out.println(getTotal(text));



    }

}
