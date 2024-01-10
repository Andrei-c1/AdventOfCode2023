package Day10;

import utils.InputReader;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day10Part1 {
    List<List<Character>> pipeMaze ;

    public static void main(String[] args) {
        Day10Part1 day4Part1 = new Day10Part1();
        day4Part1.result();
    }

    private void result() {


        List<String> input = InputReader.readInputByLine("inputs/inDay10.txt");
        pipeMaze =input.stream()
                .map(line -> line.chars().mapToObj(c -> (char) c).toList())
                .toList();

        List<List<Character>> p = new ArrayList<>(pipeMaze);
        findNext();

    }

    private void findNext() {
        int i = 1;
        Position start = new Position(29,21,pipeMaze.get(21).get(29));
        System.out.println(start.getCharacter());
        start.findNextPosition(pipeMaze);
        while(start.getCharacter() != 'S'){
            start.findNextPosition(pipeMaze);
            i++;
        }
        System.out.println(i);

    }

    protected int findS(List<List<Character>> pipeMaze){
        for (int i = 0; i < pipeMaze.size(); i++) {
            for (int j = 0; j < pipeMaze.get(i).size(); j++) {
                if(pipeMaze.get(i).get(j) == 'S'){
                    return j+i*10;
                }
            }
        }
        return -1;
    }




}


