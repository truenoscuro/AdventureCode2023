package days.day2.puzzle1;

import days.day2.entities.Game;
import days.day2.entities.Round;
import utils.FileUtils;
import utils.WriteUtils;

import java.util.Arrays;
import java.util.List;

public class Puzzle1 {


    public static boolean isGoodGame(Game game) {

        int redMax = 12;
        int greenMax = 13;
        int blueMax = 14;

        return game.getRounds().stream()
                .allMatch((round ->
                        round.getBlue() <= blueMax
                                && round.getGreen() <= greenMax
                                && round.getRed() <= redMax)
                );
    }

    public static List<Game> getGames(String text){
        return Arrays.stream(text.split("\n"))
                .map(gameText -> {
                    Game game = new Game();
                    int numGame = WriteUtils.toInt(gameText.split(":")[0].split(" ")[1]);
                    List<String> roundsText = Arrays.stream(gameText.split(":")[1].split(";")).toList();

                    List<Round> rounds = roundsText.stream().map(roundText -> {
                        Round round = new Round();
                        Arrays.stream(roundText.split(",")).forEach(colorText -> {
                            int number = WriteUtils.toInt(colorText.replaceAll("\\D", ""));
                            String color = colorText.replaceAll("(\\d|\\s)", "");
                            switch (color) {
                                case "red" -> round.setRed(number);
                                case "blue" -> round.setBlue(number);
                                case "green" -> round.setGreen(number);
                            }

                        });
                        return round;
                    }).toList();
                    game.setNum(numGame);
                    game.setRounds(rounds);
                    return game;
                }).toList();
    }

    public static int getSumGames(String text){

        return getGames(text).stream()
                .filter(Puzzle1::isGoodGame)
                .map(Game::getNum)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    public static void demo() {


        String text = FileUtils.demo(2, 1);

        System.out.println(getSumGames(text));

    }

    public static void solve(){
        String text  = FileUtils.content(2,1);

        System.out.println(getSumGames(text));
    }

}

