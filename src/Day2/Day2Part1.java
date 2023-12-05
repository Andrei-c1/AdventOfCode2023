package Day2;

import utils.InputReader;

import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day2Part1 {
    private final Map<String, Integer> maxColorMap = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14);

    public boolean winningGames(String s){
        List<String> games = List.of(s.split(":")[1].split(";"));
        System.out.println(games);
        for (String setOfDraws: games) {
            List<String> draw  = List.of(setOfDraws.split(","));
            for(String elem : draw) {
                String[] drawSplit = elem.split(" ");
                if (maxColorMap.get(drawSplit[2]) < Integer.parseInt(drawSplit[1])) {
                    return false;
                }
        }
     }
        return true;
    }



    public void result(){
        List<String> input = InputReader.readInputByLine("inputs/inDay2.txt");

        int sum = input.stream()
                       .filter(this::winningGames)
                       .map(s -> Integer.parseInt(s.split(":")[0].split(" ")[1]))
                       .reduce(0,Integer::sum);

        System.out.println(sum);


    }
    public static void main(String[] args) {
            Day2Part1 day2Part1 = new Day2Part1();
            day2Part1.result();
        }
}
