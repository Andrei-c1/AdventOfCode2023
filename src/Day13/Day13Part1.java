package Day13;

import utils.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day13Part1 {
    
    public static void main(String[] args) {
        Day13Part1 day4Part1 = new Day13Part1();
        day4Part1.result();
    }

    private void result() {

        String input = InputReader.readInputAsString("inputs/inDa88.txt");

        List<String> x = Arrays.stream(input.split( "\r\n\r\n"))
                .toList();
        int total = 0;

        for(int i=0 ; i<x.size();i++){
            List<String> data = dataSetUp(x,i);
             total = total + mirror(data) *100;
            data = transposeList(data);
            total = total + mirror(data);

        }
        System.out.println(total);
    }

    private int mirror(List<String> data) {
        for(int i = 1; i< data.size(); i++){
            List<String> above = data.subList(0,i);
            List<String> below = data.subList(i, data.size());

            List<String> aboveRev = reverse(above,below.size());
            below = below.subList(0,aboveRev.size());


            if(below.equals(aboveRev))
                return i;
        }
        return 0;
    }

    private static List<String> transposeList(List<String> originalList) {

        int maxLength = originalList.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(0);


        return IntStream.range(0, maxLength)
                .mapToObj(i -> originalList.stream()
                        .filter(s -> i < s.length())
                        .map(s -> Character.toString(s.charAt(i)))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
    }
    private List<String> reverse(List<String> above, int size) {
        List<String> reversed = new ArrayList<>();

       for(int i= above.size()-1; i>=0 ;i--){
           reversed.add(above.get(i));
           if(reversed.size() == size)
               break;
       }
        return reversed;
    }

    private List<String> dataSetUp(List<String> x, int i) {
        List<String> lines = Arrays.asList(x.get(i).split("\n"));
        lines = lines.stream()
                .map(s->s.replaceAll("\r$", ""))
                .toList();
        return lines;
    }


}


