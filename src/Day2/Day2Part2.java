package Day2;

import utils.InputReader;

import java.util.List;
import java.util.Map;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day2Part2 {
    public int powerOfSet(String s){
        int maxGreen = 0;
        int maxRed = 0;
        int maxBlue = 0;

        List<String> games = List.of(s.split(":")[1].split(";"));
        System.out.println(games);
        for(String setOfDraws :games){
            List<String> draw = List.of(setOfDraws.split(","));

            for(String elem : draw){
                String[] elemSplit = elem.split(" ");

                if (Objects.equals(elemSplit[2], "red")) {
                    maxRed = Math.max(maxRed,Integer.parseInt(elemSplit[1]));
                } else if (Objects.equals(elemSplit[2], "blue")) {
                    maxBlue = Math.max(maxBlue,Integer.parseInt(elemSplit[1]));
                } else if (Objects.equals(elemSplit[2], "green")) {
                    maxGreen = Math.max(maxGreen,Integer.parseInt(elemSplit[1]));
                }
            }
        }
        return maxRed*maxBlue*maxGreen;
    }



    public void result(){
        List<String> input = InputReader.readInputByLine("inputs/inDay2.txt");

        int num = input.stream()
                .map(this::powerOfSet)
                .reduce(0,Integer::sum);

        System.out.println(num);
    }
    public static void main(String[] args) {
            Day2Part2 day2Part2 = new Day2Part2();
            day2Part2.result();
        }
}
