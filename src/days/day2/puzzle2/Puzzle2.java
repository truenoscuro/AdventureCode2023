package days.day2.puzzle2;

import days.day2.entities.Game;
import days.day2.entities.Round;
import days.day2.puzzle1.Puzzle1;
import utils.FileUtils;

public class Puzzle2  {


    public static Round minimalGame(Game game){

        Round solve = new Round();

        solve.setBlue(
                game.getRounds().stream().map(Round::getBlue).filter(b -> b!=0).max(Integer::compareTo).orElse(-1)
        );
        solve.setGreen(
                game.getRounds().stream().map(Round::getGreen).filter(b -> b!=0).max(Integer::compareTo).orElse(-1)
        );
        solve.setRed(
                game.getRounds().stream().map(Round::getRed).filter(b -> b!=0).max(Integer::compareTo).orElse(-1)
        );

        return solve;

    }

    public static int potencialGame(String text){

        return  Puzzle1.getGames(text)
                .stream()
                .map(Puzzle2::minimalGame)
                .map( round -> round.getBlue()* round.getGreen() * round.getRed())
                .reduce(Integer::sum)
                .orElse(-1);

    }


    public static void solve() {


        String text = FileUtils.content(2,2);

        System.out.println(potencialGame(text));


    }


    public static void demo() {

        String text = FileUtils.demo(2,2);

        System.out.println(potencialGame(text));




    }
}
