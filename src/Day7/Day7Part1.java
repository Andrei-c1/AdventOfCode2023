package Day7;

import utils.InputReader;

import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day7Part1 {

    List<Hand> hands = new ArrayList<>();

    public static void main(String[] args) {
            Day7Part1 day4Part1 = new Day7Part1();
            day4Part1.result();
        }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay7.txt");
         hands = input.stream()
                .map(s-> new Hand(s))
                .collect(Collectors.toList());

        Collections.sort(hands);

        int rank = 1;
        int result = 0;
        for (Hand h:hands){
            result = result + h.getBid() * rank;
            rank++;
        }

        System.out.println(result);
        System.out.println(hands);


    }

}
