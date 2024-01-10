package Day8;

import utils.InputReader;
import utils.Pair;

import java.sql.SQLOutput;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day8Part1 {

    List<String> instructions = new ArrayList<>();
    Map<String, Pair<String,String>> directions = new HashMap<>();
    String start = "AAA";
    String end = "ZZZ";

    public static void main(String[] args) {
        Day8Part1 day4Part1 = new Day8Part1();
        day4Part1.result();
    }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay8.txt");
        dataSetUp(input);
        escape();

    }

    private void escape() {

        int instr = 0;
        int count = 0;

        while(!Objects.equals(start, end)){
            if(instr == instructions.size()){
                instr = 0;
            }
            start = (Objects.equals(this.instructions.get(instr), "L")) ? this.directions.get(start).getKey()
                                                                          : this.directions.get(start).getValue();
            instr++;
            count++;


        }
        System.out.println(count);
    }

    private void dataSetUp(List<String> input) {
        String dir = input.get(0);
        instructions.addAll(Arrays.asList(dir.split("")));

        int i = 2;


        while(i<input.size()){
            String first = input.get(i).split("=")[0].trim();
            String left = input.get(i).split("=")[1].trim().split(",")[0].replace("(","").trim();
            String right = input.get(i).split("=")[1].trim().split(",")[1].replace(")","").trim();
            directions.put(first,new Pair<>(left,right));
            i++;
        }


    }
}


