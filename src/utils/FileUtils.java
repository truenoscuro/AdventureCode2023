package utils;

import java.io.*;

public class FileUtils {

    public static String absolutePath = "C:\\Users\\Nofre\\Desktop\\AdventureCode2023\\Adventure\\src";
    public static String content(int dayNumber ){
        return  getTex(dayNumber,"input.txt");


    }

    public static String demo(int dayNumber ){
        return getTex(dayNumber,"demo.txt");
    }

    private  static String getTex(int dayNumber,String filename){
        try {
            FileReader reader = new FileReader(absolutePath+"\\days\\day"+dayNumber+"\\resources\\"+filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder result= new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            reader.close();
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
