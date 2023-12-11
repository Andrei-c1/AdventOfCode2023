package Day6;

import utils.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day6Part2 {
    long time;
    long distance;
    

    public static void main(String[] args) {
            Day6Part2 day4Part1 = new Day6Part2();
            day4Part1.result();
        }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay6.txt");
        dataSetUp(input);
        System.out.println(calculateWinningRaces(time,distance));
    }

    private int calculateWinningRaces(Long time, Long distance) {
        int winningRaces = 0;
        for(int i=0; i<time;i++){
            if((i*(time - i)) > distance)
                winningRaces++;
        }
        return winningRaces;
    }

    private void dataSetUp(List<String> input) {
        time = Long.parseLong(input.get(0).split(":")[1].trim().replaceAll("\\s+",""));
        distance = Long.parseLong(input.get(1).split(":")[1].trim().replaceAll("\\s+",""));
    }
}
