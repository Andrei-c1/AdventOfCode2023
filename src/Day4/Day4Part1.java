package Day4;

import utils.InputReader;

import java.util.*;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day4Part1 {



    public int findMatch(String s){

        int count = 0;

        Set<String> winningNumbers = new HashSet<>(List.of(s.split("\\|")[0].trim().replace("  ", " ").split(" ")));
        Set<String> numbers = new HashSet<>(List.of(s.split("\\|")[1].trim().replace("  ", " ").split(" ")));


        for(String elem:numbers){
            if(winningNumbers.contains(elem)){
                count++;
            }
        }


        return count;
    }


    public void result(){
        List<String> input = InputReader.readInputByLine("inputs/inDay4.txt");


        int result = input.stream()
                          .map(s-> s.split(":")[1].trim())
                          .map(this::findMatch)
                          .map(this::convertPoints)
                          .reduce(0,Integer::sum);

        System.out.println(result);

        }

    public int convertPoints(int nrMatches) {
        if (nrMatches == 0){
            return 0;
        }
        if(nrMatches == 1){
            return 1;
        }
        return (int) Math.pow(2,nrMatches-1);
    }

    public static void main(String[] args) {
            Day4Part1 day4Part1 = new Day4Part1();
            day4Part1.result();


        }

    }
