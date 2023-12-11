package Day6;

import utils.InputReader;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day6Part1 {
    List<Integer> time = new ArrayList<>();
    List<Integer> distance = new ArrayList<>();
    

    public static void main(String[] args) {
            Day6Part1 day4Part1 = new Day6Part1();
            day4Part1.result();
        }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay6.txt");
        dataSetUp(input);
        calculateResult();
    }

    private void calculateResult() {
           int result = 1;
           for(int i=0;i<this.time.size();i++){
                result *= calculateWinningRaces(this.time.get(i),this.distance.get(i));
           }
        System.out.println(result);
    }

    private int calculateWinningRaces(Integer time, Integer distance) {
        int winningRaces = 0;
        for(int i=0; i<time;i++){
            if((i*(time - i)) > distance)
                winningRaces++;
        }
        return winningRaces;
    }

    private void dataSetUp(List<String> input) {
        time = Arrays.stream(input.get(0)
                .split(":")[1].trim()
                .split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        distance = Arrays.stream(input.get(1)
                        .split(":")[1].trim()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }
}
